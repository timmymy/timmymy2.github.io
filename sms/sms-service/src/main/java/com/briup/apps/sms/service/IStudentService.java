package com.briup.apps.sms.service;

import com.briup.apps.sms.bean.Student;
import com.briup.apps.sms.common.IBaseService;

public interface IStudentService extends IBaseService<Student>{
	Student login(String name,String password) throws Exception;
	//Student register(String name,String password,Integer age,String gender) throws Exception;
}
