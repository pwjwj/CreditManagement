package com.sonic.utills;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

public class JsonAdapter extends Adapter{

	@Override
	public String doAdapt(List list, int total) {
		// TODO Auto-generated method stub
		JsonConfig jconfig = new JsonConfig();
		JSONArray ja = new JSONArray();
		jconfig.setIgnoreDefaultExcludes(false);
		jconfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		

		JSONObject jobj = new JSONObject();// new一个JSON
<<<<<<< HEAD
		if(total!=-1){
			jobj.accumulate("total", total);// total代表一共有多少数据
		}
=======
<<<<<<< HEAD
		if(total!=-1){
			jobj.accumulate("total", total);// total代表一共有多少数据
		}
=======
		jobj.accumulate("total", total);// total代表一共有多少数据
>>>>>>> 9b9aee380b03c152f24fb429f1d11f8db1905faa
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
		jobj.accumulate("rows", ja.fromObject(list, jconfig));// row是代表显示的页的数据
		
		return jobj.toString();
	}

}
