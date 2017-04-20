package com.briup.apps.sms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.apps.sms.bean.Teacher;
import com.briup.apps.sms.common.IBaseDao;
import com.briup.apps.sms.common.IResultSetHander;
import com.briup.apps.sms.common.JdbcTemplate;

public class TeacherDao extends JdbcTemplate<Teacher> implements IResultSetHander<Teacher>, IBaseDao<Teacher> {

	@Override
	public int save(Teacher e) throws Exception {
		String sql="insert into tbl_teacher values(null,?,?,?)";
		return super.update(sql, e.getId(),e.getName(),e.getPassword(),e.getGender());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		String sql ="delete * from tbl_teacher where id=?";
		super.update(sql, id);
	}

	@Override
	public void update(Teacher e) throws Exception {
		String sql="update tbl_teacher set name=?,password=?,gender=? where id=?";
		super.update(sql, e.getName(),e.getPassword(),e.getGender(),e.getId());
		
	}

	@Override
	public List<Teacher> queryByExample(Teacher e) throws Exception {
		String sql = "select * from tbl_teacher where 1=1";
		
		if(e.getId()!=null){
			sql += " and id = "+e.getId();
		}
		if(e.getName()!=null){
			sql += " and name = '"+e.getName()+"'";
		}
		
		return super.query(sql, this);
	}

	@Override
	public List<Teacher> handler(ResultSet rs) throws Exception {
		List<Teacher> list = new ArrayList<Teacher>();
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			Teacher teacher = new Teacher(id, name, password, gender);
			list.add(teacher);
		}
		return list;
	}

}
