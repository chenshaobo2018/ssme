<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>部门列表</title>
	<!-- 引入公共的jsp文件，作用：引入一些基础的文件，如jQuery、easyUI等 -->
	<%@include file="/WEB-INF/views/common.jsp" %>
	<!-- 本页面的js -->
	<script type="text/javascript">
		$(function(){
			//声明组件
			var departmentTableDatagrid = $("#departmentTableDatagrid");
			
			//部门列表
			departmentTableDatagrid.datagrid({
				url:'/department/getAll',
				fit: true,
		        singleSelect:true,
		        fitColumns: true,//自适应宽，设置这个时width为比例
		        rownumbers: "true",//自增的序号
		        columns: [[
		            {field: 'department_id', title: '部门ID', width: 20, align: 'center'},
		            {field: 'department_name', title: '合同名称', width: 40, align: 'center'},
		            {field: 'manager_id', title: '经理ID', width: 40, align: 'center'},
		            {field: 'department_parent_id', title: '上级部门ID', width: 40, align: 'center'}
		        ]]
			});
		})
	</script>
</head>
<body>
	<!-- 顶层按钮 -->
	<div id="toolbar">
	
	</div>
 	<!-- 展示部门的列表 -->
 	<table id="departmentTableDatagrid"></table>
 	
</body>
</html>
</html>