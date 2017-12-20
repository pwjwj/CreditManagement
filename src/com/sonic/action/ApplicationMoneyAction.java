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
	private String rows;// ÿҳ��ʾ�ļ�¼��  
    private String page;// ��ǰ�ڼ�ҳ 
    private StuBase user;
    private String userId;
    
	private List<Application> list;
	private Integer keyword;
	
	private Integer applicationId;
	
	private Integer checkId;
	private String checkName;
	private Integer checkNumber;
	private String checkWhat;
	
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

	public Integer getKeyword() {
		return keyword;
	}

	public void setKeyword(Integer keyword) {
		this.keyword = keyword;
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
	//��ȡ�����ʽ�����
    public String getAllMoneyApplication() { 
    	
        try {
        	String hql="from Application where applicationCategory ='money'";
			if(keyword != null){
				System.out.println("keyword  "+keyword);
        		hql+=" where applicationNumber ="+keyword;
        		System.out.println("after add number  "+hql);
        		keyword=null;
        	}
			toBeJson(applicationService.getMoneyApplicationList(hql,page, rows),applicationService.getMoneyApplicationTotal());
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    } 
    
    public String deleteMoneyApplicationById() {
		try {
			applicationService.deleteMoneyApplicationById(applicationId);
			//return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return "input";
			return INPUT;
		}
	}
    
    public String chekToPassMoney(){
		try{
			Application application=new Application();
			application.setApplicationCategory("money");
			application.setApplicationName(checkName);
			System.out.println("checkName   "+checkName);
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
