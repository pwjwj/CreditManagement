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
import com.sonic.pojo.Goods;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;
import com.sonic.service.GoodsService;
import com.sonic.utills.DateJsonValueProcessor;

public class GoodsAction extends ActionSupport {
	private JSONObject jsonObj; 
	private GoodsService goodsService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
    
    private String goodsName;
	private Integer goodsNumberRemain;
	
	private List<Goods> list;
	private String keyword;
	
	private Integer GoodsId;
	
    public Integer getGoodsId() {
		return GoodsId;
	}

	public void setGoodsId(Integer goodsId) {
		GoodsId = goodsId;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNumberRemain() {
		return goodsNumberRemain;
	}

	public void setGoodsNumberRemain(Integer goodsNumberRemain) {
		this.goodsNumberRemain = goodsNumberRemain;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
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
	//获取所有物资
    public String getAllGoods() { 
        try {
        	String hql="from Goods";
        	System.out.println("number all  "+keyword);
        	if(keyword != null){
        		hql+=" where goodsName like '%" + keyword
    					+ "%'or goodsBorrower like '%" + keyword + "%'";
        		System.out.println("after add number  "+hql);
        		keyword=null;
        	}
			toBeJson(goodsService.getAllGoodsList(hql,page, rows),goodsService.getGoodsTotal());
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  
    
    public String addGoods() {
		Goods goods = new Goods();
		goods.setGoodsBorrower("");
		goods.setGoodsName(goodsName);
		goods.setGoodsNumberBorrowed(0);
		goods.setGoodsNumberRemain(goodsNumberRemain);
		System.out.println("addGoods access");
		try {
			goodsService.saveGoodsOrUpdate(goods);
			//return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return "input";
			return INPUT;
		}
	}
   
    public String deleteGoodsById() {
		try {
			
			goodsService.deleteGoodsById(GoodsId);
			//return "success";
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return "input";
			return INPUT;
		}
	}
}
