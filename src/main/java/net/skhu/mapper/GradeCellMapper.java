package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.GradeCell;

@Mapper
public interface GradeCellMapper {
	List<GradeCell> findById(int id);
	List<GradeCell> findBySubjectId(int id, String ss);
	List<GradeCell> findBySubjectName(int id, String ss);
	void insert(List<GradeCell> data);
}
