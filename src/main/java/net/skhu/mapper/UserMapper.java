package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	// 특정 사용자의 학번(ID), 비밀번호 사용자 타입 조회
	User findById(int id);
	// 사용자 등록(가입)
	void insert(User user);
	// 사용자 정보 수정, 특히 비밀번호 수정!
	void update(User user);
	
	//사용자 정보 삭제 -> 기말고사때 사용 x
	void delete();
}
