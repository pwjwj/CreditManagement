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
	
	<script type="text/javascript" src="<%=basePath %>/js/jquery1.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery-1.8.0.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.easyui.min.js" charset="utf-8"></script>
	
	<link href="<%=basePath %>/css/adminStyle.css" rel="stylesheet" type="text/css" />
	
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

</head>
<body>
<div class="body_whole ">
	<div class="top2">
		<div class="title" >高校征信管理系统</div>
		<div class="headr_right">
			<a href="getCurrentStu.action" target="mainCont"><span><s:property value="#session.userName"/></span></a> 
			<a href="<%=basePath %>logout.action" class="easyui-linkbutton" plain="true" style="color:white">退出</a>
		</div>
	</div>

	 <div class="body_content">
	 <div class="body_left">
		<div class="div1">
			<div class="div2">
				<div class="spgl"></div>
				<!-- 基本管理 -->
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>stu/stuBaseInfo.jsp');">基本信息</a>
			</div>
			<div class="div3">
				
			</div>
			<div class="div2">
				<div class="spgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>stu/creditActivity.jsp');">信用查看</a>
			</div>
			<div class="div3">
				
			</div>
			<div class="div2">
				<div class="spgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>stu/Info.jsp');">通知查看</a>
			</div>
			<div class="div3">
				
			</div>
			<div class="div2">
				<div class="spgl"></div>
				
				<a class="a1" href="javascript:void(0);"onClick="openurl('<%=basePath %>stu/application.jsp');">申请查看</a>
		    </div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"onClick="openurl('<%=basePath %>stu/addApplication.jsp');">创建申请</a></li>
					
				</ul>
			</div>
		</div>	
	</div>
	<div class="body_right">
	<div class="right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="center"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
	</div>
	</div>
	</div>
	</div>
	<div class="bottom_footer"></div>
</body>
</html>
