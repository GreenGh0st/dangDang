<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <%
	int pageSize = 6;//定义每页显示的条目数
	//会员信息页面
	int pageNow = 1;//默认显示第一页
	int pageCount = 1;//默认只有1页
	//商品信息页面
//	int pageNow1 = 1;//默认显示第一页
	AdminUserCtrl ac = new AdminUserCtrl();

	if(request.getParameter("pageNow") != null)
		pageNow = Integer.parseInt(request.getParameter("pageNow"));

	//获取总页数
	pageCount = ac.getPageCount(pageSize);

	//如果小于第一页，则显示第一页
	if(pageNow <= 0){
		pageNow = 1;
	}

	//如果超过最后一页，则显示最后一页
	if(pageNow >= pageCount){
		pageNow = pageCount;
	}
	ArrayList<UserInfo> alUser = ac.getUserForPage(pageSize,pageNow);

 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>会员信息管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link type="text/css" rel="stylesheet" href="admin/css/style.css" />

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
  		window.location.href="admin/user/user_Manage.jsp?pageNow=" + pageNow.value;
  	}
  </script>
  </head>

  <body>
              <div class="main userInfo">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>会员管理</span>
					</h2>
				</div>
				<table class="user">
					<tr>
						<th width="80px">用户编号</th>
						<th width="100px">用户名</th>
						<th width="80px">姓名</th>
						<th width="60px">性别</th>
						<th width="100px">电话</th>
						<th width="160px">邮箱</th>
						<th width="220px">地址</th>
						<th width="70px">状态</th>
						<th>操作</th>
						<th></th>
					</tr>

					 <%
	                  	for(UserInfo user : alUser){
	                  	String email=null;
	                  	if(user.getUserEmail()==null){
	  						email="未填写";
	  					}
	  					else if("".equals(user.getUserEmail())){
	  						email="未填写";
	  					}
	  					else{
	  						email=user.getUserEmail();
	  					}
                   %>

                   	<tr>

						<td><%=user.getUserId() %></td>
						<td><%=user.getUserName() %></td>
						<td><%=user.getName() %></td>
						<td><%=user.getUserSex() %></td>
						<td><%=user.getUserTel() %></td>
						<td><%=user.getUserEmail() %></td>
						<td><%=user.getUserAddr() %></td>
						<td><%if(user.getUserZt()==0){ %>
							<font style="font-size: 12px;color: #393">正常</font>
							<%} else {%>
							<font style="font-size: 12px;color: red">冻结</font>
							<%}%>
							</td>

						<td>
							<a alt="冻结用户" href="servlet/Admin_UpdateZt?userId=<%=user.getUserId() %>" class="operition item1">
								<img src="admin/images/padlock.png"/>
							</a>
							<a alt="解冻用户" href="servlet/Admin_UpdateZt2?userId=<%=user.getUserId() %>" class="operition item2">
								<img src="admin/images/padlock.png"/>
							</a>
							<%--<a alt="用户操作" href="servlet/Admin_UpdateZt3?userId=<%=user.getUserId() %>" class="operition item3">
								<img src="admin/images/userInfo.png"/>
							</a>--%>
						</td>

						<td>
						 <a href="admin/user/user_Update.jsp?userId=<%=user.getUserId() %>">修改</a>&nbsp;|&nbsp;
						 <a href="servlet/Admin_DeleteUser?userId=<%=user.getUserId() %>">删除</a>
						</td>
						<%} %>

					</tr>
					<tr>
						<td style="border:transparent 1px solid;" colspan="9">
							<a href="admin/user/user_Manage.jsp?pageNow=1">首页</a>
							<a href="admin/user/user_Manage.jsp?pageNow=<%=pageNow-1 %>">上一页</a>
                  			<font><%=pageNow %>/<%=pageCount %></font>
							<a href="admin/user/user_Manage.jsp?pageNow=<%=pageNow+1 %>">下一页</a>
							<a href="admin/user/user_Manage.jsp?pageNow=<%=pageCount %>">尾页</a>
							<font>到</font><input type="text" style="width: 20px;height: 20px;" id="pageNow"><font>页</font>
							<a href="javascript:pageGo()">跳转</a>
						</td>
					</tr>
				</table>
         </div>
  </body>
</html>
