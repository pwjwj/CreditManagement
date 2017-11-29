package com.sonic.pojo;

/**
 * CreditactivityviewId entity. @author MyEclipse Persistence Tools
 */

public class Creditactivityview implements java.io.Serializable {

	// Fields

	private Integer credit;
	private Integer id;
	private Integer number;
	private String name;
	private String categoryId;
	private String detail;
	private String dates;

	// Constructors

	/** default constructor */
	public Creditactivityview() {
	}

	/** full constructor */
	public Creditactivityview(Integer credit, Integer id, Integer number,
			String name, String categoryId, String detail, String dates) {
		this.credit = credit;
		this.id = id;
		this.number = number;
		this.name = name;
		this.categoryId = categoryId;
		this.detail = detail;
		this.dates = dates;
	}

	// Property accessors

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Creditactivityview))
			return false;
		Creditactivityview castOther = (Creditactivityview) other;

		return ((this.getCredit() == castOther.getCredit()) || (this
				.getCredit() != null && castOther.getCredit() != null && this
				.getCredit().equals(castOther.getCredit())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getNumber() == castOther.getNumber()) || (this
						.getNumber() != null && castOther.getNumber() != null && this
						.getNumber().equals(castOther.getNumber())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getCategoryId() == castOther.getCategoryId()) || (this
						.getCategoryId() != null
						&& castOther.getCategoryId() != null && this
						.getCategoryId().equals(castOther.getCategoryId())))
				&& ((this.getDetail() == castOther.getDetail()) || (this
						.getDetail() != null && castOther.getDetail() != null && this
						.getDetail().equals(castOther.getDetail())))
				&& ((this.getDates() == castOther.getDates()) || (this
						.getDates() != null && castOther.getDates() != null && this
						.getDates().equals(castOther.getDates())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCredit() == null ? 0 : this.getCredit().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getNumber() == null ? 0 : this.getNumber().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getCategoryId() == null ? 0 : this.getCategoryId()
						.hashCode());
		result = 37 * result
				+ (getDetail() == null ? 0 : this.getDetail().hashCode());
		result = 37 * result
				+ (getDates() == null ? 0 : this.getDates().hashCode());
		return result;
	}

}