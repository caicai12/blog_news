package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Article;

/**
 * 文章
 * @author daizj
 *
 */
public class ArticleDao {

	/**
	 * 保存
	 * @param var1
	 * @param var2
	 * @param var3
	 * @param var4
	 * @param var5
	 */
	public void save(String var1,String var2,String var3,String var4,String var5){
		String sql = "insert into article(var1,var2,var3,var4,var5) values(?,?,?,?,?)";
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, var1);
			pstmt.setString(2, var2);
			pstmt.setString(3, var3);
			pstmt.setString(4, var4);
			pstmt.setString(5, var5);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Article find(Integer id){
		Article a = null;
		String sql="select * from (select a.id,a.var1,g.var1 var2,a.var3,a.var4,a.var5 from article a left join genre g ON a.var2=g.id)e where e.id="+id;
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				a=new Article();
				a.setVar1(rs.getString("var1"));
				a.setVar2(rs.getString("var2"));
				a.setVar3(rs.getString("var3"));
				a.setVar4(rs.getString("var4"));
				a.setVar5(rs.getString("var5"));
				a.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * 查询自己所有的文章
	 * @param userid
	 * @return
	 */
	public List<Article> findList(Integer userid){
		List<Article> list=new ArrayList<Article>();
		String sql = "select * from (select a.id,a.var1,g.var1 var2,a.var3,a.var4,a.var5 from article a left join genre g ON a.var2=g.id)e";
		if(userid!=null){
			sql=sql +" where e.var1='"+String.valueOf(userid)+"'";
		}
		Connection conn = DataBaseUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Article a = new Article();
				a.setVar1(rs.getString("var1"));
				a.setVar2(rs.getString("var2"));
				a.setVar3(rs.getString("var3"));
				a.setVar4(rs.getString("var4"));
				a.setVar5(rs.getString("var5"));
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
		String sql = "delete from article where id=?";
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
