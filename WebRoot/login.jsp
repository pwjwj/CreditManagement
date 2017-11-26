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









  </head>
  
  <body>
    <div class="" style="left: 0px; top: 0px; position: fixed; visibility: hidden;">
	<div class="d-outer"><table class="d-border"><tbody><tr><td class="d-nw"></td><td class="d-n"></td><td class="d-ne"></td></tr><tr><td class="d-w"></td><td class="d-c"><div class="d-inner"><table class="d-dialog"><tbody><tr><td class="d-header"><div class="d-titleBar"><div class="d-title" style="display: block;"></div><a class="d-close" href="javascript:/*artDialog*/;" style="display: none;">×</a></div></td></tr><tr><td class="d-main" style="width: auto; height: auto;"><div class="d-content" style="padding: 20px 25px;"></div></td></tr><tr><td class="d-footer"><div class="d-buttons"></div></td></tr></tbody></table></div></td><td class="d-e"></td></tr><tr><td class="d-sw"></td><td class="d-s"></td><td class="d-se"></td></tr></tbody></table></div></div>
    		<div class="z_top_container">
			
		</div>
	<div class="top_bg">
		<div class="top"></div>
	</div>
<div class="head_foot_content">
    <div class="header"><div class="header-layer"></div>
        <div class="lin">
            <div class="tit">
                <img src="./bilibili/t2.png" alt="登录">
            </div>
        </div>
        <div class="content-bd" status="available">
      
            <div class="content-l" status="available">
                <div class="inner">
                    <img src="<%=basePath %>img/login.jpg" style="display: block;height:200;width:420">
                  
                 
                   
                    <div id="tv" style="display: block;"></div>
                    <div id="qr-reload">
                        <div class="reload-btn"></div>
                      
                    </div>
                    <div id="download-app">
                        <div class="qrcode" id="app-qrcode"></div>
                     
                    </div>
                </div>
            </div>

            <div class="line"></div>
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
    </div>
</div>
	
	<div class="footer">
	<div class="footer-wrp">
		<div class="footer-cnt clearfix">
			<div class="partner">
				<div class="block left">
					<div class="partner-banner"></div>
				</div>
				<div class="block left" style="margin: 0 0 0 20px;">
	
				</div>
				<div class="block left" style="margin: 0 0 0 20px;">
				
				</div>
				<div class="block right" style="width: 274px;">
					
					<p><a href="http://www.shjbzx.cn/" target="_blank"><i class="icons-footer icons-footer-report"></i></a></p>
				</div>
			</div>
		</div>
	</div>
</div>	
  </body>
</html>

