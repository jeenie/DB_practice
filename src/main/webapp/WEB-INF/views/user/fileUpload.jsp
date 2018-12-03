<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>액셀 업로드</h1>
	<hr />
	<form:form method="post" modelAttribute="myFile" enctype="multipart/form-data">
		<form:input path="file" type="file" class="form-control w300" accept=".xls,xlsx"/><br />
		<button type="submit" class="btn btn-primary" value="upload">업로드</button>
	</form:form>
	<hr />
	<a href="grade" class="btn btn-primary">업로드한 성적 데이터 확인하기</a>
</body>
</html>