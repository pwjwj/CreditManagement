//package com.sonic.action;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.sonic.pojo.StuBase;
//import com.sonic.service.BaseInfoService;
//
//public class AddBaseInfoAction extends ActionSupport {
//	
//	private String name;
//	private String college;
//	private String class_;
//	private Integer number;
//	private BaseInfoService userService;
//	public BaseInfoService getUserService() {
//		return userService;
//	}
//
//	public void setUserService(BaseInfoService userService) {
//		this.userService = userService;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCollege() {
//		return college;
//	}
//
//	public void setCollege(String college) {
//		this.college = college;
//	}
//
//	public String getClass_() {
//		return class_;
//	}
//
//	public void setClass_(String class_) {
//		this.class_ = class_;
//	}
//
//	public Integer getNumber() {
//		return number;
//	}
//
//	public void setNumber(Integer number) {
//		this.number = number;
//	}
//
//	
//
//	public String addStuBase() {
//		StuBase stu=new StuBase();
//		System.out.println("name  "+name);
//		stu.setName(name);
//		stu.setClass_(class_);
//		stu.setCollege(college);
//		stu.setNumber(number);
//		System.out.println("stu.number   " + stu.getNumber());
//		System.out.println("number   " + getNumber());
//		stu.setPwd(String.valueOf(number));
//		stu.setCredit(80);
//		System.out.println("addStuBase access");
//		try {
//			userService.saveStuBaseOrUpdate(stu);
//			return "success";
//		} catch (Exception e) {
//			System.out.print(e.getMessage());
//			return "input";
//		}
//	}
//}
