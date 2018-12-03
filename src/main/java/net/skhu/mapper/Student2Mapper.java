package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Student2;

@Mapper
public interface Student2Mapper {
	Student2 findById(int id);
	void insert(Student2 student);
	void update(Student2 student);
	void delete(Student2 student);
}
