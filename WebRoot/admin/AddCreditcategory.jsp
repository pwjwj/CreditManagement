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
    
    <title>新增事项</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
	
	<script type="text/javascript">
	function beforeadd()
	{
		var categoryId = document.getElementById("categoryId").value;
		var categoryName = document.getElementById("categoryName").value;
		var detail = document.getElementById("detail").value;
		var score = document.getElementById("score").value;
	if(categoryId=="")
	{
		alert("分类号不能为空!");
		return false;
	}
	else if(categoryName=="")
	{
		alert("分类名不能为空!");
		return false;
	}
	else if(detail=="")
	{
		alert("详情不能为空!");
		return false;
	}
	else if(score=="")
	{
		alert("分数不能为空!");
		return false;
	}
	else
		return true;
	}
	</script>
  </head>
  
  <body>
   <div class="header">
  <div class="center_title">事项新增</div>
  </div>
  	<div class="center_body">
    <s:form action = "addCrditCategory.action" theme="simple">
    	<div class="info_center"><div class="title-left">分类号：</div><s:textarea id="categoryId" name = "categoryId" placeholder="分类号"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" onkeyup="value=value.replace(/[^1234567890-]+/g,'')"/></div>
    	<div class="info_center"><div class="title-left">分类名：</div><s:textarea id="categoryName" name = "categoryName" placeholder="分类名" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">事项详情：</div><s:textarea id="detail" name = "detail" placeholder="事项详情"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
    	<div class="info_center"><div class="title-left">分值：</div><s:textarea id="score" name = "score" placeholder="分值"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" onkeyup="value=value.replace(/[^1234567890-]+/g,'')"/></div>
    	<div class="info_center"></div>
    	<div class="info_center"></div>
    	<div class="info_center"><s:submit value = "新增" cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" onclick="return beforeadd();"/></div>
    	
    </s:form>
    
    </div>

  </body>
</html>
