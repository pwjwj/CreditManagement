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
	private Integer adminId;
	

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
		public String getAllAdminBaseInfo() {

			try {
				toBeJson(userService.getAdminBaseList(page, rows),
						userService.getAdminTotal());
				// authority = null;
				System.out.println("查询完毕");
				System.out.println(userService.getAdminTotal());
				System.out.println(userService.getAdminBaseList(page, rows).get(0)
						.getUsername());
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
				return "login";
			ServletActionContext.getRequest().setAttribute("currentUser",
					userService.getUser(Name));
			return SUCCESS;
		}
		public String adminSearch() {
			List<Admin> list1 = list;
			try {
				System.out.println("keyword   " + keyword);
				String hql = "from Admin where username like '%" + keyword
						+ "%'or tel like '%" + keyword + "%'";
				list = userService.getAdminSearchList(hql, page, rows);
				System.out.println("result list size  " + list.size());
				toBeJson(list, userService.getSearchedTotal(hql));
				return null;
			} catch (Exception e) {
				System.out.print(e.getMessage());
				list = list1;
				return SUCCESS;
			}
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
				return "success";
			} catch (Exception e) {
				System.out.print(e.getMessage());
				return "input";
			}
		}

		public String deleteAdminById() {
			try {
				System.out.println("adminId  " + adminId);
				userService.deleteAdmin(adminId);
				return "success";
			} catch (Exception e) {
				System.out.print(e.getMessage());
				return "input";

			}
		}
}
