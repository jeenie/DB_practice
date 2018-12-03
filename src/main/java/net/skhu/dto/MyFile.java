package net.skhu.dto;

import org.springframework.web.multipart.MultipartFile;

//18.12.03 디비캡스톤 기말고사
//업로드할 파일을 담을 객체
public class MyFile {
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
