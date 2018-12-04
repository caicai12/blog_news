package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Comment;
/**
 * 评论
 * @author daizj
 *
 */
public class CommentDao {

	/**
	 * 保存
	 * @param var1
	 * @param var2
	 * @param var3
	 * @param var4
	 */
	public void save(String var1,String var2,String var3,String var4){
		String sql = "insert into comment(var1,var2,var3,var4) values(?,?,?,?)";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, var1);
			pstmt.setString(2, var2);
			pstmt.setString(3, var3);
			pstmt.setString(4, var4);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据文章id查询
	 * @param aid
	 * @return
	 */
	public List<Comment> findListgetaid(String aid){
		List<Comment> list=new ArrayList<Comment>();
		String sql = "  select c.id,u.name var1,c.var2,c.var3,c.var4 from comment c left join users u ON c.var1=u.id  where var2="+aid;
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Comment a = new Comment();
				a.setVar1(rs.getString("var1"));
				a.setVar2(rs.getString("var2"));
				a.setVar3(rs.getString("var3"));
				a.setVar4(rs.getString("var4"));
				a.setId(rs.getInt("id"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据用户id查询自己的评论
	 * @param uid
	 * @return
	 */
	public List<Comment> findList(Integer uid){
		List<Comment> list=new ArrayList<Comment>();
		String sql = "select c.id,c.var1,a.var3 var2,c.var3,c.var4 from comment c left join article a ON c.var2=a.id where c.var1="+uid;
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Comment a = new Comment();
				a.setVar1(rs.getString("var1"));
				a.setVar2(rs.getString("var2"));
				a.setVar3(rs.getString("var3"));
				a.setVar4(rs.getString("var4"));
				a.setId(rs.getInt("id"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据id删除评论
	 * @param id
	 */
	public void del(Integer id){
		String sql = "delete from comment where id=?";
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
