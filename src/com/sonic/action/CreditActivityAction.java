package com.sonic.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;
import com.sonic.service.CreditActivityService;
import com.sonic.utills.DateJsonValueProcessor;

public class CreditActivityAction extends ActionSupport {
	private JSONObject jsonObj; 
	private CreditActivityService creditactivityService;
	private String rows;// ÿҳ��ʾ�ļ�¼��  
    private String page;// ��ǰ�ڼ�ҳ 
    private StuBase user;
    private String userId;
   
    
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
	              
	         JSONObject jobj = new JSONObject();//newһ��JSON  
	         jobj.accumulate("total",total );//total����һ���ж�������  
	         jobj.accumulate("rows", ja.fromObject(list,jconfig));//row�Ǵ�����ʾ��ҳ������  
	  
	         response.setCharacterEncoding("utf-8");//ָ��Ϊutf-8  
	         response.getWriter().write(jobj.toString());     
	    }  
	//������Ϣ�鿴  
	    public String getAllStudentCreditActivity() { 
	    	
	        try {
				toBeJson(creditactivityService.getStuCreditActivityList(page, rows),creditactivityService.getCreditActivityTotal());
				//authority = null;
				
	        } catch (Exception e) {
				e.printStackTrace();
			}
	        return null;  
	    }  
}
