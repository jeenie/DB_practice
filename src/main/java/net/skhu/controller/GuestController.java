package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.dto.User;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.mapper.UserMapper;

@Controller
@RequestMapping("/guest")
public class GuestController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired UserMapper userMapper;
	
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(Model model) {
		Student student = new Student();
		List<Department> depts = departmentMapper.findAll();
		model.addAttribute("student", student);
		model.addAttribute("depts", depts);
		return "student/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(Model model, Student student, @RequestParam("password") String password) {
		User user = new User();
		user.setUserId(student.getId());
		user.setPassword(password);
		user.setUserType("학생");
		studentMapper.insert(student);
		userMapper.insert(user);
		return "student/join";
	}
}
