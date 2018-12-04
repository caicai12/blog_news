package com.model;
/**
 * 评论
 * @author daizj
 *
 */
public class Comment {
	private Integer id;
	private String var1;//用户id
	private String var2;//文章id
	private String var3;//评语
	private String var4;//评语时间
	
	public Comment(Integer id, String var1, String var2, String var3, String var4) {
		super();
		this.id = id;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.var4 = var4;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	public String getVar2() {
		return var2;
	}
	public void setVar2(String var2) {
		this.var2 = var2;
	}
	public String getVar3() {
		return var3;
	}
	public void setVar3(String var3) {
		this.var3 = var3;
	}
	public String getVar4() {
		return var4;
	}
	public void setVar4(String var4) {
		this.var4 = var4;
	}
	
	
	
}
