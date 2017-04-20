package com.briup.apps.sms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.apps.sms.bean.Course;
import com.briup.apps.sms.bean.Teacher;
import com.briup.apps.sms.common.IBaseDao;
import com.briup.apps.sms.common.IResultSetHander;
import com.briup.apps.sms.common.JdbcTemplate;

public class CourseDao extends JdbcTemplate<Course> implements IResultSetHander<Course>,IBaseDao<Course>  {

	@Override
	public int save(Course e) throws Exception {
		String sql = "insert into tbl_course values (null,?,?,null)";
		return super.update(sql, e.getName(),e.getCredit());
		 
	}

	@Override
	public void deleteById(long id) throws Exception {
		String sql = "delete from tbl_course where id = ?";
		super.update(sql, id);
	}

	@Override
	public void update(Course e) throws Exception {
		String sql = "update tbl_course set name =?,credit=?,teacher_id=? where id = ?";
		super.update(sql,
					e.getName(),
					e.getCredit(),
					e.getTeacher().getId(),
					e.getId());
	}

	@Override
	public List<Course> queryByExample(Course e) throws Exception {
		String sql = "select * from tbl_course where 1=1";
		
		if(e.getId()!=null){
			sql += " and id = "+e.getId();
		}
		if(e.getName()!=null){
			sql += " and name = '"+e.getName()+"'";
		}
		
		return super.query(sql, this);
	}
	
	/**
	 * 处理结果集
	 */
	@Override
	public List<Course> handler(ResultSet rs) throws Exception {
		List<Course> list = new ArrayList<Course>();
		
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			int credit = rs.getInt("credit");
			Course course = new Course(null, id, name, credit);
			//外键
			Long teacher_id = rs.getLong("teacher_id");
			if(teacher_id!=null){
				//通过teacher_id找到teacher
				TeacherDao teacherDao = new TeacherDao();
				Teacher example = new Teacher();
				example.setId(teacher_id);
				List<Teacher> tList = teacherDao.queryByExample(example);
				if(tList.size()>0){
					Teacher teacher = tList.get(0);
					course.setTeacher(teacher);
				}
			}
			
			
			
			list.add(course);
		}
		
		return list;
	}

}
