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
    
    <title>My JSP 'manager.jsp' starting page</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

	<link href="<%=basePath %>/css/adminStyle.css" rel="stylesheet" type="text/css" />


	<script type="text/javascript" src="<%=basePath %>/js/jquery1.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.easyui.min.js" charset="utf-8"></script>
	
	<link href="<%=basePath %>/css/adminStyle.css" rel="stylesheet" type="text/css" />
	
	<style>
	.body_whole 
{
   position: relative;
	left: 0%;
	width: 100%;
	height: 84%;
	background-image: url(./img/content_bg.JPG);
	background-repeat: no-repeat;
	background-size: 100%;
}
	</style>
	
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".div2").click(
						function() {
							$(this).next("div").slideToggle("slow").siblings(
									".div3:visible").slideUp("slow");
						});
			});
	function openurl(url) {
		var rframe = parent.document.getElementById("rightFrame");
		rframe.src = url;
	}
</script>

  </head>
  
  <body>
    <div class="body_whole ">
	<div class="top2">
		<div class="title" >高校征信管理系统</div>
		<div class="headr_right">
			<a href="getCurrentAdmin.action" target="mainCont"><span><s:property value="#session.userName"/></span></a> 
			<a href="<%=basePath %>logout.action" class="easyui-linkbutton" plain="true" style="color:white">退出</a>
		</div>
	</div>
    <div class="body_content">
	<div class="body_left">
		<div class="div1">
			<div class="div2">
				<div class="spgl"></div>
				<!-- 基本管理 -->
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/BaseInfo.jsp');">学生信息管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddStu.jsp');">新增学生</a></li>
				</ul> 
			</div>
			<div class="div2">
				<div class="spgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/CreditActivity.jsp');">信用管理</a>
			</div>
			<div class="div3">
			<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddCreditActivity.jsp');">新增信用活动</a></li>
				<%-- <ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/addNotice.jsp');">新增公告</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/announcement.jsp');">公告管理</a></li>
				</ul> --%>
			</div>
			<div class="div2">
				<div class="sjgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Application.jsp');">申请管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/ApplicationMoney.jsp');">资金申请</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/ApplicationGoods.jsp');">物资申请</a></li>
				</ul>
			</div>
			
			<div class="div2">
				<div class="sjgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Info.jsp');">通知管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddInfo.jsp');">发布通知</a></li>
					<%-- <li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/badJudge.jsp');">浏览差评</a></li> --%>
				</ul>
			</div>
			<div class="div2">
				<div class="shgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Creditcategory.jsp');">奖惩事项管理</a>
			</div>
			<div class="div3">
			<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddCreditcategory.jsp');">新增事项</a></li>
				
			</div>
			<div class="div2">
				<div class="sjgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Goods.jsp');">物资管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddGoods.jsp');">物资添加</a></li>
				</ul>
			</div>
		</div>	
		</div>
	<div class="body_right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="center"
			style="border-style: none; margin: 0; padding: 0;"></iframe>
	</div>
	</div>
	</div>
	<div class="bottom_footer"></div>
  </body>
</html>
