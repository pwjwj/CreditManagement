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
    
    <title>通知修改</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/default/easyui.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/easyUI/jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/easyUI/jquery-easyui-1.3.2/jquery-1.8.0.min.js" charset="utf-8"></script>
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
		var infoTitle = document.getElementById("infoTitle").value;
		var infoContent = document.getElementById("infoContent").value;
		if(infoTitle=="")
		{
			alert("通知标题不能为空!");
			return false;
		}
		else if(infoContent=="")
		{
			alert("通知内容不能为空!");
			return false;
		}
		else if(infoTitle=="${request.currentInfoSelectedId.id}"&&infoContent=="${request.currentInfoSelectedId.infoContent}")
		{
			alert("通知未更改!");
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
  <div class="header">
  <div class="center_title">通知修改</div>
  </div>
        <!--  如果什么也没修改  需要使用js来拦截一下,字符编码也不太对-->
  <div class="center_body">
    <s:form action="modifyInfo.action" theme="simple">
    	
        <div class="info_center"><div class="title-left">标题名称：</div>
<<<<<<< HEAD
        <s:textarea id="infoTitle" name="prepairToInfo.infoTittle" placeholder="通知标题" value="%{#request.currentInfoSelectedId.infoTittle}" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
=======
        <s:textarea name="prepairToInfo.infoTittle" placeholder="通知标题" value="%{#request.currentInfoSelectedId.infoTittle}" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
>>>>>>> e1fd9dc08a0cceb1ae067ed70184513611738339
            <s:hidden name="prepairToInfo.id" value="%{#request.currentInfoSelectedId.id}"/>
    		<s:hidden name="prepairToInfo.infoTime" value="%{#request.currentInfoSelectedId.infoTime}"/>
        </div>

         <div class="info_center"><div class="title-left">通知内容：</div>
<<<<<<< HEAD
			<s:textarea id="infoContent" name="prepairToInfo.infoContent" placeholder="通知内容" value="%{#request.currentInfoSelectedId.infoContent}"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div> 
        <div class="info_center"></div>
        <div class="info_center"></div>
        <div class="info_center"><s:submit value="修改" cssClass="center_div " cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;"
        onclick="return beforemodify();"/>
=======
			<s:textarea name="prepairToInfo.infoContent" placeholder="通知内容" value="%{#request.currentInfoSelectedId.infoContent}"  cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/>
        </div> 
        <div class="info_center"></div>
        <div class="info_center"></div>
        <div class="info_center"><s:submit value="修改" cssClass="center_div " cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;"/><br>
>>>>>>> e1fd9dc08a0cceb1ae067ed70184513611738339
        <s:if test="#request.currentUser.cCategoryId == #session.cCategoryId ">
        	 <a class="center_div" href="/admin/Creditcategory.jsp">返回主页</a>
        </s:if>
        </div>
	</s:form>
    </div>
 
	
  </body>
</html>
