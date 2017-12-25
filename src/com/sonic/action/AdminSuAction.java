package com.sonic.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Admin;
import com.sonic.pojo.StuBase;
import com.sonic.service.AdminSuService;
import com.sonic.utills.DataFromDB;
import com.sonic.utills.DateJsonValueProcessor;

public class AdminSuAction extends ActionSupport {
	private JSONObject jsonObj;
	private AdminSuService userService;
	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private StuBase user;
	
	private String userId;
	private String keyword;
	
	private String username;
	private String pwd;
	private String tel;
	private String other;
	private List<Admin> list;
	private DataFromDB dataFromDB;
	private String adminIds;
	
	public DataFromDB getDataFromDB() {
		return dataFromDB;
	}

	public void setDataFromDB(DataFromDB dataFromDB) {
		this.dataFromDB = dataFromDB;
	}

	public String getAdminIds() {
		return adminIds;
	}

	public void setAdminIds(String adminIds) {
		this.adminIds = adminIds;
	}

	public List<Admin> getList() {
		return list;
	}

	public void setList(List<Admin> list) {
		this.list = list;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public AdminSuService getUserService() {
		return userService;
	}

	public void setUserService(AdminSuService userService) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	// 查询出所有事务管理员信息
	public String getAllAdminBaseInfo() {
		try {
			String hql = "from Admin";
			if (keyword != null) {
				System.out.println("keyword  " + keyword);
				hql += " where username like '%" + keyword
						+ "%'or tel like '%" + keyword + "%'";
				System.out.println("after add keyword  " + hql);
				keyword = null;
			}
			dataFromDB=new DataFromDB(userService.getAdminBaseList(hql,page, rows)
					,userService.getAdminTotal());
			dataFromDB.setJsonAdapter();
			dataFromDB.toJsp();
			System.out.println("查询完毕");
			System.out.println(userService.getAdminTotal());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public String getCurrentAdminSu() {
		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
		System.out.println("Name  "+Name);
		if (Name == null)
			//return "login";
			return LOGIN;
		ServletActionContext.getRequest().setAttribute("currentUser",
				userService.getUser(Name));
		return SUCCESS;
	}
	
	public String addAdminBase() {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPwd(pwd);
		admin.setTel(tel);
		admin.setOther(other);	
		System.out.println("addAdmin access");
		try {
			userService.saveStuBaseOrUpdate(admin);
			//return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return "input";
			return INPUT;
		}
	}

	public void deleteAct(int number) {
		try {
			userService.deleteAdmin(number);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	public void deleteAdminByIds() {

		System.out.println("adminIds   " + adminIds);
		if (adminIds.contains(",")) {
			String[] strings = adminIds.split(",");
			for (int i = 0; i < strings.length; i++) {
				deleteAct(Integer.parseInt(strings[i]));
			}
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"true");
		} else {
			deleteAct(Integer.parseInt(adminIds));
		}
	}
}
