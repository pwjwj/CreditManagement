<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>admininfochange</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyUI/jquery-easyui-1.3.2/themes/icon.css">

<script type="text/javascript"
	src="<%=basePath%>/easyUI/jquery-easyui-1.3.2/jquery-1.8.0.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>/easyUI/jquery-easyui-1.3.2/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript">
	var msg = "${requestScope.tipMessage}";
	if (msg != "") {
		alert(msg);
	}
</script>
<script type="text/javascript" src="<%=basePath%>/bilibili/nav.js"
	charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>/bilibili/loc"
	charset="utf-8"></script>

<link rel="stylesheet" href="<%=basePath%>/css/admin_stuinfo.css">

<script type="text/javascript">
function beforemodify()
{
	var name = document.getElementById("adminName").value;
	var adminTel = document.getElementById("adminTel").value;
	var adminOther = document.getElementById("adminOther").value;
	var adminPwd = document.getElementById("adminPwd").value;
	if(name=="")
	{
		alert("姓名不能为空!");
		return false;
	}else if(adminTel=="")
	{
		alert("联系方式不能为空!");
		return false;
	}else if(adminOther=="")
	{
		alert("备注不能为空!");
		return false;
	}
	else if(adminPwd=="")
	{
		alert("密码不能为空!");
		return false;
	}
	else if(name=="${request.currentAdmin.username}"&&adminTel=="${request.currentAdmin.tel}"&&adminOther=="${request.currentAdmin.other}"&&adminPwd=="${request.currentAdmin.pwd}")
	{
		alert("信息未更改!");
		setTimeout("history.go(-1)",1000);
		return false;
	}
	else
		return true;
}
</script>

</head>

<body>
	<div class="header">
		<div class="center_title">管理员信息变更</div>
	</div>
	<div class="center_body">
		<s:form action="modifyAdminInfos.action" theme="simple">
			<div class="info_center">
				<div class="title-left">姓名：</div>
				<s:textarea id="adminName" name="prepairToChangeAdmin.username" placeholder="姓名"
					value="%{#request.currentAdmin.username}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
				<s:hidden name="prepairToChangeAdmin.id"
					value="%{#request.currentAdmin.id}" />
			</div>

			<div class="info_center">
				<div class="title-left">联系方式：</div>

				<s:textarea id="adminTel" name="prepairToChangeAdmin.tel" placeholder="联系方式"
					value="%{#request.currentAdmin.tel}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">备注：</div>

				<s:textarea id="adminOther" name="prepairToChangeAdmin.other" placeholder="备注"
					value="%{#request.currentAdmin.other}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">密码：</div>
				<s:password id="adminPwd" name="prepairToChangeAdmin.pwd" placeholder="密码"
					value="%{#request.currentAdmin.pwd}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center"></div>
			<div class="info_center"></div>
			<div class="info_center">
				<s:submit value="修改" cssClass="center_div "
					cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" onclick="return beforemodify();"/>
				<br>
				<s:if test="#request.currentUser.name == #session.stuName ">
					<a class="center_div" href="/admin/BaseInfo.jsp">返回主页</a>
				</s:if>
			</div>
		</s:form>
	</div>
</body>
</html>
