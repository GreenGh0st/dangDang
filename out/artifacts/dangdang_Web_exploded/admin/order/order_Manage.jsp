<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Dao.DBHelperDao" %>
<%@ page import="entity.OrderInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSP 'foodstype_manage.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />

</head>


<body>
<div class="main userInfo">
	<div class="title">
		<h2>
			<img src="admin/images/ibg1.jpg"/>
			<span>订单管理</span>
		</h2>
	</div>
	<table class="user">
		<tr>

			<th width="120px">订单编号</th>
			<th width="80px">用户名</th>
			<th width="80px">商品名</th>
			<th width="140px">交易状态</th>
			<th width="100px">数量</th>
			<th>操作</th>
		</tr>
		<%
			// 创建dbHelper工具类对象
			DBHelperDao db = new DBHelperDao();
			// 获取数据库查询结果集
			ResultSet resultSet = db.selectAll();
			// 遍历结果集
			while (resultSet.next()){
		%>

		<tr>
			<td><%=resultSet.getString(2)%></td>
			<td><%=resultSet.getString(3)%></td>
			<td><%=resultSet.getString(4)%></td>
			<td><%=resultSet.getString(5)%></td>
			<td><%=resultSet.getString(6)%></td>

			<td>
				<%-- <a href="admin/updateorder.jsp?orderId=<%=order.getOrderID() %>"><img alt="修改订单" src="admin/images/icon3.gif"></img></a>
                | <a href="servlet/Admin_deleteOrder?orderId=<%=order.getOrderID() %>" onclick="return confirm('确定要删除吗？')"><img alt="删除订单" src="admin/images/icon4.gif"></img></a> --%>

				<a href="javaScript:void(0);">订单详情</a>
				| <a href="servlet/Admin_DeleteOrder?orderId=<%=resultSet.getInt(1)%>">取消订单</a>
			</td>

		</tr>
		<%} %>


	</table>
</div>
</body>
</html>
