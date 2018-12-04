package com.model;
/**
 * 文章
 * @author daizj
 *
 */
public class Article {
	private Integer id;
	private String var1;//用户id
	private String var2;//类别id
	private String var3;//标题
	private String var4;//内容
	private String var5;//创建时间
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
	public String getVar5() {
		return var5;
	}
	public void setVar5(String var5) {
		this.var5 = var5;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(Integer id, String var1, String var2, String var3, String var4, String var5) {
		super();
		this.id = id;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.var4 = var4;
		this.var5 = var5;
	}
	
	
	
}
