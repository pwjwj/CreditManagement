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
    <s:form action = "addStuApplication.action" theme="simple">
    	<s:textarea name = "applicationCategory" placeholder="申请类比"  cssStyle="height:28px;width:500px"/><br/>
    	<s:textarea name = "applicationWhat" placeholder="申请详情"  cssStyle="height:28px;width:500px"/><br/>
    	<s:submit value = "新增" cssStyle="height:28px;width:60px"/>
    </s:form>
    
    </div>

  </body>
</html>
