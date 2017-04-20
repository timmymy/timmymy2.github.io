package com.briup.apps.sms.common;

import java.util.List;

import com.briup.apps.sms.bean.Course;

public interface IBaseDao<E> {
	int save(E e) throws Exception;
	void deleteById(long id) throws Exception;
	void update(E e) throws Exception;
	List<E> queryByExample(E e) throws Exception;
}
