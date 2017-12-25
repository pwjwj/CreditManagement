package com.sonic.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.dto.CreditActivityBean;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;
import com.sonic.service.CreditActivityService;
import com.sonic.utills.DataFromDB;
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
	private DataFromDB dataFromDB;
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

	/*private void toBeJson(List list, int total) throws Exception {
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
	}*/

	// 信用信息查看
	public String getAllStudentCreditActivity() {

		try {
<<<<<<< HEAD
			String hql = "SELECT C.id,C.number,C.name,C.categoryId,C.detail,C.dates,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number";
=======
<<<<<<< HEAD
			String hql = "SELECT C.id,C.number,C.name,C.categoryId,C.detail,C.dates,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number";
=======
			String hql = "SELECT C,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number";
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
			System.out.println("number all  " + keyword);
			if (keyword != null) {
				hql += " and S.number =" + keyword;
				System.out.println("after add number  " + hql);
				keyword = null;
			}
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
			List<Object> dataList = creditactivityService.getStuCreditActivityList(hql, page,rows);
			ArrayList<CreditActivityBean> arrayList = new ArrayList<CreditActivityBean>();
			Iterator its=dataList.iterator();    
	        //iterator遍历  最后一条数据没有
	        while(its.hasNext()){    
	            Object[] a=(Object[])its.next();    
	            CreditActivityBean activityBean = new CreditActivityBean();
	            activityBean.setId(Integer.valueOf(a[0].toString()));
	            activityBean.setNumber(Integer.valueOf(a[1].toString()));
	            activityBean.setName(a[2].toString());
	            activityBean.setCategoryId(a[3].toString());
	            activityBean.setDetail(a[4].toString());
	            activityBean.setDates(a[5].toString());
	            activityBean.setScore(Integer.valueOf(a[6].toString()));
	            arrayList.add(activityBean);
<<<<<<< HEAD
	        } 
	        dataFromDB=new DataFromDB(arrayList
					,creditactivityService.getCreditActivityTotal("SELECT C.id,C.number,C.name,C.categoryId,C.detail,C.dates,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number"));
			dataFromDB.setJsonAdapter();
			System.out.println("dataFromDB.result  "+dataFromDB.result);
			dataFromDB.toJsp();
			//toBeJson(arrayList, creditactivityService.getCreditActivityTotal("SELECT C.id,C.number,C.name,C.categoryId,C.detail,C.dates,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number"));
=======
	        }  
			toBeJson(arrayList, creditactivityService.getCreditActivityTotal("SELECT C.id,C.number,C.name,C.categoryId,C.detail,C.dates,S.credit from Creditactivity C,StuBase S WHERE C.number = S.number"));
=======
			
			toBeJson(creditactivityService.getStuCreditActivityList(hql, page,
					rows), creditactivityService.getCreditActivityTotal());
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
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
		
		
		//List data = creditactivityService.getData("select cc.score from Creditcategory cc where cc.detail="+detail);
		
		//现在还需要在添加的时候  先拿到这个学号对应的基础的信用分
		Object creditObject=creditactivityService.getData("select stu.credit from StuBase stu where stu.number="+number).get(0);
		int creditStuBase = Integer.valueOf(creditObject.toString());
		System.out.println("creditStuBase   "+creditStuBase);
		//再拿到这个活动对应的信用分
		Object activityScoreobject = creditactivityService.getData("select cc.score from Creditcategory cc where cc.detail='"+detail+"'").get(0);
		int creditActivityScore=Integer.valueOf(activityScoreobject.toString());
		System.out.println("creditActivityScore  "+creditActivityScore);
		//再最后再数据库完成更新
		try {
			creditactivityService.saveCreditActivityOrUpdate(ca);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
			System.out.println("save  success");
			int scoreFinal=creditStuBase+creditActivityScore;
			String hql="update StuBase stu set stu.credit="+scoreFinal+" where stu.number="+number;
			System.out.println("hql   "+hql);
			creditactivityService.updateStuBase(hql );
			System.out.println("update success");
<<<<<<< HEAD
=======
=======
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
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
<<<<<<< HEAD
		System.out.println("creditActivityIds   "+creditActivityIds);
=======
<<<<<<< HEAD
		System.out.println("creditActivityIds   "+creditActivityIds);
=======
		System.out.println("stuIds   "+creditActivityIds);
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
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
			dataFromDB=new DataFromDB(list
					,creditactivityService.getCreditActivitySearchedTotal(hql));
			dataFromDB.setJsonAdapter();
			dataFromDB.toJsp();
			/*toBeJson(list,
					creditactivityService.getCreditActivitySearchedTotal(hql));*/
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
