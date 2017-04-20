<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<div class="container">
		<div class="row">
			<div class="col-sm-8">
				<img src="images/school.jpg" class="img-rounded img-responsive" alt="Responsive image">
			</div>
			<div class="col-sm-4">
				<form action="register" class="form-horizontal">
					<div class="form-group has-feedback">
						<label class="control-label col-md-3">用户名</label>
						<div class="col-md-9">
							<input type="text" name="username" class="form-control">
							<span class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
						 
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">密码</label>
						<div class="col-md-9">
							<input type="password" name="password" class="form-control">
						</div>
					</div>

<!-- 					<div class="form-group"> -->
<!-- 						<label class="control-label col-md-3">重复密码</label> -->
<!-- 						<div class="col-md-9"> -->
<!-- 							<input type="password" name="password" class="form-control"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="form-group">
						<label class="control-label col-md-3">年龄</label>
						<div class="col-md-9">
							<input type="text" name="age" class="form-control">
							
						</div>
						 
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">性别</label>
						<div class="col-md-9 radio">
							<label>
								<input type="radio" name="gender" value="男">男
							</label>
							<label>
								<input type="radio" name="gender" value="女">女
							</label>
						</div>
					</div>

					

					<div class="form-group">
					    <div class="col-sm-offset-3 col-sm-9">
					      <input type="submit" class="btn btn-default" value="注册">
					    </div>
					  </div>
					
				</form>

			</div>
		</div>
	</div>
	
	
</body>
</html>