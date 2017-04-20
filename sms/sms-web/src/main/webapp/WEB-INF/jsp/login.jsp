<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<title>学生选课系统</title>
	<link rel="stylesheet" href="frameworks/bootstrap-3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="frameworks/jquery-2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="frameworks/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>
	<div class="containr">
		<div class="row">
			<div class="col-sm-8">
				<img src="images/school.jpg" class="img-responsive" alt="Responsive image">
			</div>
			<div class="col-sm-4">
			<c:if test="${!empty msg }">
				<div class="alert alert-danger">
					${msg }
				</div>
				</c:if>
				<form action="login" class="form-horizontal">
					<div class="form-group has-feedback">
						<label class="control-label col-md-3">用户名</label>
						<div class="col-md-9">
							<input type="text" name="name" class="form-control">
							<span class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
						 
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">密码</label>
						<div class="col-md-9">
							<input type="password" name="password" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-md-9">
					      <div class="checkbox">
					        <label>
					          <input type="checkbox" name="remeber"> Remember me
					        </label>
					      </div>
					    </div>
					</div>

					<div class="form-group">
					    <div class="col-sm-offset-3 col-sm-9">
					      <input type="submit" class="btn btn-default" value="登录">
					    </div>
					  </div>
					
				</form>

			</div>
		</div>
	</div>
	
	
</body>
</html>