package com.sonic.pojo;

/**
 * Info entity. @author MyEclipse Persistence Tools
 */

public class Info implements java.io.Serializable {

	// Fields

	private Integer id;
	private String infoTittle;
	private String infoContent;
	private String infoTime;

	// Constructors

	/** default constructor */
	public Info() {
	}

	/** full constructor */
	public Info(String infoTittle, String infoContent, String infoTime) {
		this.infoTittle = infoTittle;
		this.infoContent = infoContent;
		this.infoTime = infoTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfoTittle() {
		return this.infoTittle;
	}

	public void setInfoTittle(String infoTittle) {
		this.infoTittle = infoTittle;
	}

	public String getInfoContent() {
		return this.infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getInfoTime() {
		return this.infoTime;
	}

	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}

}