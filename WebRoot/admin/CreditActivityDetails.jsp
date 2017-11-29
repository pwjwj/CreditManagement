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
  <div class=" ">
    <div class="line"></div>
   <div class="reg-title title1" style="background-image:url('./bilibili/t3.png')"></div>
    <div class="center_title">
      <style>
        .blue{
          margin-right: 280px;
        }
      </style>
        如果什么也没修改  需要使用js来拦截一下
    <s:form action="modifyCreditActivity.action" theme="simple">
    	<div class="box center_div">
    		
    		<s:hidden name="prepairToChangeUser.id" value="%{#request.currentCreditActivity.id}"/>
    		
        </div>
        <div class="box center_div">
         	 
			<s:textarea name="prepairToChangeActivity.number" placeholder="学号" value="%{#request.currentCreditActivity.number}"  cssStyle="margin-bottom: 0;height: 40px;width: 300px;"/>
        </div>
        <font color="#FF0000" size="3">
        	<s:property value="#request.passwordErro"/>
        </font>
        <div class="box center_div">
         	 
			<s:textarea name="prepairToChangeActivity.name" placeholder="姓名" value="%{#request.currentCreditActivity.name}" cssClass="password user_id_password" cssStyle="margin-bottom: 0;height: 40px;width: 300px;"/>
        </div>
        <div class="box center_div">
         	 
			<s:textarea name="prepairToChangeActivity.categoryId" placeholder="分类号" value="%{#request.currentCreditActivity.categoryId}" cssClass="password user_id_password" cssStyle="margin-bottom: 0;height: 40px;width: 300px;"/>
        </div>
        <div class="box center_div">
			<s:textarea name="prepairToChangeActivity.detail" placeholder="事项详情" value="%{#request.currentCreditActivity.detail}" cssClass="password user_id_password" cssStyle="margin-bottom: 0;height: 40px;width: 300px;"/>
        </div>
        <div class="box center_div">
         	 
			<s:textarea name="prepairToChangeActivity.dates" placeholder="日期" value="%{#request.currentCreditActivity.dates}" cssClass="password user_id_password" cssStyle="margin-bottom: 0;height: 40px;width: 300px;"/>
        </div>
        
        <br/>  
        <s:submit value="修改" cssClass="center_div " cssStyle="height: 40px;width: 400px; margin:0 0 0 -10;background-color:#00a1d6;"/><br>
        <s:if test="#request.currentUser.activityId == #session.activityId ">
        	 <a class="center_div" href="/admin/BaseInfo.jsp">返回主页></a>
        </s:if>
	</s:form>
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
					<p>广播电视节目制作经营许可证：<span>（沪）字第1248号 </span></p>
					<p>网络文化经营许可证：<span>沪网文[2013]0480-056号</span></p>
					<p>信息网络传播视听节目许可证：<span>0910417</span></p>
				</div>
				<div class="block left" style="margin: 0 0 0 20px;">
					<p>互联网ICP备案：<span>沪ICP备13002172号-3</span></p>
					<p>沪ICP证：<span>沪B2-20100043</span></p>
				</div>
				<div class="block right" style="width: 274px;">
					<p>违法不良信息举报邮箱：<span>help@hotelDemo</span></p>
					<p>违法不良信息举报电话：<span>4000233233 转 3</span></p>
					<p><a href="http://www.shjbzx.cn/" target="_blank"><i class="icons-footer icons-footer-report"></i><span>上海互联网举报中心</span></a></p>
				</div>
			</div>
		</div>
	</div>
</div>		
	
  </body>
</html>
