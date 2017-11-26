package com.sonic.pojo;

/**
 * AdminSu entity. @author MyEclipse Persistence Tools
 */

public class AdminSu implements java.io.Serializable {

	// Fields

	private String username;
	private String pwd;

	// Constructors

	/** default constructor */
	public AdminSu() {
	}

	/** full constructor */
	public AdminSu(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}