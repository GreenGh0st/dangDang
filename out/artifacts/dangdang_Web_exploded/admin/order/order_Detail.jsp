<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order_Detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="admin/css/orderDetail.css">   
	
  </head>
   <%
  		int orderId =Integer.parseInt(request.getParameter("orderId"));
  		OrderCtrl ac = new OrderCtrl();
  		OrderInfo order=ac.selOrder(orderId);
  		session.setAttribute("orderId",orderId);
   %>
  <body>
       <div class="main">
	        <div class="title">
					<h2>
						<span>订单管理</span>
					</h2>
			</div>
	
		  <table class="table1" border="0" cellspacing="0" cellpadding="0">
	  		<tr>
				<td class="key">订单编号：</td>
				<td class="value"><%= order.getOrderNumber() %></td>
			</tr>
			<tr>
				<td class="key">用户名：</td>
				<td class="value">待实现</td>
			</tr>
			<tr>
				<td class="key">收货人：</td>
				<td class="value"><%= order.getConsignee() %></td>
			</tr>
			<tr>
				<td class="key">手机号码：</td>
				<td class="value">待实现</td>
			</tr>
			<tr>
				<td class="key">收货地址：</td>
				<td class="value">待实现</td>
			</tr>
			<tr>
				<td class="key">订单金额：</td>
				<td class="value"><%= order.getFoodPrice() %></td>
			</tr>
			<tr>
				<td class="key">订购时间：</td>
				<td class="value"><%= order.getOrderDate() %></td>
			</tr>
			<tr>
				<td class="key">订单状态：</td>
				<td class="value"><%= order.getOrderStatus() %></td>
			</tr>
			<!-- <tr>
				<td class="key">发货时间：</td>
				<td class="value"></td>
			</tr> -->
			
		    <tr class="tr2">
				<td class="key2">订单商品：</td>
				<td class="tr2">
					
					<table class="table2" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th >商品名称</th>
							<th >商品图片</th>
							<th >单价</th>
							<th >数量</th>
						</tr>
						
						<tr>
							<td><%= order.getFoodName() %> </td>
							<td><img style="width: 120px; height: 55px; margin-top:3px; margin-bottom:5px;" src="<%=order.getFoodImage() %>"/></td>
							<td><%= order.getFoodPrice() %> </td>
							<td><%= order.getFoodCount() %> </td>
						</tr>
						
					</table>

				</td>
		    </tr>
		 
		 <tr>
		 	<td class="sub"> <input class="back" name="btnReturn" type="button" value="返 回"  onclick="history.go(-1);"  />
		 	    <a class="back" href="servlet/Admin_FoodDeliver?orderId=<%=order.getOrderId() %>"> 发货</a>
		 	      
		 	</td>
		 	
		 </tr>
		 
		</table>

	 </div>
  </body>
</html>
