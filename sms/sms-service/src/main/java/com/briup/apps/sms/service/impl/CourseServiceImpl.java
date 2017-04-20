package com.briup.apps.sms.service.impl;

import com.briup.apps.sms.bean.Course;
import com.briup.apps.sms.common.BaseServiceImpl;
import com.briup.apps.sms.common.IBaseDao;
import com.briup.apps.sms.dao.CourseDao;
import com.briup.apps.sms.service.ICourseService;

public class CourseServiceImpl extends BaseServiceImpl<Course> implements ICourseService {
	private CourseDao courseDao = new CourseDao();
	
	@Override
	public IBaseDao<Course> getDao() throws Exception {
		return courseDao;
	}

}
