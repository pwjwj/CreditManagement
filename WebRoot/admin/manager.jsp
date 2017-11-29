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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath %>/css/adminStyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>/js/jquery1.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery-1.8.0.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.easyui.min.js" charset="utf-8"></script>
	
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
<style>
body {
	margin: 0;
	font-family: 微软雅黑;
}
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
.body_content
{
	position: relative;
	left: 0%;
	width: 100%;
	height: 100%;
}



.end {
	position: absolute;
	bottom: 0px;
	width: 100%;
	height: 30px;
	text-align: center;
	color: #556B2F;
	font-size: 17px;
	font-height: 20px;
	font-family: 楷体;
	background-color: #C0C0C0
}

.spgl {
	position: absolute;
	height: 20px;
	width: 20px;
	left: 40px;
	top: 10px;
	color: white;
	background: url(images/1.png);
}

.yhgl {
	position: absolute;
	height: 20px;
	width: 20px;
	left: 40px;
	top: 10px;
	background: url(images/4.png);
	color: white;
}

.gggl {
	position: absolute;
	height: 20px;
	width: 20px;
	left: 40px;
	top: 10px;
	background: url(images/4.png);
	color: white;
}

.zlgl {
	position: absolute;
	height: 20px;
	width: 20px;
	left: 40px;
	top: 10px;
	background: url(images/4.png);
	color: white;
}

.pjgl {
	position: absolute;
	height: 20px;
	width: 20px;
	left: 40px;
	top: 10px;
	background: url(images/4.png);
	color: white;
}

.tcht {
	position: absolute;
	height: 20px;
	width: 20px;
	left: 40px;
	top: 10px;
	background: url(images/2.png);
	color: white;
}

.div3 {
	display: none;
	cursor: pointer;
	font-size: 15px;
	color: white;
}

.div3 ul {
	margin: 0;
	padding: 0;
}

.div3 li {
	height: 30px;
	line-height: 30px;
	list-style: none;
	border-bottom: #ccc 1px dotted;
	text-align: center;
}

.a {
	text-decoration: none;
	color: white;
	font-size: 15px;
	font-weight:bold;
}

.a1 {
	text-decoration: none;
	color: white;;
	font-size: 18px;
	font-weight:bold;
}
</style>

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
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/BaseInfo.jsp');">基本信息管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddStu.jsp');">新增学生用户</a></li>
					<%-- <li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/adminUser.jsp');">普通管理员</a></li> --%>
				</ul> 
			</div>
			<div class="div2">
				<div class="spgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/CreditActivity.jsp');">信用管理管理</a>
			</div>
			<div class="div3">
			<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddCreditActivity.jsp');">新增学生信用活动</a></li>
				<%-- <ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/addNotice.jsp');">新增公告</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/announcement.jsp');">公告管理</a></li>
				</ul> --%>
			</div>
			<div class="div2">
				<div class="yhgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Creditcategory.jsp');">奖惩事项管理</a>
			</div>
			<div class="div3">
			<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddCreditcategory.jsp');">新增事项</a></li>
				<%-- <ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/newPc.jsp');">新增台式机</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/newLap.jsp');">新增笔记本</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/newPart.jsp');">新增配件</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/searchPc.jsp');">台式机信息变更</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/searchLap.jsp');">笔记本信息变更</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/searchPart.jsp');">配件信息变更</a></li>
				</ul> --%>
			</div>
			
			<div class="div2">
				<div class="pjgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Application.jsp');">申请管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/ApplicationMoney.jsp');">资金申请</a></li>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/ApplicationGoods.jsp');">物资申请</a></li>
				</ul>
			</div>
			
			<div class="div2">
				<div class="pjgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Info.jsp');">通知管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddInfo.jsp');">发布通知</a></li>
					<%-- <li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/badJudge.jsp');">浏览差评</a></li> --%>
				</ul>
			</div>
			<div class="div2">
				<div class="pjgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/Goods.jsp');">物资管理</a>
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>admin/AddGoods.jsp');">物资添加</a></li>
					<%-- <li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>bgpages/badJudge.jsp');">浏览差评</a></li> --%>
				</ul>
			</div>
		</div>	
	</div>

	<div class="body_right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="center"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
	</div>
	</div>
	</div>
	<div class="bottom_footer"></div>
  </body>
</html>
