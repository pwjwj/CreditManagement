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

<title>My JSP 'newsManager.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=basePath%>/css/admin_stuinfo.css">

<script type="text/javascript">
	function beforeadd() {
		var detail = document.getElementById("detail").value;
		if (detail == "") {
			alert("詳情不能为空!");
			return false;
		
		} else {
			return true;
		}
	}
</script>
</head>

<body>
	<div class="header">
		<div class="center_title">申请</div>
	</div>
	<div class="center_body">
		<!-- 这里还有字符串格式的问题 -->
		<s:form action="addStuApplication.action" theme="simple">
			<div class="info_center">
				<div class="title-left">类别：</div>
				<s:select name="applicationCategory" list="#{'goods':'goods','money':'money'}" listkey="1"
				 headerKey="" headerValue="--请选择類別--"
					cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;">
				</s:select>
			</div>
			<div class="info_center">
				<div class="title-left">详情：</div>
				<s:textarea id="detail" name="applicationWhat" placeholder="申请详情"
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
