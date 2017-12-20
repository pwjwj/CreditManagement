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
  	<!--这里还有字符串格式的问题-->
    <s:form action = "addAdminBase.action" theme="simple">
    	<div class="info_center"><div class="title-left">用户名：</div><s:textarea name = "username" placeholder="用户名 请以T开头"  cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">密码：</div><s:textarea name = "pwd" placeholder="密码"  cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">联系方式：</div><s:textarea name = "tel" placeholder="联系方式"  cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">备注信息：</div><s:textarea name = "other"  placeholder="备注信息" cssStyle="margin-bottom: 0;height: 40px;width: 300px; resize: none;"/></div>
    	<div class="info_center"></div>
    	<div class="info_center"></div>
    	<div class="info_center">
    	<s:submit value = "新增" cssStyle="cursor: pointer;font-size: 20px;color: white;height: 40px;width: 400px; margin:0 0 0 4%;background-color:#00a1d6;"/>
    	</div>
    </s:form>
    
    </div>

  </body>
</html>
