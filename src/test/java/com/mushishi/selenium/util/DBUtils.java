package com.mushishi.selenium.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

	public Map<String, Object> findOne(String sql){
		return findOne(sql, null);
	}

	public Map<String,Object> findOne(String sql, String[] fields){
		List<Map<String, Object>> rst = null;
		try {
			rst = querySql(sql, fields);
			if (rst.size()>0){
				return rst.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String, Object>>findList(String sql){
		return findList(sql, null);
	}
	
	public List<Map<String,Object>> findList(String sql, String[] fields){
		try {
			return querySql(sql, fields);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lists.newArrayList();
	}
	
	public int update(String sql){
//		System.out.println(sql);
		try{
			return updateSql(sql);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("更新失败");
		}
	}

	private int updateSql(String sql) throws ClassNotFoundException, SQLException{
		Statement st = null;
		ResultSet rs = null;
		try{
			st = conn.createStatement();
			return st.executeUpdate(sql);
		}finally{
			try {
				if (rs != null)rs.close();
				if (st != null)st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
	
	private List<Map<String, Object>> querySql(String sql, String[] fields) throws ClassNotFoundException, SQLException{
		Statement st = null;
		ResultSet rs = null;
		try{
			st = conn.createStatement();
			rs  = st.executeQuery(sql);
			List<Map<String, Object>> list = Lists.newArrayList();
			while (rs.next()) {
				Map<String, Object> map = Maps.newLinkedHashMap();
				if(fields != null){
					for (String fieldName : fields) {
						map.put(fieldName, rs.getObject(fieldName));
					}
				}else{
					ResultSetMetaData data = rs.getMetaData();
					for(int i=1; i<=data.getColumnCount(); i++){
						map.put(data.getColumnLabel(i), rs.getObject(i));
					}
				}
				list.add(map);
			}
			return list;
		}finally{
			try {
				if (rs != null)rs.close();
				if (st != null)st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	private Connection conn;
	public DBUtils(){
		try {
			if (threadLocal.get() == null){
				threadLocal.set(getConnection("rm-2zew4899w3w8rj0x8o.mysql.rds.aliyuncs.com", "3306", "orderdb", "orderuser", "Topscore123"));

//				threadLocal.set(getConnection("rm-2zew4899w3w8rj0x8o.mysql.rds.aliyuncs.com", "3306", "orderdb", "orderuser", "Topscore123"));
//				threadLocal.set(getConnection("rm-2ze7143bv1kf37lu6o.mysql.rds.aliyuncs.com", "3306", "orderdb", "orderuser", "Topscore123"));
			}
			conn = threadLocal.get();
		} catch (Exception e) {
			throw new RuntimeException("获取数据库链接时出错");
		}
	}
	
	private Connection getConnection(String ip, String port, String dbname, String user, String pwd) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
//		"jdbc:mysql://rm-2ze7143bv1kf37lu6o.mysql.rds.aliyuncs.com:3306/orderdb?useUnicode=true&characterEncoding=utf-8"
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + dbname;
		return DriverManager.getConnection(url, user, pwd);
	}
	
	
	public static void getConnection(String ip, String port, String dbname, String user, String pwd, String type) {
		String url = "";
		Connection conn  = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			// 初始化驱动包
			try {
				// 判断需要连接的数据库类型
				if (type.equals("a")) {

					// sqlserver 连接
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					url = "jdbc:sqlserver://" + ip + ":" + port + ";databaseName=" + dbname;
				} else if (type.equals("b")) {

					// oracle 连接
					Class.forName("oracle.jdbc.driver.OracleDriver");
					url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + dbname;
				} else {
					// mysql 连接
					Class.forName("com.mysql.jdbc.Driver");
					url = "jdbc:mysql://" + ip + ":" + port + "/" + dbname;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("驱动类加载失败！");
			}

			// 连接数据库
			try {
				conn = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接失败！");
			}
			if (conn == null){
				return;
			}

			// 查询
			List<Map> list = new ArrayList<Map>();
			st = conn.createStatement();
			String sql = " select * from user ";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("rolekey", rs.getString("rolekey"));
				list.add(map);
			}
			System.out.println("2222222===" + list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭（必须有）
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
