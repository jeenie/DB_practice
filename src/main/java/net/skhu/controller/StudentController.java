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

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.dto.Student2;
import net.skhu.dto.User;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.Student2Mapper;
import net.skhu.mapper.UserMapper;

@Controller
@RequestMapping("/user")
public class StudentController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired Student2Mapper studentMapper;
	@Autowired UserMapper userMapper;
	
	/*
	@RequestMapping(value="view", method=RequestMethod.GET)
	public String view(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		
		Student2 student = studentMapper.findById(userNumber);
		User user = userMapper.findById(userNumber);
		String password = user.getPassword();
		
		model.addAttribute("student", student);
		model.addAttribute("password", password);
		
		return "user/view";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String edit(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		int userNumber=Integer.parseInt(authentication.getName());
		
		Student2 student = studentMapper.findById(userNumber);
		User user = userMapper.findById(userNumber);
		String password = user.getPassword();
		
		model.addAttribute("student", student);
		model.addAttribute("password", password);
		
		return "user/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(Model model, Student2 student, @RequestParam("password") String password) {
		User user = userMapper.findById(student.getId());
		user.setPassword(password);
		
		userMapper.update(user);
		studentMapper.update(student);
		
		return "redirect:index";
	}
	*/
}
