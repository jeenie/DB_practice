package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	User findById(int id);
	void insert(User user);
	void update();
	void delete();
}
