<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>${student.name} 님 환영합니다.</h1>
	
	<a href="student/login">학생 로그인</a><br/>
	<a href="student/join">학생 등록</a><br/>
	<a href="student/list">학생 목록</a><br/>
</body>
</html>