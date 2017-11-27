package com.sonic.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Application;
import com.sonic.pojo.StuBase;
import com.sonic.service.ApplicationMoneyService;
import com.sonic.service.ApplicationService;
import com.sonic.utills.DateJsonValueProcessor;

public class ApplicationMoneyAction extends ActionSupport {
	private JSONObject jsonObj; 
	private ApplicationMoneyService applicationService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
    
    
	
	private List<Application> list;
	private String keyword;
	
	private Integer applicationId;
	

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	

	

	public ApplicationMoneyService getApplicationService() {
		return applicationService;
	}

	public void setApplicationService(ApplicationMoneyService applicationService) {
		this.applicationService = applicationService;
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

	public List<Application> getList() {
		return list;
	}

	public void setList(List<Application> list) {
		this.list = list;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	//获取所有通知
    public String getAllMoneyApplication() { 
    	
        try {
			toBeJson(applicationService.getMoneyApplicationList(page, rows),applicationService.getMoneyApplicationTotal());
			//authority = null;
			
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    } 
    
    public String applicationMoneySearch() {
		List<Application> list1 = list;
		try {
			System.out.println("keyword   " + keyword);
			String hql = "from Application where applicationCategory ='money' and applicationName like '%" + keyword
					+ "%'or applicationWhat like '%" + keyword + "%'";
			list = applicationService.getMoneyApplicationSearchList(hql, page, rows);
			System.out.println("result list size  " + list.size());
			toBeJson(list, applicationService.getMoneyApplicationSearchedTotal(hql));
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			list = list1;
			return SUCCESS;
		}
	}
    
    public String deleteMoneyApplicationById() {
		try {
			
			applicationService.deleteMoneyApplicationById(applicationId);
			return "success";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "input";

		}
	}
}
