package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Student2;

@Mapper
public interface Student2Mapper {
	// 특정학생의 정보를 조회
	Student2 findById(int id);
	// 학생 등록(생성, 가입)
	void insert(Student2 student);
	// 학생 정보 수정
	void update(Student2 student);
	// 학생 정보 삭제 -> 이번 기말고사에서는 사용x
	void delete(Student2 student);
}
