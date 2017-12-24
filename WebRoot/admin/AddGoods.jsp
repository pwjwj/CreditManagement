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

<title>物品增加</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=basePath%>/css/admin_stuinfo.css">

<script type="text/javascript">
	function beforeadd() {
		var goodsName = document.getElementById("goodsName").value;
		var goodsNumberRemain = document.getElementById("goodsNumberRemain").value;
		if (goodsName == "") {
			alert("物品名不能为空!");
			return false;
		} else if (goodsNumberRemain == "") {
			alert("库存量不能为空!");
			return false;
		} else {
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
		<!-- 这里还有字符串格式的问题 -->
		<s:form action="addGoods.action" theme="simple">
			<div class="info_center">
				<div class="title-left">物品名：</div>
				<s:textarea id="goodsName" name="goodsName" placeholder="物品名"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" />
			</div>
			<div class="info_center">
				<div class="title-left">库存量：</div>
				<s:textarea id="goodsNumberRemain" name="goodsNumberRemain" placeholder="库存量"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"
					onkeyup="value=value.replace(/[^1234567890-]+/g,'')" />
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
