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

<title>管理员增加</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=basePath%>/css/admin_stuinfo.css">
	
	<script type="text/javascript">
function beforeadd()
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
	else
	{
		var partten=/^T/g;
		var Start=name.match(partten);
		if(!Start)
		{
			alert("姓名必须以T开头!");
			return false;
		}else
		{
			return true;
		}
	}
		
}
</script>
</head>

<body>
	<div class="header">
		<div class="center_title">增加管理员</div>
	</div>
	<div class="center_body">
		<!--这里还有字符串格式的问题-->
		<s:form action="addAdminBase.action" theme="simple">
			<div class="info_center">
				<div class="title-left">用户名：</div>
				<s:textarea id="adminName" name="username" placeholder="请以T开头"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">密码：</div>
				<s:textarea id="adminPwd" name="pwd" placeholder="密码"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">联系方式：</div>
				<s:textarea id="adminTel" name="tel" placeholder="联系方式"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">备注信息：</div>
				<s:textarea id="adminOther" name="other" placeholder="备注信息"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center"></div>
			<div class="info_center"></div>
			<div class="info_center">
				<s:submit value="新增"
					cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" onclick="return beforeadd();"/>
			</div>
		</s:form>
	</div>
</body>
</html>
