package com.briup.apps.sms.service.impl;

import java.util.List;

import com.briup.apps.sms.bean.Student;
import com.briup.apps.sms.common.BaseServiceImpl;
import com.briup.apps.sms.common.IBaseDao;
import com.briup.apps.sms.dao.StudentDao;
import com.briup.apps.sms.service.IStudentService;

public class StudentServiceImpl 
	extends BaseServiceImpl<Student> implements IStudentService {

	private StudentDao studentDao = new StudentDao();
	
	@Override
	public IBaseDao<Student> getDao() throws Exception {
		
		return studentDao;
	}
	
	
	/**
	 * 登录
	 * */
	@Override
	public Student login(String name, String password) throws Exception {
		Student student = null;
		
		Student example = new Student();
		example.setName(name);
		List<Student> list = this.studentDao.queryByExample(example);
		if(list.size()>0){
			Student dbStudent = list.get(0);
			if(dbStudent.getPassword().equals(password)){
				student = dbStudent;
			} else {
				throw new Exception("密码错误！");
			}
			
		}else {
			throw new Exception("用户不存在");
		}
		
		return student;
	}

/**
 * 注册
 */
	 

}
