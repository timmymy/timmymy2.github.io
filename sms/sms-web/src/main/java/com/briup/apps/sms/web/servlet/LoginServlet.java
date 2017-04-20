package com.briup.apps.sms.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.apps.sms.bean.Student;
import com.briup.apps.sms.service.IStudentService;
import com.briup.apps.sms.service.impl.StudentServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private IStudentService studentService = new StudentServiceImpl();
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设定编码方式
		request.setCharacterEncoding("UTF-8");
		//接受参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//处理业务逻辑
		String url = "toIndex";
		try {
			Student student = studentService.login(name, password);
			//登录成功后需要将登录者的信息维护在session中
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
		} catch (Exception e) {
			e.printStackTrace();
			url = "toLogin";
			request.setAttribute("msg", e.getMessage());
		}
		//进行页面跳转
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
