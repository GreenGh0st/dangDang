<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foodstype_Update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />

  </head>
  
  <body>
  <%
	        		int sortid =Integer.parseInt(request.getParameter("sortId"));
	        		FoodInfoDao ac = new FoodInfoDao();
		            FoodType sort = new FoodType();
	        		sort =ac.selType(sortid);
	        		session.setAttribute("sortid",sortid);
	        	 %>        
  
    <form action="servlet/Admin_UpdateFoodType" method="post">
     		    <div class="main newsInfo">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>修改商品类别</span>
					</h2>
				</div>
				<table class="user" bgColor="#eeeeee" >
					<tr>
	                <td align="right">商品类别：</td>
	                <td><input type="text" style="width: 382px;" name="sortName" id="sortName" value="<%=sort.getSortName() %>"/></td>
	              </tr>
	             
	              <tr>
	              	<td width="200px;"></td>
	              	<td align="left">
	              	  <input type="submit" style="margin-left: 250" class="btnbg" value="确认添加">
	              	  <input type="button" style="margin-left: 300" value="返回" onclick=""/>
	              	
	              	</td>	
	              	              	
	              </tr>								
				</table>
					   
         </div>
     </form>
  </body>
</html>
