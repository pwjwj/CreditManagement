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
    <s:form action = "addInfo.action" theme="simple">
    	<s:textarea name = "infoTittle" placeholder="通知标题"  cssStyle="height:28px;width:500px"/><br/>
    	<s:textarea name = "infoContent" placeholder="通知内容"  cssStyle="height:28px;width:500px"/><br/>
    	<%-- <s:textarea name = "infoTime" placeholder="日期 yyyy-MM-dd HH:mm"  cssStyle="height:28px;width:500px"/><br/>
    	<s:textarea name = "dates"  placeholder="日期 YYYY-MM-DD"  cssStyle="height:28px;width:500px"/><br/> --%>
    	
    	<s:submit value = "新增" cssStyle="height:28px;width:60px"/>
    </s:form>
    
    </div>

  </body>
</html>
