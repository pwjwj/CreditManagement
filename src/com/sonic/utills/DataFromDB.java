package com.sonic.utills;

import com.sonic.service.BaseInfoService;
import java.util.List;

<<<<<<< HEAD
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

=======
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
public class DataFromDB {
	//�ȴ�baseInfo����� ���ܲ��ܳɹ�
	//�ɹ��Ļ��ڳ����һ�����
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

<<<<<<< HEAD
	public void setJsonAdapter(){
		adapter=new JsonAdapter();
		result=adapter.doAdapt(list, total);
		
	}
	public void toJsp() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");// ָ��Ϊutf-8
		response.getWriter().write(result);
		System.out.println("gridData  "+result);
	}
=======


	public String setAdapter(){
		adapter=new JsonAdapter();
		result=adapter.doAdapt(list, total);
		return result;
	}
	
>>>>>>> c32516e224b90a80c1d2ab87727a4b0cb81eae8e
}
