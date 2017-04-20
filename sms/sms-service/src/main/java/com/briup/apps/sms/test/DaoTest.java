package com.briup.apps.sms.test;

import java.util.List;

import com.briup.apps.sms.bean.Course;
//import com.briup.apps.sms.bean.Student;
import com.briup.apps.sms.dao.CourseDao;
//import com.briup.apps.sms.dao.StudentDao;

public class DaoTest {
	
	public static void main(String[] args) {
		
		
		//StudentDao dao = new StudentDao();
		try {
			/*
			//设定模板
			Student student = new Student();
			student.setName("terry");
			student.setGender("男");
			//模板查询
			List<Student> list = dao.queryByExample(student);
			//遍历
			for(Student s : list){
				System.out.println(s.getName()+","+s.getGender());
			}
			*/
			Course e =new Course();
			CourseDao courseDao =new CourseDao();
			List<Course> list=courseDao.queryByExample(e);
			for(Course c:list){
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
