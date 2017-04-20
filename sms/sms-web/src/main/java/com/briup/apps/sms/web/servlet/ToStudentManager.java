package com.briup.apps.sms.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.briup.apps.sms.bean.Student;

import com.briup.apps.sms.service.IStudentService;

import com.briup.apps.sms.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ToStudentManager
 */
@WebServlet("/manager/toStudentManager")
public class ToStudentManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IStudentService studentService = new StudentServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Student e = new Student();
			List<Student> students = studentService.query(e);
			request.setAttribute("students", students);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	
		request.getRequestDispatcher("/WEB-INF/jsp/manager/studentManager.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
