<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增学生信用活动</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
	
	<script type="text/javascript">
function beforemodify()
{
	var number = document.getElementById("uNumber").value;
	var name = document.getElementById("uName").value;
	var categoryId = document.getElementById("uCategoryId").value;
	var detail = document.getElementById("uDetail").value;
	var dates = document.getElementById("uDates").value;
	var datecheck = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
	if(number=="")
	{
		alert("学号不能为空!");
		return false;
	}
	else if(name=="")
	{
		alert("姓名不能为空!");
		return false;
	}
	else if(categoryId=="")
	{
		alert("分类号不能为空!");
		return false;
	}
	else if(dates=="")
	{
		alert("日期不能为空!");
		return false;
	}
	else if(detail=="")
	{
		alert("详情不能为空!");
		return false;
	}
	else
	{
		var flag=datecheck.test(dates);
		if(!flag)
		{
			alert("日期格式应为yyyy-mm-dd");
			return false;
		}
		else
			return true;
	}
}
</script>
  </head>
  
  <body>
   <div class="header">
    <div class="center_title">新增学生信用活动</div>
  </div>
  	<div class="center_body">
    <s:form action = "addCreditActivity.action" theme="simple">
    	<div class="info_center"><div class="title-left">学号：</div><s:textarea id="uNumber" name = "number" placeholder="学号"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" onkeyup="value=value.replace(/[^1234567890-]+/g,'')"/></div>
    	<div class="info_center"><div class="title-left">姓名：</div><s:textarea id="uName" name = "name" placeholder="姓名"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">分类号：</div><s:textarea id="uCategoryId" name = "categoryId" placeholder="分类号"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" onkeyup="value=value.replace(/[^1234567890-]+/g,'')"/></div>
    	<div class="info_center"><div class="title-left">事项详情：</div><s:textarea id="uDetail" name = "detail" placeholder="事项详情"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">日期：</div><s:textarea id="uDates" name = "dates"  placeholder="日期 YYYY-MM-DD"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
    	<div class="info_center"></div>
    	<div class="info_center"><s:submit value = "新增"  cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" onclick="return beforeadd();"/></div>
    </s:form>
    
    </div>

  </body>
</html>
