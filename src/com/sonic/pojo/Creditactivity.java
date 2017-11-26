package com.sonic.pojo;

import java.util.Date;

/**
 * Creditactivity entity. @author MyEclipse Persistence Tools
 */

public class Creditactivity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer number;
	private String categoryId;
	private String detail;
	private Date dates;

	// Constructors

	/** default constructor */
	public Creditactivity() {
	}

	/** full constructor */
	public Creditactivity(Integer id, Integer number, String categoryId,
			String detail, Date dates) {
		this.id = id;
		this.number = number;
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

	public Date getDates() {
		return this.dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

}