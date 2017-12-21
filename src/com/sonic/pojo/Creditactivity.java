package com.sonic.pojo;

/**
 * Creditactivity entity. @author MyEclipse Persistence Tools
 */

public class Creditactivity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer number;
	private String name;
	private String categoryId;
	private String detail;
	private String dates;

	// private String credit;
	// Constructors

	/** default constructor */
	public Creditactivity() {
	}

	/** full constructor */
	public Creditactivity(Integer number, String name, String categoryId,
			String detail, String dates) {
		this.number = number;
		this.name = name;
		this.categoryId = categoryId;
		this.detail = detail;
		this.dates = dates;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

}