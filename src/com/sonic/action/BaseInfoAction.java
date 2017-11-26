package com.sonic.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;
import com.sonic.utills.DateJsonValueProcessor;

public class BaseInfoAction extends ActionSupport{
	private JSONObject jsonObj; 
	private BaseInfoService userService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
   
    
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public BaseInfoService getUserService() {
		return userService;
	}
	public void setUserService(BaseInfoService userService) {
		this.userService = userService;
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
	 
   
    public String login(){
    	StuBase users = userService.getUser(user.getName());
    	String result = ERROR;
    	
    	/*if(users != null && users.getPassword().equals(user.getPassword())){
    		if (users.getAuthority().equals("0")){
    			result="superAdmin";
    		}else if(users.getAuthority().equals("1")){
    			result="commAdmin";
    		}else if(users.getAuthority().equals("2")){
    			result="commUser";
    		}else{
    			
    		}*/
    	if(users != null && users.getPwd().equals(user.getPwd())){
    		result="commAdmin";
    		ServletActionContext.getRequest().getSession().setAttribute("userId", users.getName());
    		
    	}else{
    		ServletActionContext.getRequest().setAttribute("Erro", "密码或账号错误");
    	}
    	return result;
    }
    public String getCurrentUser(){
    	String id = (String) ServletActionContext.getRequest().getSession().getAttribute("userId");
    	if(id==null)
    		return "login";
    	ServletActionContext.getRequest().setAttribute("currentUser", userService.getUser(id));
    	return SUCCESS;
    }
    
    public String getUserByUserId(){
    	if(userId == null || userId.equals("") ){
    		userId = (String) ServletActionContext.getRequest().getAttribute("userId");
    	}
    	ServletActionContext.getRequest().setAttribute("currentUser", userService.getUser(userId));
    	return SUCCESS;
    }
    
    
    public String logout(){
    	ServletActionContext.getRequest().getSession().removeAttribute("userId");
    	return SUCCESS;
    }
    
   
    //查询出所有学生信息  
    public String getAllStudentBaseInfo() { 
    	
        try {
			toBeJson(userService.getStuBaseList(page, rows),userService.getUserTotal());
			//authority = null;
			System.out.println("查询完毕");
			System.out.println(userService.getUserTotal());
			System.out.println(userService.getStuBaseList(page, rows).get(0).getName());
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  
  
    
  /*//获取所有通知
    public String getAllInfo() { 
    	
        try {
			toBeJson(userService.getAllInfoList(page, rows),userService.getInfoTotal());
			//authority = null;
			
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  */
  /*//获取所有物资
    public String getAllGoods() { 
    	
        try {
			toBeJson(userService.getAllGoodsList(page, rows),userService.getGoodsTotal());
			//authority = null;
			
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  */
}
