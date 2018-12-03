<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<script src="${R}res/common.js"></script> 
	<link rel="stylesheet" href="${R}res/common.css">
	<title>마이페이지</title>
</head>
<body>
	<div class="container">
		<h1>마이페이지</h1>
		<h2>${student.name} 님 환영합니다.</h2>
		
		<form:form method="post" modelAttribute="student">
				<div class="form-group">
					<label>학번 : </label>
					<form:input path="id" class="form-control w200" readonly="true"/>
				</div>
				<div class="form-group">
					<label>비밀번호 : </label>
					<input type="text" name="password" value="${password}" class="form-control w200" readonly/>
				</div>
				<div class="form-group">
					<label>학과 : </label>
					<form:input path="departmentName" class="form-control w200" readonly="true"/>
				</div>
				<div class="form-group">
					<label>이름 : </label>
					<form:input path="name" class="form-control w200" readonly="true"/>
				</div>
				<div class="form-group">
					<label>성별 : </label>
					<form:input path="sex" class="form-control w200" readonly="true"/>
				</div>
				<div class="form-group">
					<label>학년 : </label>
					<form:input path="year" class="form-control w200" readonly="true"/>
				</div>
				<div class="form-group">
					<label>휴대폰 : </label>
					<form:input path="phone" class="form-control w200" readonly="true"/>
				</div>
				<div class="form-group">
					<label>이메일 : </label>
					<form:input path="email" class="form-control w200" readonly="true"/>
				</div>
				<hr/>
			</form:form>
			<a href="edit" class="btn btn-primary">정보수정</a>
			<a href="fileUpload" class="btn btn-primary">파일업로드</a>
		</div>
</body>
</html>