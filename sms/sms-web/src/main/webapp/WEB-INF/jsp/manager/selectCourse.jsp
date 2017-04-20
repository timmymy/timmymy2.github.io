<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<title>学生信息管理系统</title>
	<link rel="stylesheet" href="../frameworks/bootstrap-3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="../frameworks/jquery-2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="../frameworks/bootstrap-3.3.0/js/bootstrap.min.js"></script>
	<script>
	$(function(){

	});
	</script>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<article>
		<form class="form-inline">
			<div class="form-group">
				<input type="search" class="form-control" placeholder="请输入关键字">
			</div>
			 <button type="submit" class="btn btn-primary">Search</button>
		</form>
		<br>
		<div class="table-responsive">
			<table class="table table-condensed table-hover table-bordered">
				<thead>
					<tr>
						<th>选择</th>
						<th>课程名称</th>
						<th>学分</th>
						<th>任课老师</th>
					</tr>	
				</thead>
				<tbody>
				<c:forEach items="${requestScope.courses }" var="course">
					<tr>
						<td><input type="checkbox" value="${course.id }"></td>
						<td>${course.name }</td>
						<td>${course.credit }</td>
						<td>${course.teacher.name }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<button class="btn btn-primary" data-toggle="modal" data-target="#studentModal">提交</button>
			
		</div>
	</article>

	
	
</body>
</html>