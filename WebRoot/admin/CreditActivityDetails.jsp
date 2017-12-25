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
    
    <title></title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.easyui.min.js" charset="utf-8"></script>
	<script type="text/javascript">
		var msg="${requestScope.tipMessage}";
		if(msg!=""){
			alert(msg);
		}
	</script>
	<script type="text/javascript" src="<%=basePath %>/bilibili/nav.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/bilibili/loc" charset="utf-8"></script>

<link charset="utf-8" rel="stylesheet" href="<%=basePath %>/bilibili/jquery-ui.css">
<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
  </head>
  <body>
   <div class="header">
  <div class="center_title">信用活动修改</div>
  </div>
   <div class="center_body">
    <s:form action="modifyCreditActivity.action" theme="simple">
    <div class="info_center"> 
    <div class="title-left">学号：</div>
    <s:textarea name="prepairToChangeActivity.number" placeholder="学号" value="%{#request.currentCreditActivity.number}"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
	<s:hidden name="prepairToChangeUser.id" value="%{#request.currentCreditActivity.id}"/>
	</div>
        <font color="#FF0000" size="3">
        	<s:property value="#request.passwordErro"/>
        </font>
        <div class="info_center">
			<div class="title-left">姓名：</div><s:textarea name="prepairToChangeActivity.name" placeholder="姓名" value="%{#request.currentCreditActivity.name}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
        <div class="info_center">
			<div class="title-left">分类号：</div><s:textarea name="prepairToChangeActivity.categoryId" placeholder="分类号" value="%{#request.currentCreditActivity.categoryId}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
        <div class="info_center">
			<div class="title-left">事项详情：</div><s:textarea name="prepairToChangeActivity.detail" placeholder="事项详情" value="%{#request.currentCreditActivity.detail}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
        <div class="info_center">
			<div class="title-left">日期：</div><s:textarea name="prepairToChangeActivity.dates" placeholder="日期" value="%{#request.currentCreditActivity.dates}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
        <div class="info_center"></div>
    	<div class="info_center"></div>
    	<div class="info_center">
        <s:submit value="修改" cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;"/>
        <s:if test="#request.currentUser.activityId == #session.activityId ">
        	 <a class="center_div" href="/admin/BaseInfo.jsp">返回主页</a>
        </s:if>
        </div>
	</s:form>
  </div>
  </body>
</html>
