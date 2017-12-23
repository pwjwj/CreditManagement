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
    
    <title>规则修改</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery.min.js" charset="utf-8"></script>
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
	<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
<<<<<<< HEAD
	
	<script type="text/javascript">
	function beforemodify()
	{
		var categoryId = document.getElementById("categoryId").value;
		var categoryName = document.getElementById("categoryName").value;
		var detail = document.getElementById("detail").value;
		var score = document.getElementById("score").value;
	if(categoryId=="")
	{
		alert("分类号不能为空!");
		return false;
	}
	else if(categoryName=="")
	{
		alert("分类名不能为空!");
		return false;
	}
	else if(detail=="")
	{
		alert("详情不能为空!");
		return false;
	}
	else if(score=="")
	{
		alert("分数不能为空!");
		return false;
	}
	else if(categoryId=="${request.currentCreditCategory.id}"&&categoryName=="${request.currentCreditCategory.categoryName}"&&detail=="${request.currentCreditCategory.detail}"&&score=="${request.currentCreditCategory.score}")
	{
		alert("规则未更改!");
		setTimeout("history.go(-1)",1000);
		return false;
	}
	else
		return true;
	}
	</script>
=======
>>>>>>> e1fd9dc08a0cceb1ae067ed70184513611738339
</head>
  
  <body>
       <!--   如果什么也没修改  需要使用js来拦截一下-->
   <div class="header">
  <div class="center_title">奖惩事项规则修改</div>
  </div>
  <div class="center_body">
    <s:form action="modifyCreditCategory.action" theme="simple">
         <div class="info_center"><div class="title-left">分类号：</div>
<<<<<<< HEAD
			<s:textarea id="categoryId" name="prepairToChangeCategory.categoryId" placeholder="分类号" value="%{#request.currentCreditCategory.categoryId}" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" onkeyup="value=value.replace(/[^1234567890-]+/g,'')"/>
=======
			<s:textarea name="prepairToChangeCategory.categoryId" placeholder="分类号" value="%{#request.currentCreditCategory.categoryId}" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
>>>>>>> e1fd9dc08a0cceb1ae067ed70184513611738339
			<s:hidden name="prepairToChangeCategory.id" value="%{#request.currentCreditCategory.id}"/>
        </div>
        <font color="#FF0000" size="3">
        	<s:property value="#request.passwordErro"/>
        </font>
        <div class="info_center"><div class="title-left">分类名：</div>
<<<<<<< HEAD
			<s:textarea id="categoryName" name="prepairToChangeCategory.categoryName" placeholder="分类名" value="%{#request.currentCreditCategory.categoryName}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
       <div class="info_center"><div class="title-left">详情：</div> 
			<s:textarea id="detail" name="prepairToChangeCategory.detail" placeholder="详情" value="%{#request.currentCreditCategory.detail}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
         <div class="info_center"><div class="title-left">分数：</div> 
			<s:textarea id="score" name="prepairToChangeCategory.score" placeholder="分数" value="%{#request.currentCreditCategory.score}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;" onkeyup="value=value.replace(/[^1234567890-]+/g,'')"/>
=======
			<s:textarea name="prepairToChangeCategory.categoryName" placeholder="分类名" value="%{#request.currentCreditCategory.categoryName}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
       <div class="info_center"><div class="title-left">详情：</div> 
			<s:textarea name="prepairToChangeCategory.detail" placeholder="详情" value="%{#request.currentCreditCategory.detail}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div>
         <div class="info_center"><div class="title-left">分数：</div> 
			<s:textarea name="prepairToChangeCategory.score" placeholder="分数" value="%{#request.currentCreditCategory.score}" cssClass="password user_id_password" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
>>>>>>> e1fd9dc08a0cceb1ae067ed70184513611738339
        </div>
         <div class="info_center"></div>
         <div class="info_center"></div>
         <div class="info_center">	
<<<<<<< HEAD
        <s:submit value="修改" cssClass="center_div " cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" onclick="return beforemodify();"/>
=======
        <s:submit value="修改" cssClass="center_div " cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;"/>
>>>>>>> e1fd9dc08a0cceb1ae067ed70184513611738339
        <s:if test="#request.currentUser.cCategoryId == #session.cCategoryId ">
        	 <a class="center_div" href="/admin/Creditcategory.jsp">返回主页</a>
        </s:if>
        </div>
	</s:form>
	</div>
  </body>
</html>
