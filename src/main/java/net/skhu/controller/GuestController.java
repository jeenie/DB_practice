package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Student;
import net.skhu.dto.Student2;
import net.skhu.dto.User;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.Student2Mapper;
import net.skhu.mapper.UserMapper;

@Controller
@RequestMapping("/guest")
public class GuestController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired Student2Mapper studentMapper;
	@Autowired UserMapper userMapper;
	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Model model) {
		Student2 student = new Student2();
		model.addAttribute("student", student);
		return "student/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Model model, Student2 student, @RequestParam("password") String password) {
		User user = new User();
		user.setUserId(student.getId());
		user.setPassword(password);
		user.setUserType("학생");
		studentMapper.insert(student);
		userMapper.insert(user);
		return "redirect:/";
	}
}
