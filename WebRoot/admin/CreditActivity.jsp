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

<title>My JSP 'user1.jsp' starting page</title>

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
    $(function() {  
        $('#commUserDatagrid').datagrid({  
            title : '信用活动列表',  
            iconCls : 'icon-ok',  
            width : 1080,  
            pageSize : 5,//默认选择的分页是每页5行数据  
            pageList : [1, 5, 10, 15, 20 ],//可以选择的分页集合  
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮 
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'getAllStudentCreditActivity.action',//url调用Action方法  
            loadMsg : '数据装载中......',  
            singleSelect: false, //允许选择多行  
            selectOnCheck: true,//true勾选会选择行，false勾选不选择行, 1.3以后有此选项。重点在这里  
            checkOnSelect: true, //true选择行勾选，false选择行不勾选, 1.3以后有此选项  
            
            nowrap:false,  
            fitColumns:true,//允许表格自动缩放，以适应父容器   
            fit:false,//允许表格自动缩放，以适应父容器  
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序  
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
            remoteSort : false,  
             frozenColumns : [ [ {  
                field : 'ck',  
                checkbox : true  
            } ] ],   
            pagination : true,//分页  
            rownumbers : true//行数  
        });   
          
    });  
    function formatOper2(val,row,index){ 
    	return '<a href="javascript:void(0)" onclick="deletedata()">删除</a>';   
	}  
	
	function formatOper2_1(val,row,index){ 
    	return '<a href="javascript:void(0)" onclick="changeInfo2('+index+')">修改信息</a>';   
	}  
	function changeInfo2(index){
		$('#commUserDatagrid').datagrid('selectRow',index);// 关键在这里    
    	var rows = $("#commUserDatagrid").datagrid("getSelections");
    	if (rows.length==1){    
            var url = '<%=basePath %>getCreditActivityById.action?activityId='+rows[0].id;
            window.location.href=url;
        }  
	}
	function doSearch(value){
	$('#commUserDatagrid').datagrid({  
            title : '信用活动列表',  
            iconCls : 'icon-ok',  
            width : 1080,  
            pageSize : 5,//默认选择的分页是每页5行数据  
            pageList : [1, 5, 10, 15, 20 ],//可以选择的分页集合  
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮 
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'getAllStudentCreditActivity.action?keyword='+value,//url调用Action方法  
            loadMsg : '数据装载中......',  
            singleSelect: false, //允许选择多行  
            selectOnCheck: true,//true勾选会选择行，false勾选不选择行, 1.3以后有此选项。重点在这里  
            checkOnSelect: true, //true选择行勾选，false选择行不勾选, 1.3以后有此选项  
            nowrap:false,  
            fitColumns:true,//允许表格自动缩放，以适应父容器   
            fit:false,//允许表格自动缩放，以适应父容器  
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序  
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
            remoteSort : false,  
             frozenColumns : [ [ {  
                field : 'ck',  
                checkbox : true  
            } ] ],   
            pagination : true,//分页  
            rownumbers : true//行数  
        });   
}
function deletedata() {  
        //返回选中多行  
        var selRow = $('#commUserDatagrid').datagrid('getSelections')  
        //判断是否选中行  
        if (selRow.length==0) {  
            $.messager.alert("提示", "请选择要删除的行！", "info");  
            return;  
        }else{      
            var temID="";  
            //批量获取选中行的ID  
            for (i = 0; i < selRow.length;i++) {  
                if (temID =="") {  
                    temID = selRow[i].id;  
                } else {  
                    temID = selRow[i].id + "," + temID;  
                }                 
            }  
                        
            $.messager.confirm('提示', '是否删除选中数据?', function (r) {  
  
                if (!r) {  
                    return;  
                }  
                alert(temID);
                //提交  
                $.ajax({  
                    type: "POST",  
                    async: false,  
                    url: "deleteCreditActivityByIds.action?creditActivityIds=" + temID,  
                    data: temID,  
                    success: function (result) {  
                    	alert(result);
                        if (result.indexOf("t") <= 0) {  
                            $('#commUserDatagrid').datagrid('clearSelections');  
                            $.messager.alert("提示", "恭喜您，信息删除成功！", "info");  
                            $('#commUserDatagrid').datagrid('reload');  
                        } else {  
                            $.messager.alert("提示", "删除失败，请重新操作！", "info");  
                            return;  
                        }  
                    }  
                });  
            });  
  
        }  
    };  
</script>
</head>

<body>
	<div style="margin: 10px 0px 0px 15px">
		 <div id="tb" style="float: right;">  
             <input id="keyword" name="keyword" class="easyui-searchbox"  
               searcher="doSearch" prompt="请输入学号搜索"  
               style="width: 130px; vertical-align: middle;"></input>   
         	<button id="delete_button" class="easyui-button" onclick="deletedata()">批量删除</button>
         </div>  
		<table id="commUserDatagrid"  >
			<thead>
				<tr>
					<th data-options="field:'id',width:100,align:'center'">序号</th>
					<th data-options="field:'name',width:100,align:'center'">学号</th>
					<th data-options="field:'number',width:100,align:'center'">姓名</th>
					
					<th data-options="field:'categoryId',width:100,align:'center'">分类号</th>
					<th data-options="field:'detail',width:100,align:'center'">事项详情</th>
					<th data-options="field:'dates',width:100,align:'center'">时间</th>
					<th data-options="field:'credit',width:100,align:'center'">信用分</th>
					<th
						data-options="field:'_operate2',width:80,align:'center',formatter:formatOper2"></th>
					<th
						data-options="field:'_operate2_1',width:80,align:'center',formatter:formatOper2_1"></th>
				</tr>
			</thead>
		</table>

	</div>
</body>
</html>

