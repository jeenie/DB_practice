package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.GradeCell;
import net.skhu.dto.Student2;
import net.skhu.dto.User;
import net.skhu.mapper.GradeCellMapper;
import net.skhu.mapper.Student2Mapper;
import net.skhu.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired Student2Mapper studentMapper;
	@Autowired GradeCellMapper gradeCellMapper;
	@Autowired UserMapper userMapper;
	
	@RequestMapping("user/index")
    public String index(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		
		Student2 student = studentMapper.findById(userNumber);
		User user = userMapper.findById(userNumber);
		String password = user.getPassword();
		model.addAttribute("student", student);
		model.addAttribute("password", password);
		
        return "user/view";
    }
	
	
	@RequestMapping("user/edit")
    public String edit(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		
		Student2 student = studentMapper.findById(userNumber);
		User user = userMapper.findById(userNumber);
		String password = user.getPassword();
		model.addAttribute("student", student);
		model.addAttribute("password", password);
		
        return "user/index";
    }
	
	@RequestMapping(value="user/edit", method=RequestMethod.POST)
	public String edit(Model model, Student2 student, @RequestParam("password") String password) {
		User user = userMapper.findById(student.getId());
		user.setPassword(password);
		
		userMapper.update(user);
		studentMapper.update(student);
		
		return "redirect:index";
	}
	
	@RequestMapping("user/grade")
    public String grade(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		
		List<GradeCell> list = gradeCellMapper.findById(userNumber);
		model.addAttribute("list", list);
		
        return "user/gradeList";
    }
	
	@RequestMapping(value="user/find", method=RequestMethod.GET)
	public String search(Model model, @RequestParam("ss")String ss, @RequestParam("st") String st) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		List<GradeCell> list= null;
		if(st.equals("0"))
			list = gradeCellMapper.findBySubjectId(userNumber, ss);
		else if(st.equals("1"))
			list = gradeCellMapper.findBySubjectName(userNumber, ss);
		
		model.addAttribute("list", list);
		model.addAttribute("ss", ss);
		model.addAttribute("st", st);
		return "user/gradeList";
			
	}
    
}
