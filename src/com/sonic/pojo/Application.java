package com.sonic.pojo;

/**
 * Application entity. @author MyEclipse Persistence Tools
 */

public class Application implements java.io.Serializable {

	// Fields

	private Integer id;
	private String applicationName;
	private Integer applicationNumber;
	private String applicationCategory;
	private String applicationWhat;
	private String applicationTime;
	private String isPass;

	// Constructors

	/** default constructor */
	public Application() {
	}

	/** full constructor */
	public Application(String applicationName, Integer applicationNumber,
			String applicationCategory, String applicationWhat,
			String applicationTime, String isPass) {
		this.applicationName = applicationName;
		this.applicationNumber = applicationNumber;
		this.applicationCategory = applicationCategory;
		this.applicationWhat = applicationWhat;
		this.applicationTime = applicationTime;
		this.isPass = isPass;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Integer getApplicationNumber() {
		return this.applicationNumber;
	}

	public void setApplicationNumber(Integer applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationCategory() {
		return this.applicationCategory;
	}

	public void setApplicationCategory(String applicationCategory) {
		this.applicationCategory = applicationCategory;
	}

	public String getApplicationWhat() {
		return this.applicationWhat;
	}

	public void setApplicationWhat(String applicationWhat) {
		this.applicationWhat = applicationWhat;
	}

	public String getApplicationTime() {
		return this.applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getIsPass() {
		return this.isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

}