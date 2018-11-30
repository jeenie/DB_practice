package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;

@Controller
public class UserController {
	@Autowired StudentMapper studentMapper;
	
	@RequestMapping("success/index")
    public String index(Model model) {
		/*
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		
		Student student = studentMapper.findById(userNumber);
		model.addAttribute("student", student);
		*/
        return "user/index";
    }
}
