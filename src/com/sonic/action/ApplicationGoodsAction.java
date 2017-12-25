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
import com.sonic.service.ApplicationGoodsService;
import com.sonic.utills.DataFromDB;
import com.sonic.utills.DateJsonValueProcessor;

public class ApplicationGoodsAction extends ActionSupport {
	private JSONObject jsonObj; 
	private ApplicationGoodsService applicationService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
   
	private List<Application> list;
	private Integer keyword;

	private Integer checkId;
	private String checkName;
	private Integer checkNumber;
	private String checkWhat;
	
	private String checkTime;
	private String applicationIds;
	private DataFromDB dataFromDB;
	public String getApplicationIds() {
		return applicationIds;
	}
	public void setApplicationIds(String applicationIds) {
		this.applicationIds = applicationIds;
	}
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
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public ApplicationGoodsService getApplicationService() {
		return applicationService;
	}
	public void setApplicationService(ApplicationGoodsService applicationService) {
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
	
	//获取所有通知 
    public String getAllGoodsApplication() { 
    	
        try {
        	String hql="from Application where applicationCategory ='goods'";
			if(keyword != null){
				System.out.println("keyword  "+keyword);
        		hql+=" where applicationNumber ="+keyword;
        		System.out.println("after add number  "+hql);
        		keyword=null;
        	}
			dataFromDB=new DataFromDB(applicationService.getGoodsApplicationList(hql,page, rows)
					,applicationService.getGoodsApplicationTotal());
			dataFromDB.setJsonAdapter();
			dataFromDB.toJsp();
			//toBeJson(applicationService.getGoodsApplicationList(hql,page, rows),applicationService.getGoodsApplicationTotal());
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    } 
    
    
    public void deleteAct(int number){
    	try {
			applicationService.deleteGoodsApplicationById(number);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	public void deleteGoodsApplicationByIds() {
		
		System.out.println("applicationIds   "+applicationIds);
		if(applicationIds.contains(",")){
			String[] strings = applicationIds.split(",");
			for(int i=0;i<strings.length;i++){
				deleteAct(Integer.parseInt(strings[i]));
			}
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"true");
		}else {
			deleteAct(Integer.parseInt(applicationIds));
		}
	}
    public String chekToPassGoods(){
		
		try{
			Application application=new Application();
			application.setApplicationCategory("goods");
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
