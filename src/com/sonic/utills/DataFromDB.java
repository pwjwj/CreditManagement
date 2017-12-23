package com.sonic.utills;

import com.sonic.service.BaseInfoService;
import java.util.List;

public class DataFromDB {
	//先从baseInfo里面抽 看能不能成功
	//成功的话在抽出来一个大的
	List list;
	int total;
	Adapter adapter;
	public String result;
	public DataFromDB(List list, int total) {
		super();
		this.list = list;
		this.total = total;
		result="";
	}



	public String setAdapter(){
		adapter=new JsonAdapter();
		result=adapter.doAdapt(list, total);
		return result;
	}
	
}
