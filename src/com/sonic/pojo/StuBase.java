package com.sonic.pojo;

/**
 * StuBase entity. @author MyEclipse Persistence Tools
 */

public class StuBase implements java.io.Serializable {

	// Fields

	private Integer number;
	private String name;
	private String pwd;
	private String college;
	private String class_;
	private Integer credit;

	// Constructors

	/** default constructor */
	public StuBase() {
	}

	/** full constructor */
	public StuBase(Integer number, String name, String pwd, String college,
			String class_, Integer credit) {
		this.number = number;
		this.name = name;
		this.pwd = pwd;
		this.college = college;
		this.class_ = class_;
		this.credit = credit;
	}

	// Property accessors

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public static void main(String[] args) {
		
	}

}