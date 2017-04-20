package com.briup.apps.sms.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.briup.apps.sms.bean.Student;
import com.briup.apps.sms.dao.StudentDao;
 


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Student student = new Student();
		
		student.setName(request.getParameter("name"));
		student.setPassword(request.getParameter("password"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setGender(request.getParameter("gender"));
		
		StudentDao dao = new StudentDao();
		int res=0;
		try {
			res = dao.checkByName(student);
			if(res==1){
				//request.setAttribute("errMsg", "<script language='javascript'>alert('该用户已经被注册！');</script>");
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			}else{
				try {
					res = dao.save(student);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		if(res==0){
			//request.setAttribute("errMsg","<script language='javascript'>alert('注册失败！请输入正确的注册信息！');</script>");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);			
		}else{
			//request.setAttribute("errMsg","<script language='javascript'>alert('注册成功！');</script>");			
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
