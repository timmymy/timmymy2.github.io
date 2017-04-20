package com.briup.apps.sms.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

/**
 * 
 * jdbc模板类
 * 作用是封装了JDBC的基本操作，任何继承它的Dao层类都可以很方便的完成增删该查
 * 只需要提供必需参数即可
 * 	增删改： sql,params
 *  查询:  sql,ResultSetHandler,params
 * Dao层类在继承该类时候需要初始化泛型，表示该泛型类要处理的Pojo类
 * */
public class JdbcTemplate<E> {
	private String driver;
	private String url;
	private String user;
	private String password;

	public JdbcTemplate() {
		Properties prop = new Properties();
		try {
			
			prop.load(JdbcTemplate.class.getResourceAsStream("basicConfig.properties"));
			//prop.load(new FileInputStream("src/main/java/com/briup/apps/app01/common/basicConfig.properties"));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 封装JDBC前两步，注册驱动，获取链接
	 * */
	protected Connection getConn () throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	/**
	 * 封装JDBC最后一步，释放资源
	 * */
	private void close(ResultSet rs,PreparedStatement pstmt
			,Connection conn) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	
	/**
	 * 数据库更新操作，插入，修改，删除
	 * */
	protected int update(String sql,Object... params) 
			throws Exception{
		int num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			//动态替换占位符
			if(params != null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			num = pstmt.executeUpdate();
		} finally {
			close(null, pstmt, conn);
		}
		return num;
	}
	
	
	/**
	 * 封装了查询功能,以E为单位处理结果集
	 * @return List<E>
	 * */
	public List<E> query(String sql,IResultSetHander<E> handler
			,Object... params)throws Exception{
		List<E> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
			//调用回调函数完成结果集的处理
			list = handler.handler(rs);
			
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	/**
	 * 封装了查询功能，以任何对象为单位处理结果集。
	 * @return List<Object>
	 * */
	public List<Object> diyQuery(String sql,IResultSetHander<Object> handler
			,Object... params)throws Exception{
		List<Object> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
			//调用回调函数完成结果集的处理
			list = handler.handler(rs);
			
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}	
}
