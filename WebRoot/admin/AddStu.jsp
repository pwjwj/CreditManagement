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

<title>增加学生</title>
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
	var name = document.getElementById("uName").value;
	var class_ = document.getElementById("uClass").value;
	var number = document.getElementById("uNumber").value;
	var college = document.getElementById("uCollege").value;
	if(name=="")
	{
		alert("姓名不能为空!");
		return false;
	}
	else if(number=="")
	{
		alert("学号不能为空!");
		return false;
	}
	else if(college=="")
	{
		alert("院系不能为空!");
		return false;
	}
	else if(class_=="")
	{
		alert("班级不能为空!");
		return false;
	}
	else
	{
		return true;
	}
}
</script>
</head>

<body>
	<div class="header">
		<div class="center_title">增加学生信息</div>
	</div>
	<div class="center_body">

		<s:form action="addStuBase.action" theme="simple">
			<div class="info_center">
				<div class="title-left">姓名：</div>
				<s:textarea id="uName" name="name" placeholder="姓名"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">学号：</div>
				<s:textarea id="uNumber" name="number" placeholder="学号"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"
					onkeyup="value=value.replace(/[^1234567890-]+/g,'')" />
			</div>
			<div class="info_center">
				<div class="title-left">院系：</div>
				<s:textarea id="uCollege" name="college" placeholder="院系"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">院系：</div>
				<s:textarea name="college" placeholder="院系"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">班级：</div>
				<s:textarea id="uClass" name="class_" placeholder="班级"
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
