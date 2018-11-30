package net.skhu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.MyFile;
import net.skhu.dto.StudentCell;
import net.skhu.mapper.StudentCellMapper;

@Controller
public class ExcelController {
	private String fileLocation;
	@Autowired StudentCellMapper studentCellMapper;
	
	@RequestMapping(value = "guest/fileUpload", method = RequestMethod.GET)
	public String upload(Model model) {
		MyFile myFile = new MyFile();
		model.addAttribute("myFile", myFile);
		return "student/fileUpload";
	}
	
	@RequestMapping(value = "guest/fileUpload", method = RequestMethod.POST)
	public String upload(Model model, MyFile myFile) throws IOException, ParseException{
		InputStream in = myFile.getFile().getInputStream();
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		fileLocation = path.substring(0, path.length()-1) + myFile.getFile().getOriginalFilename();
		FileOutputStream f = new FileOutputStream(fileLocation);
		int ch = 0;
		while((ch = in.read()) != -1)
			f.write(ch);
		f.flush();
		f.close();
		
		FileInputStream uploadFile = new FileInputStream(new File(fileLocation));
		Workbook workbook = new XSSFWorkbook(uploadFile);
		Sheet sheet = workbook.getSheetAt(0);
		List<StudentCell> data = new ArrayList<StudentCell>();
		int rowMax = sheet.getPhysicalNumberOfRows();
		
		for(int rowIndex = 1; rowIndex < rowMax; rowIndex++) {
			XSSFRow row = (XSSFRow) sheet.getRow(rowIndex);
			int cellMax = row.getLastCellNum();
			
			List<Object> list = new ArrayList<Object>();
			StudentCell sc = new StudentCell();
			
			for(int cellIndex=0; cellIndex < cellMax; cellIndex++) {
				XSSFCell cell = row.getCell(cellIndex);
				switch(cell.getCellTypeEnum()) {
					case NUMERIC:
						list.add(((int)cell.getNumericCellValue()));
						break;
					case STRING:
						list.add((String)cell.getStringCellValue());
						break;
					default:
						list.add(" ");
						break;
				}
			}
			
			sc.setId((int)list.get(0));
			sc.setName((String)list.get(1));
			sc.setDepartmentId((int)list.get(2));
			sc.setYear((int)list.get(3));
			
			data.add(sc);
			
		}
		
		studentCellMapper.insert(data);
		
		workbook.close();
		return "student/fileUpload";
	}
}
