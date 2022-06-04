<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	int pageSize = 5;//定义每页显示的条目数
	int pageNow = 1;//默认显示第一页
	int pageCount = 1;//默认只有1页
	NewInfoDao ac = new NewInfoDao();
	if(request.getParameter("pageNow") != null)
	pageNow = Integer.parseInt(request.getParameter("pageNow"));
	//获取总页数
	pageCount = ac.getNewsCount(pageSize);
	
	//如果小于第一页，则显示第一页
	if(pageNow <= 0){
		pageNow = 1;
	}
	//如果超过最后一页，则显示最后一页
	if(pageNow >= pageCount){
		pageNow = pageCount;
	}
	ArrayList<Admin_NewInfo> anews = ac.getNewsForPage(pageSize,pageNow);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_Manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />
  </head>
  <script type="text/javascript">
  	function pageGo(){
  		var pageNow = document.getElementById("pageNow");
  		if(pageNow.value.length==0){
				alert("请输入要跳转的页数！");
				pageNow.value="";
				pageNow.focus();
				return;	
			}
		if(isNaN(pageNow.value)){
				alert("请输入正确的页数！");
				pageNow.value="";
				pageNow.focus();
				return;	
			}
  		window.location.href="admin/news/news_Manage.jsp?pageNow=" + pageNow.value;
  	}
  </script>
  <body>
             <div class="main news">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>公告管理</span>
					</h2>
				</div>
				<table class="user">
					<tr>
						
						<th>公告编号</th>
						<th>标题</th>
						<th>详情</th>
						<th>发布时间</th>
						<th>操作</th>
					</tr>
				
                   <%
                  	for(Admin_NewInfo news : anews){                  	
                   %> 
                  <tr>
					<td style="border-left:#D8E7F6 1px solid;"><%=news.getNewsId() %></td>
					<td><%=news.getNewsTitle() %></td>
					<td><%=news.getNewsContent() %></td>
					<td><%=news.getNewsDate() %></td>
                    <td>
						<a href="admin/news/news_Update.jsp?newsId=<%=news.getNewsId() %>">修改</a>		
						| <a href="servlet/Admin_DeleteNews?newsId=<%=news.getNewsId() %>">删除</a>
					</td>                    
                  </tr>
                  <%} %>
                   <tr>
                  		<td style="border-left:#CFE0F0 1px solid;" colspan="7">
                  			<a href="admin/news/news_Manage.jsp?pageNow=1">首页</a>
                  			<a href="admin/news/news_Manage.jsp?pageNow=<%=pageNow-1 %>">上一页</a>                  			
                  			<font style="color: red; font-size: 12px;"><%=pageNow %>/<%=pageCount %></font>
                  			<a href="admin/news/news_Manage.jsp?pageNow=<%=pageNow+1 %>">下一页</a>
                  			<a href="admin/news/news_Manage.jsp?pageNow=<%=pageCount %>">尾页</a>
                  			<font style="color: red; font-size: 12px;">到第</font><input type="text" style="width: 20px;height: 20px;" id="pageNow"><font style="color: red; font-size: 12px;">页</font>
                  			<a href="javascript:pageGo()">跳转</a>                  			
                  		</td>
                  </tr>
				</table>
         </div>   

  </body>
</html>
