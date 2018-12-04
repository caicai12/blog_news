package com.model;
/**
 * 类别
 * @author daizj
 *
 */
public class Genre {
	private Integer id;
	private String var1;//类别名称
	
	public Genre(Integer id, String var1) {
		super();
		this.id = id;
		this.var1 = var1;
	}
	public Genre() {
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
	
	
}
