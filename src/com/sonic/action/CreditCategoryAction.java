package com.sonic.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Creditcategory;
import com.sonic.pojo.StuBase;
import com.sonic.service.CreditCategoryService;
import com.sonic.utills.DateJsonValueProcessor;

public class CreditCategoryAction extends ActionSupport {
	private JSONObject jsonObj;
	private CreditCategoryService creditcategoryService;
	private String rows;// ÿҳ��ʾ�ļ�¼��
	private String page;// ��ǰ�ڼ�ҳ
	private StuBase user;
	private String userId;

	private Integer categoryId;
	private String categoryName;
	private String detail;
	private Integer score;

	private List<Creditcategory> list;

	private String keyword;

	private Integer creditCategoryId;
	private Integer idss;
	private Creditcategory prepairToChangeCategory;

	private String creditCategoryIds;
	
	public String getCreditCategoryIds() {
		return creditCategoryIds;
	}

	public void setCreditCategoryIds(String creditCategoryIds) {
		this.creditCategoryIds = creditCategoryIds;
	}

	public Creditcategory getPrepairToChangeCategory() {
		return prepairToChangeCategory;
	}

	public void setPrepairToChangeCategory(
			Creditcategory prepairToChangeCategory) {
		this.prepairToChangeCategory = prepairToChangeCategory;
	}

	public Integer getIdss() {
		return idss;
	}

	public void setIdss(Integer idss) {
		this.idss = idss;
	}

	public Integer getCreditCategoryId() {
		return creditCategoryId;
	}

	public void setCreditCategoryId(Integer creditCategoryId) {
		this.creditCategoryId = creditCategoryId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Creditcategory> getList() {
		return list;
	}

	public void setList(List<Creditcategory> list) {
		this.list = list;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public CreditCategoryService getCreditcategoryService() {
		return creditcategoryService;
	}

	public void setCreditcategoryService(
			CreditCategoryService creditcategoryService) {
		this.creditcategoryService = creditcategoryService;
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

		JSONObject jobj = new JSONObject();// newһ��JSON
		jobj.accumulate("total", total);// total����һ���ж�������
		jobj.accumulate("rows", ja.fromObject(list, jconfig));// row�Ǵ�����ʾ��ҳ������

		response.setCharacterEncoding("utf-8");// ָ��Ϊutf-8
		response.getWriter().write(jobj.toString());
	}

	//����������Ŀ�鿴
	public String getAllCreditCategory() {

		try {
			String hql = "from Creditcategory";
			if (keyword != null) {
				hql += " where detail like '%" + keyword + "%'";
				System.out.println("after add number  " + hql);
				keyword = null;
			}
			toBeJson(creditcategoryService.getCreditCategoryList(hql, page,
					rows), creditcategoryService.getCreditCategoryTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String addCrditCategory() {
		Creditcategory cc = new Creditcategory();
		cc.setCategoryId(categoryId);
		cc.setCategoryName(categoryName);
		cc.setDetail(detail);
		cc.setScore(score);
		System.out.println("addcc access");
		try {
			creditcategoryService.saveCreditCategoryOrUpdate(cc);
			//return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return "input";
			return INPUT;
		}
	}

	
	
	public void deleteAct(int number){
		try {

			creditcategoryService.deleteCreditCategoryById(number);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
	}
	public void deleteCategoryByIds() {
		
		System.out.println("creditCategoryIds   "+creditCategoryIds);
		if(creditCategoryIds.contains(",")){
			String[] strings = creditCategoryIds.split(",");
			for(int i=0;i<strings.length;i++){
				deleteAct(Integer.parseInt(strings[i]));
			}
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"true");
		}else {
			deleteAct(Integer.parseInt(creditCategoryIds));
		}
	}
	public String getCreditCategoryById() {
		if (idss == null || idss.equals("")) {
			idss = (Integer) ServletActionContext.getRequest().getAttribute(
					"idss");
			System.out.println("idss   " + idss);
		}
		System.out.println("idss  " + idss);
		ServletActionContext.getRequest().setAttribute("currentCreditCategory",
				creditcategoryService.getCreditCategory(idss));
		return SUCCESS;
	}

	public String modifyCreditCategory() {
		try {
			creditcategoryService
					.saveCreditCategoryOrUpdate(prepairToChangeCategory);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return INPUT;
		}
	}
}
