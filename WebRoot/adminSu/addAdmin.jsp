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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<div style="margin: e10px 0px 0px 15px">
  	这里还有字符串格式的问题
    <s:form action = "addAdminBase.action" theme="simple">
    	<s:textarea name = "username" placeholder="用户名 请以T开头"  cssStyle="height:28px;width:500px"/><br/>
    	<s:textarea name = "pwd" placeholder="密码"  cssStyle="height:28px;width:500px"/><br/>
    	<s:textarea name = "tel" placeholder="联系方式"  cssStyle="height:28px;width:500px"/><br/>
    	<s:textarea name = "other"  placeholder="备注信息"  cssStyle="height:28px;width:500px"/><br/>
    	
    	<s:submit value = "新增" cssStyle="height:28px;width:60px"/>
    </s:form>
    
    </div>

  </body>
</html>
