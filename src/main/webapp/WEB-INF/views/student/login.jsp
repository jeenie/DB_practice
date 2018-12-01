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
	<title>학생 로그인</title>
	<style>
		input.form-control.w300 {
			width: 300px;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>학생 로그인</h1>
		<hr/>
		<form method="post" action="login_processing">
			<div class="form-group">
				<label>아이디 : </label>
				<input type="text" name="loginId" class="form-control w300" />
			</div>
			<div class="form-group">
				<label>비밀번호 : </label>
				<input type="password" name="passwd" class="form-control w300" />
			</div>
			<div>
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-ok"></span>로그인</button>
			</div>
		</form>
	</div>
</body>
</html>