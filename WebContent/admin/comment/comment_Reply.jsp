<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comment_Reply.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/register.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
            int commentId =Integer.parseInt(request.getParameter("commentId")); 			
 			CommentInfoDao ac = new CommentInfoDao();
 			ArrayList<CommentInfo> acomment=ac.goodsComment(commentId);
 			for(CommentInfo comment : acomment){
 			session.setAttribute("commentId", commentId);
           // UserInfo user = ac.selUser(userid);	
           // session.setAttribute("userid",userid);
          
  
    %>
    <div class="main">
            <div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>回复评论</span>
					</h2>
				</div>
  		<form action="servlet/Admin_ReplyComment" method="post">
  				<table>
  					<tr>
  						<td class="left">用户名：</td>
  						<td class="right"><%=comment.getUserName() %></td>
  					</tr>
  					<tr>
  						<td class="left">所购商品：</td>
  						<td class="right">
  						    <%
					     int foodID = comment.getFoodID();
						  FoodInfoDao fc = new FoodInfoDao();
						  ArrayList<FoodInfo> afood =fc.selFood(foodID);
						  for(FoodInfo food : afood){					 		  
						 %>						
	               	 	      <%=food.getFoodName() %>
	               	 	 <%} %>
  						</td>
  					</tr>
  					<tr>
  						<td class="left">商品质量：</td>
  						<td class="right"><%=comment.getFoodQuality() %></td>
  					</tr>
  					<tr>
  						<td class="left">配送服务：</td>
  						<td class="right"><%=comment.getCom_delivery() %></td>
  					</tr>
  					<tr>
  						<td class="left">服务质量:</td>
  						<td class="right"><%=comment.getCom_serve() %></td>
  					</tr>
  					<tr>
  						<td class="left">评价内容:</td>
  						<td class="right"><%=comment.getCom_context() %></td>
  					</tr>
  					<tr>
  						<td class="left">评价时间:</td>
  						<td class="right"><%=comment.getCom_data() %>0</td>
  					</tr>
  					<tr>
  						<td class="left">回复:</td>
  						<td class="right"><textarea name="reply" placeholder="管理员回复用户评价"  autofocus=""><%=comment.getAdmin_Reply() %></textarea></td>
  					</tr>
  					<tr>
  						<td style="border: none;"><input class="tijiao" type="submit" value="提交"/></td>
  						<td style="border: none;">
  							<input class="back" type="button" value="返回" onclick="history.go(-1);"/>
  						</td>
  					</tr>
  				</table>
  		</form>
  	<%} %>
  	</div>
  </body>
</html>
