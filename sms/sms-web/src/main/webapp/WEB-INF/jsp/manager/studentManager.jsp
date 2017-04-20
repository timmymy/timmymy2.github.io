<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<th>学生名称</th>
						<th>密码</th>
						<th>年龄</th>
						<th>性别</th>
					</tr>	
				</thead>
				<tbody>
				<c:forEach items="${requestScope.students }" var="students">
					<tr>
						<td><input type="checkbox" value="${students.id}"></td>
						<td>${students.name }</td>
						<td>${students.password }</td>
						<td>${students.age }</td>
						<td>${students.gender }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<button class="btn btn-primary" data-toggle="modal" data-target="#studentModal">添加</button>
			<button class="btn btn-primary">修改</button>
			<button class="btn btn-primary">删除</button>
		</div>
	</article>

	<div class="modal fade" id="studentModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">添加学生信息</h4>
				</div>
				<div class="modal-body">
					<form action="login" class="form-horizontal">
						<div class="form-group has-feedback">
							<label class="control-label col-md-3">学生名称</label>
							<div class="col-md-9">
								<input type="text" name="name" class="form-control">
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							 
						</div>

						<div class="form-group">
							<label class="control-label col-md-3">密码</label>
							<div class="col-md-9">
								<input type="text" name="description" class="form-control">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3">年龄</label>
							<div class="col-md-9">
								<input type="text" name="credit" class="form-control">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3">性别</label>
							<div class="col-md-9">
								<input type="text" name="credit" class="form-control">
							</div>
						</div>

						

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>