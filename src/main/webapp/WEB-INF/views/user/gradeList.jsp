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
	<title>학생 목록</title>
</head>
<body>
	<div class="container">
		<h1>성적 데이터</h1>
		<form action="find">
			<select name="st" class="form-control" style="float:left; margin-right:5px; width:110px">
				<option disabled value="">검색조건</option>
				<option value="0" ${st.equals("0") ? "selected":""}>과목코드</option>
				<option value="1" ${st.equals("1") ? "selected":""}>과목명</option>
			</select>
			<input type="text" name="ss" value="${ss}"class="form-control" style="width:250px;display:inline; float:left; margin-right:5px" maxlength="20"/>
			<div>
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-ok"></span>검색</button>
				</button>
			</div>
		</form>
		<table class="table table-bordered mt5">
			<thead>
				<tr>
					<th>수강년도</th>
					<th>수강학기</th>
					<th>과목코드</th>
					<th>과목명</th>
					<th>이수구분</th>
					<th>학점</th>
					<th>점수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="gradeCell" items="${ list }">
					<tr">
						<td>${ gradeCell.year }</td>
						<td>${ gradeCell.divide }</td> 
						<td>${ gradeCell.subjectCode }</td> 
						<td>${ gradeCell.subjectName }</td>
						<td>${ gradeCell.type }</td>
						<td>${ gradeCell.score }</td>
						<td>${ gradeCell.grade }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>