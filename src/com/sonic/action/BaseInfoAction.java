package com.sonic.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.sonic.pojo.Admin;
import com.sonic.pojo.AdminSu;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;
import com.sonic.utills.DateJsonValueProcessor;

public class BaseInfoAction extends ActionSupport {
	private JSONObject jsonObj;
	private BaseInfoService userService;
	private BaseInfoService prepairUserService;
	

	private String rows;// ÿҳ��ʾ�ļ�¼��
	private String page;// ��ǰ�ڼ�ҳ
	private StuBase user;
	private StuBase prepairToChangeUser;

	public StuBase getPrepairToChangeUser() {
		return prepairToChangeUser;
	}

	public void setPrepairToChangeUser(StuBase prepairToChangeUser) {
		this.prepairToChangeUser = prepairToChangeUser;
	}

	private String userId;
	private String keyword;
	private String name;
	private String college;
	private String class_;
	private Integer number;
	private Integer stuId;
	private String stuName;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public BaseInfoService getUserService() {
		return userService;
	}

	public void setUserService(BaseInfoService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
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

	private List<StuBase> list;

	public List<StuBase> getList() {
		return list;
	}

	public void setList(List<StuBase> list) {
		this.list = list;
	}
	
	public BaseInfoService getPrepairUserService() {
		return prepairUserService;
	}

	public void setPrepairUserService(BaseInfoService prepairUserService) {
		this.prepairUserService = prepairUserService;
	}

	private void toBeJson(List list, int total) throws Exception {
		JsonConfig jconfig = new JsonConfig();
		JSONArray ja = new JSONArray();
		jconfig.setIgnoreDefaultExcludes(false);
		jconfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		HttpServletResponse response = ServletActionContext.getResponse();

		JSONObject jobj = new JSONObject();// newһ��JSON
		jobj.accumulate("total", total);// total����һ���ж�������
		jobj.accumulate("rows", ja.fromObject(list, jconfig));// row�Ǵ�����ʾ��ҳ������

		response.setCharacterEncoding("utf-8");// ָ��Ϊutf-8
		response.getWriter().write(jobj.toString());
	}

	public String login() {
		Object users;
		String result = ERROR;

		if (user.getName().startsWith("T")) {
			// �������Ա
			users = (Admin) userService.getTUser(user.getName());
			if (users != null) {
				if (((Admin) users).getPwd().equals(user.getPwd())) {
					result = "commAdmin";
					ServletActionContext.getRequest().getSession().setAttribute("userName", ((Admin)users).getUsername());
				} else {
					ServletActionContext.getRequest().setAttribute("Erro",
							"������˺Ŵ���");
				}
			}

		} else if (user.getName().startsWith("S")) {
			// ��������Ա
			System.out.println("startWith S");
			users = (AdminSu) userService.getSUser(user.getName());
			if (users != null) {
				System.out.println("Not null");
				if (((AdminSu) users).getPwd().equals(user.getPwd())) {
					System.out.println("a user");
					result = "superAdmin";
					ServletActionContext.getRequest().getSession().setAttribute("userName", ((AdminSu)users).getUsername());
					System.out.println("superAdmin send completeed");
				} else {
					ServletActionContext.getRequest().setAttribute("Erro",
							"������˺Ŵ���");
				}
			}
		} else {
			// ѧ��
			users = (StuBase) userService.getUser(user.getName());
			if (users != null) {
				if (((StuBase) users).getPwd().equals(user.getPwd())) {
					result = "stu";
					ServletActionContext.getRequest().getSession().setAttribute("userName", ((StuBase)users).getName());
				} else {
					ServletActionContext.getRequest().setAttribute("Erro",
							"������˺Ŵ���");
				}
			}

		}
		/*
		 * if(users != null && users.getPassword().equals(user.getPassword())){
		 * if (users.getAuthority().equals("0")){ result="superAdmin"; }else
		 * if(users.getAuthority().equals("1")){ result="commAdmin"; }else
		 * if(users.getAuthority().equals("2")){ result="commUser"; }else{
		 * 
		 * }
		 */
		/*
		 * if(users != null && users.getPwd().equals(user.getPwd())){
		 * result="commAdmin";
		 * ServletActionContext.getRequest().getSession().setAttribute("userId",
		 * users.getName());
		 * 
		 * }else{ ServletActionContext.getRequest().setAttribute("Erro",
		 * "������˺Ŵ���"); }
		 */
		return result;
	}

	public String getCurrentAdmin() {
		
		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
		System.out.println("Name  "+Name);
		if (Name == null)
			return "login";
		ServletActionContext.getRequest().setAttribute("currentUser",
				userService.getUser(Name));
		return SUCCESS;
	}

	public String getUserByUserName() {
		System.out.println("stuName");
		if (stuName == null || stuName.equals("")) {
			stuName = (String) ServletActionContext.getRequest().getAttribute(
					"stuName");
		}
		ServletActionContext.getRequest().setAttribute("currentUser",
				userService.getUser(stuName));
		return SUCCESS;
	}

	public boolean check(StuBase u) {
		boolean flag = true;
		System.out.println("������");
		// ��֤����
		if (u.getPwd() == null || u.getPwd().trim().equals("")) {
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"���벻׼Ϊ��");
			flag = false;
		} else if (u.getPwd().length() < 6) {
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"������볤��̫С");
			flag = false;
		}
		
		System.out.println("flag  "+flag);
		return flag;
	}

	public String changeInfo() {
		System.out.println("changeInfo " + stuName);
		System.out.println("changeInfo user " + user.getName());
		System.out.println("changeInfo user " + user.getPwd());
		System.out.println("changeInfo prepairToChangeUser "
				+ prepairToChangeUser.getName());
		System.out.println("changeInfo prepairToChangeUser "
				+ prepairToChangeUser.getPwd());

		//StuBase currUser = userService.getUser(stuName);// �����ݿ�ȡ��һ��user����
													// ��ǰҪ�޸ĵ��û�ͬ��
		String result = ERROR;

		if (check(prepairToChangeUser)) {
			try {
				System.out.println("����try");
				userService.saveStuBaseOrUpdate(prepairToChangeUser);
				// userService.saveUserOrUpdate(usertmp);
				result = "mangerpage";
				System.out.println("result   " + result);
				System.out.println("һ��result��ֵ֮��");
				ServletActionContext.getRequest().getSession()
						.setAttribute("userId", user.getName());
			} catch (Exception e) {
				ServletActionContext.getRequest().setAttribute("tipMessage",
						"���û����Ѵ���!");
			}

		} else {
			result = "inputErro";
			System.out.println("result   "+result);
		}
		System.out.println("result  " + result);
		ServletActionContext.getRequest().setAttribute("userId",
				user.getName());

		return result;
	}

	public String logout() {
		ServletActionContext.getRequest().getSession()
				.removeAttribute("userId");
		return SUCCESS;
	}

	// ��ѯ������ѧ����Ϣ
	public String getAllStudentBaseInfo() {

		try {
			toBeJson(userService.getStuBaseList(page, rows),
					userService.getUserTotal());
			// authority = null;
			System.out.println("��ѯ���");
			System.out.println(userService.getUserTotal());
			System.out.println(userService.getStuBaseList(page, rows).get(0)
					.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String stuSearch() {
		List<StuBase> list1 = list;
		try {
			System.out.println("keyword   " + keyword);
			String hql = "from StuBase where name like '%" + keyword
					+ "%'or number like '%" + keyword + "%'";
			list = userService.getStuSearchList(hql, page, rows);
			System.out.println("result list size  " + list.size());
			toBeJson(list, userService.getSearchedTotal(hql));
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			list = list1;
			return SUCCESS;
		}
	}

	public String addStuBase() {
		StuBase stu = new StuBase();
		System.out.println("name  " + name);
		stu.setName(name);
		stu.setClass_(class_);
		stu.setCollege(college);
		stu.setNumber(number);
		System.out.println("stu.number   " + stu.getNumber());
		System.out.println("number   " + getNumber());
		stu.setPwd(String.valueOf(number));
		stu.setCredit(80);
		System.out.println("addStuBase access");
		try {
			userService.saveStuBaseOrUpdate(stu);
			return "success";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "input";
		}
	}

	public String deleteStuById() {
		try {
			System.out.println("stuId  " + stuId);
			userService.deleteStu(stuId);
			return "success";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "input";

		}
	}

	/*
	 * //��ȡ����֪ͨ public String getAllInfo() {
	 * 
	 * try { toBeJson(userService.getAllInfoList(page,
	 * rows),userService.getInfoTotal()); //authority = null;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return null; }
	 */
	/*
	 * //��ȡ�������� public String getAllGoods() {
	 * 
	 * try { toBeJson(userService.getAllGoodsList(page,
	 * rows),userService.getGoodsTotal()); //authority = null;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return null; }
	 */
}
