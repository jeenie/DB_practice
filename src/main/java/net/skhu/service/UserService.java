package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.User;
import net.skhu.mapper.UserMapper;

@Service
public class UserService {
	@Autowired UserMapper userMapper;

	public User login(String userId, String password) {
		int id = Integer.parseInt(userId);
		if(userMapper.findById(id) != null) {
			User user = userMapper.findById(id);
			if(user.getPassword().equals(password)==false) return null;
			return user;
		} else return null;
	}
}
