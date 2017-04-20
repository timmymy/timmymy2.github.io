package com.briup.apps.sms.common;

import java.util.List;

public abstract class BaseServiceImpl<E>
			implements IBaseService<E> {

	@Override
	public void save(E e) throws Exception {
		getDao().save(e);
	}

	@Override
	public void deleteById(long id) throws Exception {
		getDao().deleteById(id);
	}

	@Override
	public void update(E e) throws Exception {
		getDao().update(e);
	}

	@Override
	public List<E> query(E e) throws Exception {
		return getDao().queryByExample(e);
	}

}
