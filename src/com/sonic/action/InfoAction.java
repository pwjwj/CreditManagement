package com.sonic.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Creditcategory;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;
import com.sonic.service.InfoService;
import com.sonic.utills.DateJsonValueProcessor;

public class InfoAction extends ActionSupport {
	private JSONObject jsonObj; 
	private InfoService infoService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
    
    private String infoTittle;
	private String infoContent;
	private Integer infoId;
	private List<Info> list;
	private Integer keyword;
	
    public Integer getKeyword() {
		return keyword;
	}
	public void setKeyword(Integer keyword) {
		this.keyword = keyword;
	}
	public List<Info> getList() {
		return list;
	}
	public void setList(List<Info> list) {
		this.list = list;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getInfoTittle() {
		return infoTittle;
	}
	public void setInfoTittle(String infoTittle) {
		this.infoTittle = infoTittle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public InfoService getInfoService() {
		return infoService;
	}
	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
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
	//获取所有通知
    public String getAllInfo() { 
    	
        try {
			toBeJson(infoService.getAllInfoList(page, rows),infoService.getInfoTotal());
			//authority = null;
			
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  
    
    public String addInfo() {
		Info info = new Info();
		
		info.setInfoTittle(infoTittle);
		info.setInfoContent(infoContent);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		info.setInfoTime(df.format(new Date()));
		
		
		System.out.println("addinfo access");
		try {
			infoService.saveInfoOrUpdate(info);
			return "success";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "input";
		}
	}
    
    public String deleteInfoById() {
		try {
			
			infoService.deleteInfoById(infoId);
			return "success";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "input";

		}
	}
    
    public String infoSearch() {
		List<Info> list1 = list;
		try {
			System.out.println("keyword   " + keyword);
			String hql = "from Creditcategory where id like '%" + keyword
					+ "%'";
			list = infoService.getInfoSearchList(hql, page, rows);
			System.out.println("result list size  " + list.size());
			toBeJson(list, infoService.getInfoSearchedTotal(hql));
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			list = list1;
			return SUCCESS;
		}
	}
}
