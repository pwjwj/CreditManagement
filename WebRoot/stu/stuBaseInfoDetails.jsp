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
    
    <title>信息修改</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	
	<link rel="stylesheet" href="<%=basePath %>/css/admin_stuinfo.css">
	
	<%-- <script type="text/javascript">
	$(document).ready(
			function() {
			var number="<%=session.getAttribute("userNumber")%>";
			alert(number);
				$.ajax({  
                    type: "POST",  
                    async: false,  
                    data: ID,
                    url: "getCurrentStuByNumber.action?currentStuNumber="+number,
                    data: number,  
                    success: function (result) {  
                    	document.getElementById("number1").name="${request.currentLoginStu.number}";
                    	document.getElementById("number2").value="${request.currentLoginStu.number}";
                    	document.getElementById("uPass").value="${request.currentLoginStu.pwd}";
                    return ;
                    	}
                });  
			});
	
	</script>
 --%>
	<script type="text/javascript"> 
function beforemodify()
{
	var pwd = document.getElementById("uPwd").value;
	if(pwd=="")
	{
		alert("密码不能为空!");
		return false;
	}
	else if(pwd=="${request.currentLoginStu.pwd}")
	{
		alert("密码未更改!");
		setTimeout("history.go(-1)",1000);
		return false;
	}
	else
		return true;
}
</script>
  </head>
  
  <body>
      <!-- 班级显示的有问题 -->
  <div class="header">
  <div class="center_title">信息修改</div>
  </div>
  <div class="center_body">
    <s:form id="infoform" action="modifyLoginedStuInfo.action" theme="simple">
    <%-- <div class="info_center"><div class="title-left">学号：</div><span  style="color:gray;font-size:1.2em;"><s:text id="number1" name="%{#request.currentLoginStu.number}" /></span></div> --%>
    <div class="info_center"><div class="title-left">学号：</div><span  style="color:gray;font-size:1.2em;"><s:textarea id="number1" name="prepairToChangeStuBase.number" /></span></div>
    <div class="info_center"><div class="title-left">姓名：</div><span  style="color:gray;font-size:1.2em;"><s:text id="name1" name="%{#request.currentLoginStu.name}" /></span></div>
    <div class="info_center"><div class="title-left">院系：</div><span  style="color:gray;font-size:1.2em;"><s:text id="college1" name="%{#request.currentLoginStu.college}" /></span></div>
    <div class="info_center"><div class="title-left">班级：</div><span  style="color:gray;font-size:1.2em;"><s:text id="class1" name="%{#request.currentLoginStu.class_}" /></span></div>
    <s:hidden name="prepairToChangeStuBase.credit" value="%{#request.currentLoginStu.credit}"/>
    <s:hidden id="number2" name="prepairToChangeStuBase.number" value="%{#request.currentLoginStu.number}"/>
    <s:hidden id="name2" name="prepairToChangeStuBase.name" value="%{#request.currentLoginStu.name}"/>
    <s:hidden id="college2" name="prepairToChangeStuBase.college" value="%{#request.currentLoginStu.college}"/>
    <s:hidden id="class2" name="prepairToChangeStuBase.class_" value="%{#request.currentLoginStu.class_}"/>
    
    <div class="info_center"><div class="title-left">密码：</div><s:password id="uPwd" name="prepairToChangeStuBase.pwd" placeholder="密码" value="%{#request.currentLoginStu.pwd}" cssStyle="margin-bottom: 0%;height: 90%;width: 30%; resize: none;"/></div>
     <font color="#FF0000" size="3">
        	<s:property value="#request.passwordErro"/>
     </font>
    <div class="info_center"></div>
    <div class="info_center"></div>    
     <div class="info_center">
     <s:submit value="修改" cssStyle="cursor: pointer;font-size: 1.2em;color: white;height: 100%;width: 38%; margin:0 0 0 4%;background-color:#00a1d6;" onclick="return beforemodify();"/>
        <s:if test="#request.currentUser.name == #session.stuName ">
        	 <a class="center_div" href="/admin/BaseInfo.jsp">返回主页</a>
        </s:if>
     </div>
	</s:form>
    </div>
  </body>
</html>
