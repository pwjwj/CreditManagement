package com.sonic.pojo;

import java.sql.Timestamp;

/**
 * Application entity. @author MyEclipse Persistence Tools
 */

public class Application implements java.io.Serializable {

	// Fields

	private Integer id;
	private String applicationName;
	private Integer applicationNumber;
	private String applicationWhat;
	private Timestamp applicationTime;
	private String isPass;

	// Constructors

	/** default constructor */
	public Application() {
	}

	/** full constructor */
	public Application(Integer id, String applicationName,
			Integer applicationNumber, String applicationWhat,
			Timestamp applicationTime, String isPass) {
		this.id = id;
		this.applicationName = applicationName;
		this.applicationNumber = applicationNumber;
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

	public String getApplicationWhat() {
		return this.applicationWhat;
	}

	public void setApplicationWhat(String applicationWhat) {
		this.applicationWhat = applicationWhat;
	}

	public Timestamp getApplicationTime() {
		return this.applicationTime;
	}

	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getIsPass() {
		return this.isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

}