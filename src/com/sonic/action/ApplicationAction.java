package com.sonic.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Application;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;
import com.sonic.service.ApplicationService;
import com.sonic.service.GoodsService;
import com.sonic.utills.DateJsonValueProcessor;

public class ApplicationAction extends ActionSupport {
	private JSONObject jsonObj; 
	private ApplicationService applicationService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
    
    
	
	private List<Application> list;
	private String keyword;
	
	private Integer applicationId;
	
	private Integer checkId;
	private String checkName;
	private Integer checkNumber;
	private String checkWhat;
	private String checkCategory;
	private String checkTime;
	
	
	
	public Integer getCheckId() {
		return checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Integer getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Integer checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getCheckWhat() {
		return checkWhat;
	}

	public void setCheckWhat(String checkWhat) {
		this.checkWhat = checkWhat;
	}

	public String getCheckCategory() {
		return checkCategory;
	}

	public void setCheckCategory(String checkCategory) {
		this.checkCategory = checkCategory;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

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

	

	public ApplicationService getApplicationService() {
		return applicationService;
	}

	public void setApplicationService(ApplicationService applicationService) {
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
    public String getAllApplication() { 
    	
        try {
			toBeJson(applicationService.getApplicationList(page, rows),applicationService.getApplicationTotal());
			//authority = null;
			
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    } 
    
    public String applicationSearch() {
		List<Application> list1 = list;
		try {
			System.out.println("keyword   " + keyword);
			String hql = "from Application where applicationName like '%" + keyword
					+ "%'or applicationWhat like '%" + keyword + "%'";
			list = applicationService.getApplicationSearchList(hql, page, rows);
			System.out.println("result list size  " + list.size());
			toBeJson(list, applicationService.getApplicationSearchedTotal(hql));
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			list = list1;
			return SUCCESS;
		}
	}
    
    public String deleteApplicationById() {
		try {
			
			applicationService.deleteApplicationById(applicationId);
			return "success";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "input";

		}
	}
    
    public String chekToPass(){
		
		
		try{
			Application application=new Application();
			application.setApplicationCategory(checkCategory);
			application.setApplicationName(checkName);
			application.setApplicationNumber(checkNumber);
			application.setApplicationTime(checkTime);
			application.setApplicationWhat(checkWhat);
			application.setId(checkId);
			
			application.setIsPass("true");
			
			applicationService.saveApplicationOrUpdate(application);
			return SUCCESS;
		}catch(Exception e){
			System.out.print(e.getMessage());
			return INPUT;
		}
	}
}
