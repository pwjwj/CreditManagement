package com.sonic.action;

import java.io.File;
import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import net.sf.json.JSONArray;
=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Admin;
import com.sonic.pojo.AdminSu;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;
import com.sonic.utills.DataFromDB;
<<<<<<< HEAD
import com.sonic.utills.DateJsonValueProcessor;
=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
import com.sonic.utills.FileUtils;

public class BaseInfoAction extends ActionSupport {
	private JSONObject jsonObj;
	private BaseInfoService userService;
	private BaseInfoService prepairUserService;
	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private StuBase user;
	private StuBase prepairToChangeUser;
	private Admin prepairToChangeAdmin;

	private String userId;
	private Integer keyword;
	private String name;
	private String college;
	private String class_;
	private Integer number;
	private Integer stuId;
	private String stuName;
<<<<<<< HEAD

	private String stuIds;
	private File source;
	private DataFromDB dataFromDB;
	private boolean isWriteSuccess=false;
	
	private String AdminName;
=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa

	private String stuIds;
	private File source;

<<<<<<< HEAD
=======
	private DataFromDB dataFromDB;
	private boolean isWriteSuccess=false;
	
	private String AdminName;


>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
<<<<<<< HEAD

=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
	public File getSource() {
		return source;
	}

	public void setSource(File source) {
		this.source = source;
	}

	public String getStuIds() {
		return stuIds;
	}

	public void setStuIds(String stuIds) {
		this.stuIds = stuIds;
	}

	public Admin getPrepairToChangeAdmin() {
		return prepairToChangeAdmin;
	}

	public void setPrepairToChangeAdmin(Admin prepairToChangeAdmin) {
		this.prepairToChangeAdmin = prepairToChangeAdmin;
	}

	private Integer adminId;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public StuBase getPrepairToChangeUser() {
		return prepairToChangeUser;
	}

	public void setPrepairToChangeUser(StuBase prepairToChangeUser) {
		this.prepairToChangeUser = prepairToChangeUser;
	}
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

	public Integer getKeyword() {
		return keyword;
	}

	public void setKeyword(Integer keyword) {
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

	/*private void toBeJson(List list, int total) throws Exception {
		
		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.getWriter().write();
	}*/

	public void toDataGrid(String gridData) throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.getWriter().write(gridData);
<<<<<<< HEAD
		System.out.println("gridData  "+gridData);
=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
	}
	public String login() {
		Object users;
		String result = ERROR;
		if (user.getName().startsWith("T")) {
			// 事务管理员
			//根据参数创建不同的用户
			users = (Admin) userService.getTUser(user.getName());
			if (users != null) {
				if (((Admin) users).getPwd().equals(user.getPwd())) {
					result = "commAdmin";
					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute("userName",
									((Admin) users).getUsername());
				} else {
					ServletActionContext.getRequest().setAttribute("Erro",
							"密码或账号错误");
				}
			}

		} else if (user.getName().startsWith("S")) {
			// 超级管理员
			System.out.println("startWith S");
			users = (AdminSu) userService.getSUser(user.getName());
			if (users != null) {
				System.out.println("Not null");
				if (((AdminSu) users).getPwd().equals(user.getPwd())) {
					System.out.println("a user");
					result = "superAdmin";
					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute("userName",
									((AdminSu) users).getUsername());
					System.out.println("superAdmin send completeed");
				} else {
					ServletActionContext.getRequest().setAttribute("Erro",
							"密码或账号错误");
				}
			}
		} else {
			// 学生
			users = (StuBase) userService.getUser(user.getName());
			if (users != null) {
				if (((StuBase) users).getPwd().equals(user.getPwd())) {
					result = "stu";
					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute(
									"userName",
									((StuBase) users).getName() + "/"
											+ ((StuBase) users).getNumber());
				} else {
					ServletActionContext.getRequest().setAttribute("Erro",
							"密码或账号错误");
				}
			}

		}
		return result;
	}

	public String getCurrentAdmin() {
		String Name = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("userName");
		System.out.println("Name  " + Name);
		if (Name == null)
			// return "login";
			return LOGIN;
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
	public String getAdminByUserName()
	{
		if(AdminName == null || AdminName.equals(""))
			AdminName = (String) ServletActionContext.getRequest().getAttribute("AdminName");
		ServletActionContext.getRequest().setAttribute("currentAdmin",
				userService.getTUser(AdminName));
		return SUCCESS;
	}
	public boolean check(StuBase u) {
		boolean flag = true;
		System.out.println("进来了");
		// 验证密码
		if (u.getPwd() == null || u.getPwd().trim().equals("")) {
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"密码不准为空");
			flag = false;
		} else if (u.getPwd().length() < 6) {
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"你的密码长度太小");
			flag = false;
		}

		System.out.println("flag  " + flag);
		return flag;
	}

	public String modify() {
		System.out.println("prepairToChangeUser.getPwd()  "
				+ prepairToChangeUser.getPwd());
		try {
			userService.saveStuBaseOrUpdate(prepairToChangeUser);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return INPUT;
		}
	}

	public String logout() {
		ServletActionContext.getRequest().getSession()
				.removeAttribute("userId");
		return SUCCESS;
	}

	// 查询出所有学生信息
	public String getAllStudentBaseInfo() {

		try {
			String hql = "from StuBase";
			if (keyword != null) {
				System.out.println("keyword  " + keyword);
				hql += " where number =" + keyword;
				System.out.println("after add number  " + hql);
				keyword = null;
			}
			System.out.println("page   " + page);
			System.out.println("rows   " + rows);
			dataFromDB=new DataFromDB(userService.getStuBaseList(hql, page, rows)
					,userService.getUserTotal());
			toDataGrid(dataFromDB.setAdapter());
			System.out.println("查询完毕");
			System.out.println(userService.getUserTotal());
			System.out.println(userService.getStuBaseList(hql, page, rows)
					.get(0).getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAllStudentBaseInfoNoTotal() throws Exception {
		String hql = "from StuBase";
		
		 List<StuBase> list = null;
	     List _list = new ArrayList();
	        try {
	            list = (ArrayList<StuBase>)userService.getStuBaseList(hql);  //调用查询方法         
	             if(list.size()>0){
	               for(StuBase stu: list){           //遍历后台传值
	                   Map<String,Object> map = new HashMap<String,Object>();
	                    map.put("name",stu.getName() );
	                    map.put("credit", stu.getCredit());
	                    _list.add(map);   
	            }
	             }
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        JsonConfig jconfig = new JsonConfig();
			jconfig.setIgnoreDefaultExcludes(false);
			jconfig.registerJsonValueProcessor(java.util.Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));

	        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
	        jsonMap.put("rows", _list);//rows键 存放每页记录 list 
	        String result =   JSONObject.fromObject(jsonMap,jconfig).toString();
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        out.print(result);
	        out.flush();
	        out.close();
		
		
		return null;
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
			// return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			// return "input";
			return INPUT;
		}
	}

	public void deleteAct(int number) {
		try {
			userService.deleteStu(number);
			// return "true";
		} catch (Exception e) {
			System.out.print(e.getMessage());
			// return INPUT;
		}
	}

	public void deleteStuByIds() {

		System.out.println("stuIds   " + stuIds);
		if (stuIds.contains(",")) {
			String[] strings = stuIds.split(",");
			for (int i = 0; i < strings.length; i++) {
				deleteAct(Integer.parseInt(strings[i]));
			}
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"true");
		} else {
			deleteAct(Integer.parseInt(stuIds));
		}
	}

	public String getAdminSelfInfo() {

		try {
			String Name = (String) ServletActionContext.getRequest()
					.getSession().getAttribute("userName");
			dataFromDB=new DataFromDB(userService.getAdminSelfBaseList(Name)
					,1);
			toDataGrid(dataFromDB.setAdapter());
			//toBeJson(, 1);
			System.out.println("查询完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAdminById() {
		System.out.println("adminId");
		if (adminId == null || adminId.equals("")) {
			adminId = (Integer) ServletActionContext.getRequest().getAttribute(
					"adminId");
		}
		ServletActionContext.getRequest().setAttribute("currentAdmin",
				userService.getUserById(adminId));
		return SUCCESS;
	}

	public String modifyAdminInfo() {

		try {
			userService.saveAdminOrUpdate(prepairToChangeAdmin);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return INPUT;
		}
	}
<<<<<<< HEAD

=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
	/*public void addStuFromExcel(String fileName) {
		try {
			isWriteSuccess=false;
			File file=new File(ServletActionContext.getServletContext().getRealPath("/")
					+fileName);
			Workbook wb = Workbook.getWorkbook(file);
			//System.out.println("wb.getSheet(0).getRows()  "+wb.getSheet(0).getRows());
			for (int i = 1; i < wb.getSheet(0).getRows()-1; i++) {
				Cell[] cell = wb.getSheet(0).getRow(i);
				userService.saveStuBaseOrUpdate(new StuBase(Integer
						.parseInt(cell[0].getContents()),
						cell[1].getContents(), cell[2].getContents(), cell[3]
								.getContents(), cell[4].getContents(), Integer
								.parseInt(cell[5].getContents())));
				System.out.println(cell[1].getContents());
			}
			isWriteSuccess=true;
			wb.close();
			// 在这里应该还有一个删除的操作
			file.delete();
			//return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			//return INPUT;
		}

	}
*/
	/*public String upload() throws IOException {
		if (source != null && source.isFile()) {
			String uploadPath = ServletActionContext.getServletContext()
					.getRealPath("/") ;
			File dir = new File(uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File destFile = new File(uploadPath, "templeate.xls");
			FileUtils.copyFile(source, destFile);
			System.out.println("upload ok");
			addStuFromExcel("templeate.xls");
			if(isWriteSuccess){
				return SUCCESS;
			}else {
				return INPUT;
			}
		}
		return null;

	}*/
	
	
	//外观模式
	public String batchIncrease() throws Exception{
		boolean isOperateSuccess=false;
		FileUtils fileUtils=new FileUtils(source, userService);
		isOperateSuccess=fileUtils.operateOfFileUtils();
		
		if(isOperateSuccess){
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
}
