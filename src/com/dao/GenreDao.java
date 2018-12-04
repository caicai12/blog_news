package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Genre;
/**
 * 类别
 * @author daizj
 *
 */
public class GenreDao {
	/**
	 * 保存
	 * @param var1
	 */
	public void save(String var1){
		String sql = "insert into genre(var1) values(?)";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, var1);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Genre> findList(){
		List<Genre> list=new ArrayList<Genre>();
		String sql = "select * from genre";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Genre a = new Genre();
				a.setVar1(rs.getString("var1"));
				a.setId(rs.getInt("id"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void del(Integer id){
		String sql = "delete from genre where id=?";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
