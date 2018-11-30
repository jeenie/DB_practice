package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.StudentCell;

@Mapper
public interface StudentCellMapper {
	void insert(List<StudentCell> data);
}
