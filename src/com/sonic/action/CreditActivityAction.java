package com.sonic.action;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;
import com.sonic.service.CreditActivityService;
import com.sonic.utills.DateJsonValueProcessor;

public class CreditActivityAction extends ActionSupport {
	private JSONObject jsonObj;
	private CreditActivityService creditactivityService;
	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private StuBase user;
	private String userId;

	private Integer id;
	private Integer number;
	private String categoryId;
	private String detail;
	private String dates;
	private String name;
	private Integer credit;

	private Integer activityId;
	private Creditactivity prepairToChangeActivity;
	private String creditActivityIds;
	
	public String getCreditActivityIds() {
		return creditActivityIds;
	}

	public void setCreditActivityIds(String creditActivityIds) {
		this.creditActivityIds = creditActivityIds;
	}

	public Creditactivity getPrepairToChangeActivity() {
		return prepairToChangeActivity;
	}

	public void setPrepairToChangeActivity(
			Creditactivity prepairToChangeActivity) {
		this.prepairToChangeActivity = prepairToChangeActivity;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Integer creditActivityId;

	private List<Creditactivity> list;

	private Integer keyword;

	public Integer getKeyword() {
		return keyword;
	}

	public void setKeyword(Integer keyword) {
		this.keyword = keyword;
	}

	public List<Creditactivity> getList() {
		return list;
	}

	public void setList(List<Creditactivity> list) {
		this.list = list;
	}

	public Integer getCreditActivityId() {
		return creditActivityId;
	}

	public void setCreditActivityId(Integer creditActivityId) {
		this.creditActivityId = creditActivityId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public CreditActivityService getCreditactivityService() {
		return creditactivityService;
	}

	public void setCreditactivityService(
			CreditActivityService creditactivityService) {
		this.creditactivityService = creditactivityService;
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
		System.out.println(jobj.toString());
		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.getWriter().write(jobj.toString());
	}

	// 信用信息查看
	public String getAllStudentCreditActivity() {

		try {
			String hql = "SELECT C,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number";
			System.out.println("number all  " + keyword);
			if (keyword != null) {
				hql += " where number =" + keyword;
				System.out.println("after add number  " + hql);
				keyword = null;
			}
			
			toBeJson(creditactivityService.getStuCreditActivityList(hql, page,
					rows), creditactivityService.getCreditActivityTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String addCreditActivity() throws ParseException {
		Creditactivity ca = new Creditactivity();
		System.out.println("number  " + number);
		ca.setNumber(number);
		ca.setName(name);
		ca.setDates(dates);
		ca.setDetail(detail);
		ca.setCategoryId(categoryId);
		System.out.println("ca.number   " + ca.getNumber());
		System.out.println("number   " + getNumber());
		System.out.println("addCreditActivity access");
		try {
			creditactivityService.saveCreditActivityOrUpdate(ca);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return INPUT;
		}
	}

	public void deleteAct(int number){
		try {
			creditactivityService.deleteCreditActivity(number);
			System.out.println("inin");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	public void deleteCreditActivityByIds() {
		System.out.println("stuIds   "+creditActivityIds);
		if(creditActivityIds.contains(",")){
			String[] strings = creditActivityIds.split(",");
			for(int i=0;i<strings.length;i++){
				System.out.println(Integer.parseInt(strings[i]));
				deleteAct(Integer.parseInt(strings[i]));
			}
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"true");
		}else {
			deleteAct(Integer.parseInt(creditActivityIds));
		}
	}
	public String creditActivitySearchTest() {
		List<Creditactivity> list1 = list;
		try {
			System.out.println("number  " + number);
			String hql = "from Creditactivity where number = " + number;
			list = creditactivityService.getCreditActivitySearchList(hql, page,
					rows);
			System.out.println("result list size  " + list.size());
			toBeJson(list,
					creditactivityService.getCreditActivitySearchedTotal(hql));
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			list = list1;
			return SUCCESS;
		}
	}

	public String getCreditActivityById() {

		if (activityId == null || activityId.equals("")) {
			activityId = (Integer) ServletActionContext.getRequest()
					.getAttribute("activityId");
		}
		ServletActionContext.getRequest().setAttribute("currentCreditActivity",
				creditactivityService.getCreditActivity(activityId));
		return SUCCESS;
	}

	public String modifyCreditActivity() {
		try {
			System.out.println("prepairToChangeActivity.getDetail()   "
					+ prepairToChangeActivity.getDetail());
			creditactivityService
					.saveCreditactivityBaseOrUpdate(prepairToChangeActivity);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return INPUT;
		}
	}

}
