package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 杩炴帴鏁版嵁搴�
 * @author daizj
 *
 */
public class DataBaseUtils {
/*	public static Connection getConnection(){

		Connection conn = null;
		try
		{
			try {
				//Class.forName("com.mysql.jdbc.Driver").newInstance();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			} catch (InstantiationException e) {e.printStackTrace();
			} catch (IllegalAccessException e) {e.printStackTrace();}
			//conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull","root","root");
			conn= DriverManager.getConnection("jdbc:sqlserver://192.168.123.153:1433;databaseName=blog", "sa","sa");

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}*/

	private static Connection conn;
	static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private DataBaseUtils(){
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName(SQLSERVER_DRIVER);
			System.out.println("加载数据库驱动成功");
			//"jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=mydb";
			//"jdbc:sqlserver://localhost:1433;DatabaseName=blog"
			//conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=blog", "sa", "123456");
			conn = DriverManager.getConnection("jdbc:sqlserver://192.168.123.153:1433;databaseName=news", "sa","sa");
			System.out.println("建立数据库连接");
			//String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/blog";
//加载数据库驱动
			//Class.forName("net.sourceforge.jtds.jdbc.Driver");
//通过驱动管理器来得到连接，链接的地址就是URL，用户名，密码都是sa
			//conn = DriverManager.getConnection(url,"sa","123456");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		if(null==conn){
			new DataBaseUtils();
		}
		return conn;
	}

	public static Statement createStmt(Connection conn) {
		Statement stmt = null;
		try 
		{
			stmt = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet executeQuery(PreparedStatement preparedstmt)
	{
		ResultSet rs = null;
		try {
			rs = preparedstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static PreparedStatement prepareStmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) 
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) 
	{
		if (rs != null) 
		{
			try {
				rs.close();
				}
			catch (SQLException e) 
				{
				e.printStackTrace();
				}
		}
	}
}
