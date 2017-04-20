<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>         
<header>
		<div class="navbar navbar-default">
			<div class="navbar-header">
				<!-- .navbar-toggle样式用于toggle收缩的内容，即：nav-collapse collapse样式所在的元素 -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">学生信息管理系统</a>
			</div>
			<!-- 屏幕宽度小于768像素时，该div内的内容默认都会隐藏(通过单击icon-bar所在的图标，可以再展开)；大于768像素时默认显示 -->
			<div class="collapse navbar-collapse navbar-responsive-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${pageContext.request.contextPath }/toIndex">主页</a></li>
					<li><a href="${pageContext.request.contextPath }/manager/toStudentManager">学生</a></li>
					<li><a href="${pageContext.request.contextPath }/manager/toCourseManager">课程</a></li>
					<li><a href="${pageContext.request.contextPath }/manager/toSelectCourse">选课</a></li>
				</ul>
				<c:if test="${empty sessionScope.student }">
				<ul class="nav navbar-nav pull-right hidden-xs">
					<li><a href="toRegister">注册</a></li>
					<li><a href="toLogin">登录</a></li>
				</ul>
				</c:if>
				
				<c:if test="${!empty sessionScope.student }">
				<ul class="nav navbar-nav pull-right hidden-xs">
					<li><a href="javascript:void(0)">${sessionScope.student.name }</a></li>
					<li><a href="logout">退出</a></li>
				</ul>
				</c:if>
			</div>
		</div>
	</header>