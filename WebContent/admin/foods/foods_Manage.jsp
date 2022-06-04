<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />

  </head>

  <body>
    			<div class="main foodIndo">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>商品管理</span>
					</h2>
				</div>
						<table class="food">

					<tr>
						<th width="70px">商品名</th>
						<th width="70px">商品类别</th>
						<th width="80px">商品价格</th>
						<th width="200px">商品介绍</th>
						<th width="80px">操作</th>
					</tr>
							<%
								// 创建dbHelper工具类对象
								FoodInfoDao db = new FoodInfoDao();
								// 获取数据库查询结果集
								ResultSet resultSet = db.selectAl();
								// 遍历结果集
								while (resultSet.next()){
							%>
					<tr>
						<td><%=resultSet.getString(1)%></td>
						<td><%=resultSet.getString(2)%></td>
						<td><%=resultSet.getString(3)%></td>
						<td><%=resultSet.getString(4)%></td>

						<td>
						    <a href="admin/foods/foods_Update.jsp?foodID=<%=resultSet.getString(5)%>">修改</a>&nbsp;|&nbsp;
					    	<a href="servlet/Admin_DeleteFood?foodID=<%=resultSet.getString(5)%>">下架</a>
						</td>
			  <%} %> 
					</tr>

				</table>
			</div>
  </body>
</html>
