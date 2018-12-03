package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.GradeCell;

@Mapper
public interface GradeCellMapper {
	// 특정학생의 학번(id)로 성적데이터 전체 조회
	List<GradeCell> findById(int id);
	// 특정학생의 학번(id)와 검색 문자열(ss)로 조회, 검색 조건 : 과목코드
	List<GradeCell> findBySubjectId(int id, String ss);
	// 특정학생의 학번(id)와 검색 문자열(ss)로 조회, 검색 조건 : 과목명
	List<GradeCell> findBySubjectName(int id, String ss);
	// 엑셀 파일 업로드 후, 그 데이터를 grade 테이블에 저장
	void insert(List<GradeCell> data);
}
