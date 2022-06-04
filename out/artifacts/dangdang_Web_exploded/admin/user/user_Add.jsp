<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_Add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/style.css">
  </head>
  
  <body>
  
       <form action="servlet/Admin_AddUser" method="post">
     		    <div class="main userInfo">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>添加新的会员</span>
					</h2>
				</div>
				<table class="user" bgColor="#eeeeee" style="border: 1px solid lightskyblue">
					
                        
					<tr>
						<td>用户名</td>
                        <td><input type="text" name="userName"/></td>
					</tr>
					
					<tr>
						<td>密码</td>
						<td><input type="text" name="pwd"/></td>
					</tr>
					
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name"/></td>					
					</tr>
					
					<tr>
						<td>性别</td>
						<td>
						<input name="sex" type="radio" checked="checked" value="男"><span class="lbl">男</span>&nbsp;&nbsp;&nbsp;
                        <input name="sex" type="radio" value="女"><span class="lbl">女</span>
						</td>
					</tr>
					
					<tr>
						<td>电话</td>
						<td><input type="text" name="tel"/></td>
					</tr>
					
					<tr>
						<td>邮箱</td>
						<td><input type="text" name="userEmail"/></td>
					</tr>
					
					<tr>
						<td>地址</td>
						<td><input type="text" name="address"/></td>
					</tr>
					
					<tr>
						<td>状态</td>
						<td><input type="text" name="userState" value="0"/>0为正常，1表示账户冻结</td>
					</tr>
					
					<tr>
					   <td></td>
					   <td> <input type="submit" style="margin-left: 100" value="确认添加"/>
						  <input type="button" style="margin-left: 200" value="返回" onclick=""/>
					   </td>
					</tr>
								
				</table>
			
				   
         </div>
      </form> 
  </body>
</html>
