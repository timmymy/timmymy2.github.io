package com.briup.apps.sms.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.apps.sms.bean.Course;
import com.briup.apps.sms.dao.CourseDao;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/manager/addCourse")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String credit=request.getParameter("credti");
		String teacher=request.getParameter("teacher");
		Course course=new Course();
		//CourseDao cd=new CourseDao();
		try {
			//CourseDao cd=new CourseDao().save(course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/manager/courseManager.jsp").forward(request, response);
	}
		 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
