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
import com.sonic.pojo.Creditcategory;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;
import com.sonic.service.InfoService;
import com.sonic.utills.DataFromDB;
import com.sonic.utills.DateJsonValueProcessor;

public class InfoAction extends ActionSupport {
	private JSONObject jsonObj; 
	private InfoService infoService;
	private String rows;// 每页显示的记录数  
    private String page;// 当前第几页 
    private StuBase user;
    private String userId;
    
    private String infoTittle;
	private String infoContent;
	private List<Info> list;
	private String keyword;
	private Integer infoSelectedId;
	private Info prepairToInfo;
	private DataFromDB dataFromDB;
	private String infoIds;
	
    public String getInfoIds() {
		return infoIds;
	}
	public void setInfoIds(String infoIds) {
		this.infoIds = infoIds;
	}
	public Info getPrepairToInfo() {
		return prepairToInfo;
	}
	public void setPrepairToInfo(Info prepairToInfo) {
		this.prepairToInfo = prepairToInfo;
	}
	public Integer getInfoSelectedId() {
		return infoSelectedId;
	}
	public void setInfoSelectedId(Integer infoSelectedId) {
		this.infoSelectedId = infoSelectedId;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Info> getList() {
		return list;
	}
	public void setList(List<Info> list) {
		this.list = list;
	}
	
	public String getInfoTittle() {
		return infoTittle;
	}
	public void setInfoTittle(String infoTittle) {
		this.infoTittle = infoTittle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public InfoService getInfoService() {
		return infoService;
	}
	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
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
	//获取所有通知
    public String getAllInfo() { 
        try {
        	String hql="from Info";
        	System.out.println("number all  "+keyword);
        	if(keyword != null){
        		hql+=" where infoTittle like '%" + keyword
    					+ "%'or infoContent like '%" + keyword + "%'";
        		System.out.println("after add number  "+hql);
        		keyword=null;
        	}
        	dataFromDB=new DataFromDB(infoService.getAllInfoList(hql,page, rows)
					,infoService.getInfoTotal());
			dataFromDB.setJsonAdapter();
			dataFromDB.toJsp();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;  
    }  
    
    public String addInfo() {
		Info info = new Info();
		info.setInfoTittle(infoTittle);
		info.setInfoContent(infoContent);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		info.setInfoTime(df.format(new Date()));
		System.out.println("addinfo access");
		try {
			infoService.saveInfoOrUpdate(info);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return INPUT;
		}
	}
    
    public void deleteAct(int number){
    	try {
			infoService.deleteInfoById(number);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	public void deleteInfoByIds() {
		
		System.out.println("infoIds   "+infoIds);
		if(infoIds.contains(",")){
			String[] strings = infoIds.split(",");
			for(int i=0;i<strings.length;i++){
				deleteAct(Integer.parseInt(strings[i]));
			}
			ServletActionContext.getRequest().setAttribute("passwordErro",
					"true");
		}else {
			deleteAct(Integer.parseInt(infoIds));
		}
	}
    public String getInfoById() {
		
		if (infoSelectedId == null || infoSelectedId.equals("")) {
			infoSelectedId = (Integer) ServletActionContext.getRequest().getAttribute(
					"infoSelectedId");
		}
		ServletActionContext.getRequest().setAttribute("currentInfoSelectedId",
				infoService.getInfo(infoSelectedId));
		return SUCCESS;
	}
    
    public String modifyInfo(){
		try{
			infoService.saveInfoOrUpdate(prepairToInfo);
			return SUCCESS;
		}catch(Exception e){
			System.out.print(e.getMessage());
			return INPUT;
		}
	}
}
