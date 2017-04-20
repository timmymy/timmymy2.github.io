package com.briup.apps.sms.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.apps.sms.bean.Course;
import com.briup.apps.sms.service.ICourseService;
import com.briup.apps.sms.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class ToCourseManager
 */
@WebServlet("/manager/toCourseManager")
public class ToCourseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ICourseService courseService = new CourseServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Course e = new Course();
			List<Course> courses = courseService.query(e);
			request.setAttribute("courses", courses);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	
		request.getRequestDispatcher("/WEB-INF/jsp/manager/courseManager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
