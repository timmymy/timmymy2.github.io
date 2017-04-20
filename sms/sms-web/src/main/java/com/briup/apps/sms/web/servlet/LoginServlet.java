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
		//�趨���뷽ʽ
		request.setCharacterEncoding("UTF-8");
		//���ܲ���
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//����ҵ���߼�
		String url = "toIndex";
		try {
			Student student = studentService.login(name, password);
			//��¼�ɹ�����Ҫ����¼�ߵ���Ϣά����session��
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
		} catch (Exception e) {
			e.printStackTrace();
			url = "toLogin";
			request.setAttribute("msg", e.getMessage());
		}
		//����ҳ����ת
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
