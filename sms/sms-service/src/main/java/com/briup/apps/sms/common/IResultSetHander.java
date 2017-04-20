package com.briup.apps.sms.common;

import java.sql.ResultSet;
import java.util.List;

public interface IResultSetHander<E> {
	
	//处理结果集的方法
	List<E> handler(ResultSet rs) throws Exception;
}
