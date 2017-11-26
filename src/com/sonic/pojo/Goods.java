package com.sonic.pojo;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String goodsName;
	private Integer goodsNumberRemain;
	private Integer goodsNumberBorrowed;
	private String goodsBorrower;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(String goodsName, Integer goodsNumberRemain,
			Integer goodsNumberBorrowed, String goodsBorrower) {
		this.goodsName = goodsName;
		this.goodsNumberRemain = goodsNumberRemain;
		this.goodsNumberBorrowed = goodsNumberBorrowed;
		this.goodsBorrower = goodsBorrower;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNumberRemain() {
		return this.goodsNumberRemain;
	}

	public void setGoodsNumberRemain(Integer goodsNumberRemain) {
		this.goodsNumberRemain = goodsNumberRemain;
	}

	public Integer getGoodsNumberBorrowed() {
		return this.goodsNumberBorrowed;
	}

	public void setGoodsNumberBorrowed(Integer goodsNumberBorrowed) {
		this.goodsNumberBorrowed = goodsNumberBorrowed;
	}

	public String getGoodsBorrower() {
		return this.goodsBorrower;
	}

	public void setGoodsBorrower(String goodsBorrower) {
		this.goodsBorrower = goodsBorrower;
	}

}