package com.sonic.pojo;

/**
 * Creditcategory entity. @author MyEclipse Persistence Tools
 */

public class Creditcategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer categoryId;
	private String categoryName;
	private String detail;
	private Integer score;

	// Constructors

	/** default constructor */
	public Creditcategory() {
	}

	/** full constructor */
	public Creditcategory(Integer categoryId, String categoryName,
			String detail, Integer score) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.detail = detail;
		this.score = score;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}