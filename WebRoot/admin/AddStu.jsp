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
    
    <title>My JSP 'newsManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
  </head>
  
  <body>
   <div class="header">
  <div class="center_title">增加学生信息</div>
  </div>
  <div class="center_body">
   <s:form action = "addStuBase.action" theme="simple" >
    	<div class="info_center"><div class="title-left">姓名：</div><s:textarea name = "name" placeholder="姓名" cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">学号：</div><s:textarea name = "number" placeholder="学号" cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">院系：</div><s:textarea name = "college" placeholder="院系" cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">班级：</div><s:textarea name = "class_" placeholder="班级" cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"></div>
    	<div class="info_center"></div>
    	<div class="info_center"><s:submit value = "新增" cssStyle="cursor: pointer;font-size: 20px;color: white;height: 40px;width: 400px; margin:0 0 0 4%;background-color:#00a1d6;"/></div>

    </s:form>
  </div>

  </body>
</html>
