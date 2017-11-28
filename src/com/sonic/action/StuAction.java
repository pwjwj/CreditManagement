package com.sonic.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Admin;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;
import com.sonic.service.AdminSuService;
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
			toBeJson(userService.getStuSelfBaseList(Name), 1);
			// authority = null;
			System.out.println("查询完毕");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getCurrentStu() {

		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
		System.out.println("Name  " + Name);
		if (Name == null)
			return "login";
		ServletActionContext.getRequest().setAttribute("currentUser",
				userService.getUser(Name));
		return SUCCESS;
	}

	public String stuSearch() {
		List<Creditactivity> list1 = list;
		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
		try {
			System.out.println("keyword   " + keyword);
			String hql = "from Creditactivity where name='" + Name
					+ "' and  detail like '%" + keyword + "%'";
			list = userService.getStuCreditActivitySearchList(hql, page, rows);
			System.out.println("result list size  " + list.size());
			toBeJson(list, userService.getSearchedTotal(hql));
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			list = list1;
			return SUCCESS;
		}
	}

	// 查询该学生所有的信用活动信息
	public String getStuSelfCreditActivity() {

		try {
			String Name = (String) ServletActionContext.getRequest()
					.getSession().getAttribute("userName");
			String hql = "from Creditactivity where name='" + Name
					+ "' ";
			//toBeJson(userService.getStuSelfCreditActivityList(Name), 1);
			toBeJson(userService.getStuSelfCreditActivityList(page, rows,Name),
					userService.getStuSelfCreditActivityTotal(hql));
			// authority = null;
			System.out.println("查询完毕");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
