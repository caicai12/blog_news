package com.model;
/**
 * 用户
 * @author daizj
 *
 */
public class User {
	private Integer id;
	private String name;//账号
	private String pwd;//密码
	private String state;//权限
	private String email;//邮箱
	private String sex;//性别
	private String tele;//电话
	private String birth;//出生日期
	private String wechat;//微信号
	private String dscre;//描述
	private String date;//注册时间



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String pwd, String state, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.state = state;
		this.email = email;
	}
	
	
	
}
