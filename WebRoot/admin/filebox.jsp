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
    
    <title>My JSP 'user1.jsp' starting page</title>
    
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
    $("#ff").form('submit', {
                        url: '/Trainee/importHead',
                        data: $("#ff").serialize(),
                        success: function (result) {

                        }
                    });
</script>  
  </head>
  
  <body>
 
  <div>
  	<form id="registerForm" method="post" action="register_assureUI.action"  enctype="multipart/form-data">  
    <table>  
        <tr>  
                <td style="background-color: #EFEFEF;">  
                    <font>营业执照:</font>  
                </td>  
                <td>  
                  <input class="easyui-filebox" name="source" id="source_sign" style="width:100%"/>  
                	<button id="delete_button" class="easyui-submit"  >tijiao</button>
                </td>  
                
               
         </tr>  
    </table>  
</form>  
  </div>
  </body>
</html>

