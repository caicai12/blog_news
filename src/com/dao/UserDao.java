package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
/**
 * 用户
 * @author daizj
 *
 */
public class UserDao {
	/**
	 * 保存
	 * @param name
	 * @param pwd
	 */
	public void save(String name,String pwd,String state,String email){
		String sql = "insert into users(name,pwd,state,email) values(?,?,?,?)";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, state);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User find(Integer id){
		String sql = "select * from users where id=?";
		Connection conn = DataBaseUtils.getConnection();
		User user = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setState(rs.getString("state"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User findUser(String username, String pwd,String state){
		String sql = "select * from users where name=? and pwd=? and state=?";
		Connection conn = DataBaseUtils.getConnection();
		User user = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			pstmt.setString(3, state);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setState(rs.getString("state"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<User> findList(){
		List<User> list=new ArrayList<User>();
		String sql = "select * from users";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				User a = new User();
				a.setState(rs.getString("state"));
				a.setName(rs.getString("name"));
				a.setPwd(rs.getString("pwd"));
				a.setEmail(rs.getString("email"));
				a.setId(rs.getInt("id"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void del(Integer id){
		String sql = "delete from users where id=?";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id修改密码
	 * @param id
	 */
	public void update(Integer id,String pwd){
		String sql = "UPDATE users SET pwd=? where id=?";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
