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
    
    <title>登陆界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath %>/bilibili/nav.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/bilibili/loc" charset="utf-8"></script>
	
<link charset="utf-8" rel="stylesheet" href="<%=basePath %>/bilibili/jquery-ui.css">
<link charset="utf-8" rel="stylesheet" href="<%=basePath %>/bilibili/white.css">
<link id="css" rel="stylesheet" type="text/css" href="<%=basePath %>/bilibili/zclc2.1460959081.css">
<link rel="stylesheet" href="<%=basePath %>/bilibili/base.css">
<link rel="stylesheet" href="<%=basePath %>/css/login.css">


  </head>
  
  <body>
    <div class="top_header">
    <img src="./img/login_header_bg.jpg" style="height:100%; width:100%"/>
    <div class="header_login">登录</div>
	
	</div>
	
<!-- "head_foot_content" -->
<div class="center_content" style="background-image:url(./img/content_bg.JPG)">
            
            <div class="content-r">
                <s:form action="login.action" theme="simple" >
                    
                    <div class="box">
                        <span id="userIdSpt">&nbsp;</span>
						<s:textfield id="uEmail" name="user.name" placeholder="用户名" cssStyle="margin-bottom: 0;height: 40px;width: 400px;" cssClass="email ui-autocomplete-input jv-box-default"/>    	
                    </div>
                    <div class="box">
                        <span id="userPwdTip">&nbsp;</span>
						<s:password id="uPass" name="user.pwd" placeholder="密码" cssClass="password" cssStyle="margin-bottom: 0;height: 40px;width: 400px;"/>
                    </div>
                    <font color="#FF0000" size="3">
        				<s:property value="#request.Erro"/><br/>
        			</font>
                    <s:submit value="登录" cssClass="login"/>
                    <a class="zhuce" href="./regist.jsp">注册</a>
                </s:form>
                
                    <ul class="way"></ul>
            </div>
            </div>
<div class="bottom_footer"></div>
</body>
</html>

