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
import com.sonic.pojo.Application;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;
import com.sonic.service.StuService;
import com.sonic.utills.DateJsonValueProcessor;

public class StuAction extends ActionSupport {
	private JSONObject jsonObj;
	private StuService userService;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public StuService getUserService() {
		return userService;
	}

	public void setUserService(StuService userService) {
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private StuBase user;

	private String userId;
	private String keyword;

	private Integer number;
	private String name;
	private String pwd;
	private String college;
	private String class_;
	private Integer credit;

	private List<Creditactivity> list;
	private List<Info> infoList;
	private Integer currentStuNumber;
	private StuBase prepairToChangeStuBase;
	private String applicationCategory;
	private String applicationWhat;
	public String getApplicationCategory() {
		return applicationCategory;
	}

	public void setApplicationCategory(String applicationCategory) {
		this.applicationCategory = applicationCategory;
	}

	public String getApplicationWhat() {
		return applicationWhat;
	}

	public void setApplicationWhat(String applicationWhat) {
		this.applicationWhat = applicationWhat;
	}

	public List<Info> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<Info> infoList) {
		this.infoList = infoList;
	}

	public StuBase getPrepairToChangeStuBase() {
		return prepairToChangeStuBase;
	}

	public void setPrepairToChangeStuBase(StuBase prepairToChangeStuBase) {
		this.prepairToChangeStuBase = prepairToChangeStuBase;
	}

	public Integer getCurrentStuNumber() {
		return currentStuNumber;
	}

	public void setCurrentStuNumber(Integer currentStuNumber) {
		this.currentStuNumber = currentStuNumber;
	}

	public List<Creditactivity> getList() {
		return list;
	}

	public void setList(List<Creditactivity> list) {
		this.list = list;
	}

	private void toBeJson(List list, int total) throws Exception {
		JsonConfig jconfig = new JsonConfig();
		JSONArray ja = new JSONArray();
		jconfig.setIgnoreDefaultExcludes(false);
		jconfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		HttpServletResponse response = ServletActionContext.getResponse();

		JSONObject jobj = new JSONObject();// new一个JSON
		jobj.accumulate("total", total);// total代表一共有多少数据
		jobj.accumulate("rows", ja.fromObject(list, jconfig));// row是代表显示的页的数据

		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.getWriter().write(jobj.toString());
	}

	// 查询出所有学生信息
	public String getStuSelfBaseInfo() {

		try {
			String Name = (String) ServletActionContext.getRequest()
					.getSession().getAttribute("userName");
			String actualName=(Name.split("/"))[0];
			toBeJson(userService.getStuSelfBaseList(actualName), 1);
			System.out.println("查询完毕");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getCurrentStu() {
		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
		String actualName=(Name.split("/"))[0];
		System.out.println("Name  " + Name);
		if (actualName == null)
			return "login";
		ServletActionContext.getRequest().setAttribute("currentUser",
				userService.getUser(actualName));
		return SUCCESS;
	}

	// 查询该学生所有的信用活动信息
	public String getStuSelfCreditActivity() {
		try {
			String Name = (String) ServletActionContext.getRequest()
					.getSession().getAttribute("userName");
			String actualName=(Name.split("/"))[0];
			String hql = "from Creditactivity where name='" + actualName
					+ "' ";
			toBeJson(userService.getStuSelfCreditActivityList(page, rows,actualName),
					userService.getStuSelfCreditActivityTotal(hql));
			System.out.println("查询完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getCurrentStuByNumber() {
		System.out.println("currentStuNumber"+currentStuNumber);
		if (currentStuNumber == null || currentStuNumber.equals("")) {
			currentStuNumber = (Integer) ServletActionContext.getRequest().getAttribute(
					"currentStuNumber");
		}
		ServletActionContext.getRequest().setAttribute("currentLoginStu",
				userService.getStuByNumber(currentStuNumber));
		return SUCCESS;
	}
	
	public String modifyLoginedStuInfo(){
		try{
			userService.saveStuBaseOrUpdate(prepairToChangeStuBase);
			return SUCCESS;
		}catch(Exception e){
			System.out.print(e.getMessage());
			return INPUT;
		}
	}
	
	public String getAllInfoStu() { 
        try {
			toBeJson(userService.getAllInfoList(page, rows),userService.getInfoTotal());
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  
	
	public String getAllApplicationStu() { 
    	
        try {
        	String Name = (String) ServletActionContext.getRequest().getSession()
    				.getAttribute("userName");
        	String actualName=(Name.split("/"))[0];
        	int actualNumber=Integer.parseInt((Name.split("/"))[1]);
			toBeJson(userService.getAllApplicationsList(page, rows,actualName,actualNumber),userService.getApplicationsTotal(actualName,actualNumber));
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  
	
	public String addStuApplication() {
		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
    	String actualName=(Name.split("/"))[0];
    	int actualNumber=Integer.parseInt((Name.split("/"))[1]);
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Application application = new Application();
		application.setApplicationCategory(applicationCategory);
		application.setApplicationWhat(applicationWhat);
		application.setApplicationName(actualName);
		application.setApplicationNumber(actualNumber);
		application.setApplicationTime(df.format(new Date()));
		application.setIsPass("false");
		System.out.println("addApplicationStuSelf access");
		try {
			userService.saveApplocationSelfOrUpdate(application);
			//return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return "input";
			return INPUT;
		}
	}
}
