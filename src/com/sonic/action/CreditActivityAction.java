package com.sonic.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;
import com.sonic.service.CreditActivityService;
import com.sonic.utills.DateJsonValueProcessor;

public class CreditActivityAction extends ActionSupport {
	private JSONObject jsonObj; 
	private CreditActivityService creditactivityService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
   
    private Integer id;
	private Integer number;
	private String categoryId;
	private String detail;
	private Date dates;
	
	
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	public CreditActivityService getCreditactivityService() {
		return creditactivityService;
	}
	public void setCreditactivityService(CreditActivityService creditactivityService) {
		this.creditactivityService = creditactivityService;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public StuBase getUser() {
		return user;
	}
	public void setUser(StuBase user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	 
	 private void toBeJson(List list,int total) throws Exception{ 
	    	JsonConfig jconfig = new JsonConfig();
	    	JSONArray ja = new JSONArray(); 
	    	jconfig.setIgnoreDefaultExcludes(false);
	    	jconfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));

	         HttpServletResponse response = ServletActionContext.getResponse();  
	              
	         JSONObject jobj = new JSONObject();//new一个JSON  
	         jobj.accumulate("total",total );//total代表一共有多少数据  
	         jobj.accumulate("rows", ja.fromObject(list,jconfig));//row是代表显示的页的数据  
	  
	         response.setCharacterEncoding("utf-8");//指定为utf-8  
	         response.getWriter().write(jobj.toString());     
	    }  
	//信用信息查看  
	    public String getAllStudentCreditActivity() { 
	    	
	        try {
				toBeJson(creditactivityService.getStuCreditActivityList(page, rows),creditactivityService.getCreditActivityTotal());
				//authority = null;
				
	        } catch (Exception e) {
				e.printStackTrace();
			}
	        return null;  
	    }  
	    
	    
	    public String addCreditActivity() {
			Creditactivity ca = new Creditactivity();
			System.out.println("number  " + number);
			ca.setNumber(number);
			ca.setDates(dates);
			ca.setDetail(detail);
			ca.setCategoryId(categoryId);
			
			System.out.println("ca.number   " + ca.getNumber());
			System.out.println("number   " + getNumber());
			System.out.println("addStuBase access");
			try {
				creditactivityService.saveCreditActivityOrUpdate(ca);
				return "success";
			} catch (Exception e) {
				System.out.print(e.getMessage());
				return "input";
			}
		}
}
