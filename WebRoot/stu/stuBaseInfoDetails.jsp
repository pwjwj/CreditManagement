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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.easyui.min.js" charset="utf-8"></script>
	<script type="text/javascript">
		var msg="${requestScope.tipMessage}";
		if(msg!=""){
			alert(msg);
		}
	</script>
	<script type="text/javascript" src="<%=basePath %>/bilibili/nav.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/bilibili/loc" charset="utf-8"></script>
	
	<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
  </head>
  
  <body>
      <!-- 班级显示的有问题 -->
      <!-- 班级显示的有问题 -->
  <div class="header">
  <div class="center_title">信息修改</div>
  </div>
  <div class="center_body">
    <s:form action="modifyLoginedStuInfo.action" theme="simple">
    <div class="info_center"><div class="title-left">学号：</div><span  style="color:gray;font-size:1.2em;"><s:text name="%{#request.currentLoginStu.number}" /></span></div>
    <div class="info_center"><div class="title-left">姓名：</div><span  style="color:gray;font-size:1.2em;"><s:text name="%{#request.currentLoginStu.name}" /></span></div>
    <div class="info_center"><div class="title-left">院系：</div><span  style="color:gray;font-size:1.2em;"><s:text name="%{#request.currentLoginStu.college}" /></span></div>
    <div class="info_center"><div class="title-left">班级：<span  style="color:gray;font-size:1.2em;"><s:text name="%{#request.currentLoginStu.class_}" /></span></div>
    		<s:hidden name="prepairToChangeStuBase.credit" value="%{#request.currentLoginStu.credit}"/>
    		<s:hidden name="prepairToChangeStuBase.number" value="%{#request.currentLoginStu.number}"/>
    		<s:hidden name="prepairToChangeStuBase.name" value="%{#request.currentLoginStu.name}"/>
    		<s:hidden name="prepairToChangeStuBase.college" value="%{#request.currentLoginStu.college}"/>
    		<s:hidden name="prepairToChangeStuBase.class_" value="%{#request.currentLoginStu.class_}"/>
    </div>
    <div class="info_center"><div class="title-left">密码：</div><s:password name="prepairToChangeStuBase.pwd" placeholder="密码" value="%{#request.currentLoginStu.pwd}" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
     <font color="#FF0000" size="3">
        	<s:property value="#request.passwordErro"/>
     </font>
    <div class="info_center"></div>
    <div class="info_center"></div>    
     <div class="info_center">
     <s:submit value="修改" cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;"/>
        <s:if test="#request.currentUser.name == #session.stuName ">
        	 <a class="center_div" href="/admin/BaseInfo.jsp">返回主页</a>
        </s:if>
     </div>
	</s:form>
    </div>
  </body>
</html>
