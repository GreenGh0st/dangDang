<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_Update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />

  </head>
  
  <body>
  <%
  		int newsid =Integer.parseInt(request.getParameter("newsId"));
  		NewInfoDao ac = new NewInfoDao();
  		Admin_NewInfo news =ac.selNews(newsid);
  		session.setAttribute("newsid",newsid);
   %>
    <form action="servlet/Admin_UpdateNews" method="post" >
     		    <div class="main newsInfo">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>添加新的公告</span>
					</h2>
				</div>
				<table class="user" bgColor="#eeeeee" >
					<tr>
	                <td align="right">标题：</td>
	                <td><input type="text" style="width: 382px;" name="newsTitle" id="newsTitle" value="<%=news.getNewsTitle() %>"/></td>
	              </tr>
	               <tr>
	                <td align="right">公告内容：</td>
	                <td><textarea name="newsContent" id="newsContent" cols="60" rows="10" style="margin: 30"><%=news.getNewsContent() %></textarea></td>
	              </tr>
	              
	                <tr>
	                <td align="right">发布时间：</td>
	                <td><%=news.getNewsDate() %></td>
	              </tr>
	              
	              <tr>
	              	<td width="200px;"></td>
	              	<td align="left">
	              	  <input type="submit" style="margin-left: 150" value="确认修改">
	              	  <input type="button" style="margin-left: 200" value="返回" onclick=""/>
	              	
	              	</td>	
	              	              	
	              </tr>
					
								
				</table>
					   
         </div>
      </form> 
  </body>
</html>
