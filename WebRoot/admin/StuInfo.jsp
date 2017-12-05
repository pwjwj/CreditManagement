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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery-1.8.0.min.js" charset="utf-8"></script>
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
  <div class="center_title">学生信息</div>
  </div>
  <div class="center_body">
    <s:form action="modify.action" theme="simple">
    <div class="info_center"><div class="title-left">账号：</div><span id="userPwdTip" style="color:gray;font-size:24px;"><s:text name="%{#request.currentUser.name}"/></span>
    	<s:hidden name="prepairToChangeUser.name" value="%{#request.currentUser.name}"/>
    		<s:hidden name="prepairToChangeUser.number" value="%{#request.currentUser.number}"/>
    		<s:hidden name="prepairToChangeUser.college" value="%{#request.currentUser.college}"/>
    		<s:hidden name="prepairToChangeUser.class_" value="%{#request.currentUser.class_}"/>
    		<s:hidden name="prepairToChangeUser.credit" value="%{#request.currentUser.credit}"/></div>
    	<div class="info_center"><div class="title-left">学号：</div><span  style="color:gray;font-size:24px;"><s:text name="%{#request.currentUser.number}"/></span></div>
    	
    		<div class="info_center"><div class="title-left">院系：</div><span  style="color:gray;font-size:24px;"><s:text name="%{#request.currentUser.college}"/></span></div>
    		<div class="info_center"><div class="title-left">班级：</div><span  style="color:gray;font-size:24px;"><s:text name="%{#request.currentUser.class_}"/></span></div>
    		<div class="info_center"><div class="title-left">信用：</div><span  style="color:gray;font-size:24px;"><s:text name="%{#request.currentUser.credit}"/></span></div>
        <div class="info_center"><div class="title-left">密码:</div>
			<s:password name="prepairToChangeUser.pwd" placeholder="密码" value="%{#request.currentUser.pwd}" cssClass="password user_id_password" cssStyle="margin-bottom: 0;height: 40px;width: 300px;"/>
        </div>
        <font color="#FF0000" size="3">
        	<s:property value="#request.passwordErro"/>
        </font>
        <div class="info_center"></div>
        <div class="info_center" >
        <s:submit value="修改" cssClass="center_div " cssStyle="cursor: pointer;font-size: 20px;color: white;height: 40px;width: 400px; margin:0 0 0 4%;background-color:#00a1d6;"/>
        <s:if test="#request.currentUser.name == #session.stuName ">
        	 <a class="center_div" href="/admin/BaseInfo.jsp">返回主页</a>
        </s:if>
        </div>
	</s:form>
 </div>
  </body>
</html>
