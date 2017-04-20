package com.briup.apps.sms.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.apps.sms.bean.Student;
import com.briup.apps.sms.common.IBaseDao;
import com.briup.apps.sms.common.IResultSetHander;
import com.briup.apps.sms.common.JdbcTemplate;

public class StudentDao extends JdbcTemplate<Student> 
	implements IBaseDao<Student> , IResultSetHander<Student>{
	

	
	/**
	 * 回调函数
	 * 用来处理结果集
	 * */
	@Override
	public List<Student> handler(ResultSet rs) throws Exception {
		List<Student> list = new ArrayList<>();
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			int age = rs.getInt("age");
			Student student = new Student(id, name, password, age, gender);
			list.add(student);
		}
		return list;
	}

	@Override
	public int save(Student e) throws Exception {
		String sql = "insert into tbl_student values(null,?,?,?,?)";
		return super.update(sql, e.getName(),e.getPassword(),e.getAge(),e.getGender());
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		String sql = "delete from tbl_student where id = ?";
		super.update(sql, id);
		
	}

	@Override
	public void update(Student e) throws Exception {
		String sql = "update tbl_student "
				+ "set name = ?,password = ?,age = ?,gender = ? "
				+ "where id = ?";
		super.update(sql, e.getName(),e.getPassword(),e.getAge(),e.getGender(),e.getId());
	}

	@Override
	public List<Student> queryByExample(Student e) throws Exception {

		String sql = "select * from tbl_student where 1=1";
		if(e!=null){
			if(e.getId()!=null){
				sql += " and id = "+e.getId();
			}
			if(e.getName()!=null){
				sql += " and name = '"+e.getName()+"'";
			}
			if(e.getAge()!=null){
				sql += " and age = "+e.getAge();
			}
			if(e.getGender()!=null){
				sql += " and gender = '"+e.getGender()+"'";
			}
		}
		System.out.println(sql);
		
		return super.query(sql, this);
	}
	//根据用户名检验用户名是否存在于数据库中,用于注册验证
	public int checkByName (Student student) throws SQLException{
		int res = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from tbl_student where name=?";
		//if (student == null || student.getName().equals(""))
			//return 0;
		try {
		try {
			pstmt = getConn().prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pstmt.setString(1, student.getName());
		rs=pstmt.executeQuery();
		if(rs.next()){
			res=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			pstmt.close();
		}
		return res;
	}

}
