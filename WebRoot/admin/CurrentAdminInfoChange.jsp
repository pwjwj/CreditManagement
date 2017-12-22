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

<title></title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
</head>

<body>
	<div class="header">
		<div class="center_title">增加学生信息</div>
	</div>
	<div class="center_body">
		<s:form action="modifyAdminInfo.action" theme="simple">
			<div class="info_center">
				<div class="title-left">姓名：</div>
				<span id="userPwdTip" style="color:gray; font-size:1.2em;"><s:text
						name="%{#request.currentAdmin.username}" /></span>
				<s:hidden name="prepairToChangeAdmin.id"
					value="%{#request.currentAdmin.id}" />
				<s:hidden name="prepairToChangeAdmin.username"
					value="%{#request.currentAdmin.username}" />

			</div>

			<div class="info_center">
				<div class="title-left">联系方式：</div>

				<s:textarea name="prepairToChangeAdmin.tel" placeholder="联系方式"
					value="%{#request.currentAdmin.tel}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">备注：</div>

				<s:textarea name="prepairToChangeAdmin.other" placeholder="备注"
					value="%{#request.currentAdmin.other}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">密碼：</div>
				<s:password name="prepairToChangeAdmin.pwd" placeholder="密码"
					value="%{#request.currentAdmin.pwd}"
					cssClass="password user_id_password"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<s:submit value="修改" cssClass="center_div "
					cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" />
				<br>
				<s:if test="#request.currentUser.name == #session.stuName ">
					<a class="center_div" href="/admin/BaseInfo.jsp">返回主页</a>
				</s:if>
			</div>
		</s:form>
	</div>
</body>
</html>
