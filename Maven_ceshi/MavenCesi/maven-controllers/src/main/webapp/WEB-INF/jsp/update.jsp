<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=path%>/static/layui/css/layui.css" rel="stylesheet">
	<style type="text/css">
	 table tr td{
		align:center
	}
	</style>
  </head>
  
  <body>
    <div align="center" style="margin-top:100px" id="cc" class="cc">
    	<h2>${user.id==null?"添加信息":"修改信息"}</h2>
    	<br>
    	<table border="1" class=".table-bordered">
    		<tr>
    			<td style="width: 100px" >姓名:</td>
    			<td style="width: 100px" ><input id="name" type="text" value="${user.name }"></td>
    		</tr>
    		    		<tr>
    			<td>年龄:</td>
    			<td><input type="text" id="age" value="${user.age }"></td>
    		</tr>
    		    		<tr>
    			<td>性别:</td>
    			<td>
    				<input type="radio" name="gender" value="1" ${user.gender ==1?'checked="checked"':'' }>男
    				<input type="radio" name="gender" value="2" ${user.gender ==2?'checked="checked"':'' }>女
    			</td>
    		</tr>
    		  <tr>
    			<td>部门:</td>
    			<td>
    				<select id="department_id">
    					<option value="0">请选择</option>
    					<option value="1" ${user.department_id==1?'selected':'' }>财务部</option>
    					<option value="2" ${user.department_id==2?'selected':'' }>运营部</option>
    					<option value="3"${user.department_id==3?'selected':'' }>维护部</option>
    				</select>
    			</td>
    		</tr>
    		
    	</table>
    	<input type="button" value="提交" onclick="modify(${user.id})" class="layui-btn">
    </div>
  </body>
    <script type="text/javascript" src="static/jquery-1.12.4.js"></script>
 
</html>
