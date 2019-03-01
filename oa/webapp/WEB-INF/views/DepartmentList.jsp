<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>部门列表</title>
	
	<!-- 一、引入公共的jsp文件，作用：引入一些基础的文件，如jQuery、easyUI等 -->
	<%@include file="/WEB-INF/views/common.jsp" %>
	
	<!-- 二、本页面的js -->
	<script type="text/javascript">
		$(function(){
			//1.声明组件
			var departmentTableDatagrid = $("#departmentTableDatagrid");//
			var addDepartment = $("#addDepartment");//添加部门
			var editDepartment = $("#editDepartment");//编辑部门，单选
			var delDepartment = $("#delDepartment");//删除选中的部门
			var reloadDepartment = $("#reloadDepartment");//刷新部门列表
			
			//2.部门列表
			departmentTableDatagrid.datagrid({
				url:'/oa/department/departmentList',
				fit: true,
		        singleSelect:true,
		        fitColumns: true,//自适应宽，设置这个时width为比例
		        rownumbers: "true",//自增的序号
		        columns: [[
		            {field: 'department_id', title: '部门ID', width: 20, align: 'center'},
		            {field: 'department_name', title: '部门名称', width: 40, align: 'center'},
		            {field: 'manager_id', title: '经理ID', width: 40, align: 'center'},
		            {field: 'department_parent_id', title: '上级部门ID', width: 40, align: 'center'}
		        ]]
			});
			
			//3.添加部门
			$('#addDepartment').bind('click', function(){    
				$.get('/oa/department/insertDepartment',{'id':1},function(data){
					//提示框
					$.messager.confirm('提示',data.message,function(r){    
					    //刷新部门列表  
						departmentTableDatagrid.datagrid("reload");
					});  
				});   
		    }); 
			
			//4.刷新部门列表  
			$('#reloadDepartment').bind('click', function(){    
				departmentTableDatagrid.datagrid("reload");  
		    }); 
			
			//5.修改部门
			$('#editDepartment').bind('click', function(){    
				$('#addDepartmentDialog').dialog({    
				    title: '添加或修改部门',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: '',    
				    modal: true   
				}); 
		    }); 
		})
	</script>
</head>

	<!-- 三、页面组件 -->
<body>
	<!-- 1.顶层按钮 -->
	<div id="toolbar">
		<a href="javascript:void(0)" id="addDepartment" class="easyui-linkbutton c3" iconCls="icon-add" plain="true">添加</a>
		<a href="javascript:void(0)" id="editDepartment" class="easyui-linkbutton c4" iconCls="icon-edit" plain="true">修改</a>
    	<a href="javascript:void(0)" id="delDepartment" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true">删除</a>
    	<a href="javascript:void(0)" id="reloadDepartment" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true">刷新</a>
	</div>
	
 	<!-- 2.展示部门的列表 -->
 	<table id="departmentTableDatagrid"></table>
 	
 	<!-- 3.添加或修改部门的弹框 -->
 	<!-- 3.1弹框 -->
 	<div id="addDepartmentDialog" class="easyui-dialog" style="width:400px" closed="true"  buttons="#addDepartmentDialogButtons" >
	</div>
	<!-- 3.2按钮 -->
	<div id="addDepartmentDialogButtons">
	    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" id="addDepartmentDialogButtonsOk" style="width:90px">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#addDepartmentDialog').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>