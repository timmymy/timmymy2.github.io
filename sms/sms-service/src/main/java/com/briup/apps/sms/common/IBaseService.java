package com.briup.apps.sms.common;

import java.util.List;

public interface IBaseService<E> {
	//获取dao层类，这个方法在BaseServiceImpl中无法封装，必须让BaseServiceImpl的子类实现
	IBaseDao<E> getDao() throws Exception;
	//添加
	void save(E e) throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	//更新
	void update(E e) throws Exception;
	//查询
	List<E> query(E e) throws Exception;
}
