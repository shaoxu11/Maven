<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>
	<link href="<%=path%>/static/layui/css/layui.css" rel="stylesheet">
  </head>
  
  <body>
    	<div align="center" style="margin-top:100px" id="cc" class="cc">
    		<form action="mohu" method="post">
    			<label>姓名:</label><input type="text" name="name">
    			<label>部门:</label>
    			<select name="department_id">
    				<option value="0">请选择</option>
    				<option value="1">财务部</option>
    				<option value="2">运营部</option>
    				<option value="3">维护部</option>
    			</select>
    			<input type="submit" value="查询" class="layui-btn">
    		</form>
    		<table border="1" class="table table-condensed">
    			<tr>
    				<td>姓名</td>
    				<td>年龄</td>
    				<td>性别</td>
    				<td>部门</td>
    				<td>操作</td>
    			</tr>
    			<c:forEach var="user" items="${user}">
    				<tr>
    					<td>${user.name }</td>
    					<td>${user.age }</td>
    					<td>${user.gender }</td>
    					<td>${user.department.name }</td>
    					<td><input class="layui-btn" type="button" value="删除" onclick="del(${user.id});">  <a onclick="update(${user.id})"><input class="layui-btn" type="button" value="修改"></a></td>
    				</tr>
    			</c:forEach>
    		</table>
    		<a href="javascript:;"onclick="add();">添加用户</a>
    	</div>
  </body>
  <script type="text/javascript" src="static/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  function del(id){
   var bol = confirm("确定要删除吗?");
   if(bol == true){
   		$.ajax({
   			url		:	"del",
   			type	:	"post",
   			data	:	"id="+id,
   			success	:	function(data){
   				if(data.type=="success"){
   					alert(data.msg);
   					$(".cc").removeClass();
     				$("#cc").load("index .cc");
   					//location.href="index";
   				}else{
   					alert(data.msg);
   				}
   			},
   			error	: function(){
   				alert("删除出现异常!");
   			}
   			
   		});
   }
  }
 
  function update(id){
  		$(".cc").removeClass();
  		var ise = {
  			"id":id
  		}
     	$("#cc").load("update .cc",ise);
  }
  function add(){
  	$(".cc").removeClass();
  	$("#cc").load("add .cc");
  }
  </script>
   <script type="text/javascript">
  	function modify(id){
  		var name= $("#name").val();
  		var age = $("#age").val();
  		var gender = $("input[name='gender']:checked").val();
  		var department_id = $("#department_id").val();
  		if(name == null || name == ""){
  			alert("请填写姓名");
  		}else if(age == null || age == ""){
  			alert("请填写年龄");
  		}else if(gender == null){
  			alert("请选择性别");
  		}else if(department_id ==0){
  			alert("请选择部门");
  		}else{
  			$.ajax({
  				url		:		"modify",
  				type	:		"post",
  				data	:		{
  					"id":id,
  					"name":name,
  					"age":age,
  					"gender":gender,
  					"department_id":department_id
  				},
  				success	:	function(data){
  					if(data.type=="success"){
  						alert(data.msg);
  						$(".cc").removeClass();
     					$("#cc").load("index .cc");
  						//location.href="index";
  					}else{
  						alert(data.msg);
  					}
  				},
  				error	:	function(){
  					alert("修改出现异常!");
  				}
  			});
  		}
  	}
  </script>
</html>
