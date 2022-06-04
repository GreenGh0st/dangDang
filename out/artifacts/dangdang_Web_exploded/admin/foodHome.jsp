<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<<jsp:useBean id="userBean" class="Dao.DBHelperDao" scope="request"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
 	Admin_UserInfo au = (Admin_UserInfo)session.getAttribute("au");
	int pageSize = 5;//定义每页显示的条目数
	int pageNow = 1;//默认显示第一页
	int pageCount = 1;//默认只有1页
	FoodInfoDao food= new FoodInfoDao(); 
	//AdminUserCtrl ac = new AdminUserCtrl();
	if(request.getParameter("pageNow") != null)
	pageNow = Integer.parseInt(request.getParameter("pageNow"));
	//获取总页数
	pageCount = food.getPageCount(pageSize);
	
	//如果小于第一页，则显示第一页
	if(pageNow <= 0){
		pageNow = 1;
	}
	//如果超过最后一页，则显示最后一页
	if(pageNow >= pageCount){
		pageNow = pageCount;
	}                              
	ArrayList<FoodInfo> alFood = food.getFoodForPage(pageSize,pageNow);
 %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />
    <script src="./js/jquery-3.4.1.js"></script>
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
  		window.location.href="foodHome.jsp?pageNow=" + pageNow.value;
  	}
  </script>
  </head>
  
  <body>
    	<div id="header">
		<div class="logo"><span></span>后台管理系统</div>
		<div class="navigation">
			<ul>
			 	<li>欢迎您！</li>
				<li><a class="loginUserName" href=""><%=au.getAdmin_Name()%></a></li>
				<li><a href="">修改密码</a></li>
				<li><a href="">设置</a></li>
				<li><a href="">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
	      	<li class="nav_dot_li">
	          <h4 class="M1"><a href='javascript:void(0)'><span></span>系统公告</a></h4>
	          <div class="list-item none">
	            <a href=''>系统公告1</a>
	            <a href=''>系统公告2</a>
	            <a href=''>系统公告3</a>
	            <a href=''>系统公告4</a>
	          </div>
	        </li>
	        <li class="nav_dot_li">
	          <h4 class="M2"><a href='javascript:void(0)'><span></span>商品管理</a></h4>
	          <div class="list-item none">
	            <a href='#'>商品列表</a>
	            <a href='#'>添加新的商品</a>
	            <a href='#'>###</a>
	          </div>
	         
	        </li>
	        <li class="nav_dot_li">
	          <h4 class="M3"><a href='javascript:void(0)'><span></span>顾客信息管理</a></h4>
	          <div class="list-item none">
	            <a href='#'>顾客信息列表</a>
	            <a href='#'>添加新的会员</a>
	            <a href='#'>用户购买记录</a>
	          </div>
	        </li>
	        <li class="nav_dot_li">
	          <h4 class="M4"><a href='javascript:void(0)'><span></span>购物车管理</a></h4>
	          <div class="list-item none">
	            <a href=''>评论管理1</a>
	            <a href=''>评论管理2</a>
	            <a href=''>评论管理3</a>
	          </div>
	        </li>
	        <li class="nav_dot_li">
	          <h4 class="M5"><a href='javascript:void(0)'><span></span>订单管理</a></h4>
	          <div class="list-item none">
	            <a href=''>调研问卷1</a>
	            <a href=''>调研问卷2</a>
	            <a href=''>调研问卷3</a>
	          </div>
	        </li>
	        <li class="nav_dot_li">
	          <h4  class="M6"><a href='javascript:void(0)'><span></span>支付状态管理</a></h4>
	          <div class="list-item none">
	            <a href=''>数据统计1</a>
	            <a href=''>数据统计2</a>
	            <a href=''>数据统计3</a>
	          </div>
	        </li>
	        <li class="nav_dot_li">
	          <h4  class="M7"><a href='javascript:void(0)'><span></span>顾客留言管理</a></h4>
	          <div class="list-item none">
	            <a href=''>奖励管理1</a>
	            <a href=''>奖励管理2</a>
	            <a href=''>奖励管理3</a>
	          </div>
	        </li>
	        </ul>
	        </div>
			
			<div class="m-right">
				<div class="top"></div>
				<div class="right-nav">
						<ul>
								<li><img src="admin/images/home.png" width="25px" height="25px"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								<li><a href="#">商品管理</a></li>
								<li>></li>
								<li><a href="#">商品列表</a></li>
						</ul>
				</div>
			<div class="main">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>会员管理</span>
					</h2>
				</div>
				<table class="food">
					<tr>
						<th width="100px">商品编号</th>
						<th width="100px">商品名</th>
						<th width="100px">商品图片</th>
						<th width="70px">产地溯源</th>
						<th width="100px">商品价格</th>
						<th width="250px">商品描述</th>
						<th width="70px">状态</th>
						<th>操作</th>
					</tr>

			     <%
                  	for(FoodInfo foods : alFood){   
                  	              	
                  	%>
                  <%-- 	String email=null;                  	
                  	if(user.getUserEmail()==null){
  						email="未填写";
  					}
  					else if("".equals(user.getUserEmail())){
  						email="未填写";
  					}
  					else{
  						email=user.getUserEmail();
  					}  					
                   %>  --%>
                   
					<tr>
						<td><%=foods.getFoodID() %></td>
						<td><%=foods.getFoodName() %></td>
						<td><%=foods.getFoodImage() %></td>						
						<td><%=foods.getFoodAddr() %>></td>
						<td><%=foods.getFoodPrice() %></td>
						<td><%=foods.getDescription() %></td>
						<td>000</td>
						<td>111</td>
						 <%} %> 
					</tr>
					<tr>
						<td style="border:transparent 1px solid;" colspan="9">
							<a href="admin/foodHome.jsp?pageNow=1">首页</a>
							<a href="admin/foodHome.jsp?pageNow=<%=pageNow-1 %>">上一页</a>		
                  			<font><%=pageNow %>/<%=pageCount %></font>
							<a href="admin/foodHome.jsp?pageNow=<%=pageNow+1 %>">下一页</a>
							<a href="admin/foodHome.jsp?pageNow=<%=pageCount %>">尾页</a>
							<font>到</font><input type="text" style="width: 20px;height: 20px;" id="pageNow">页</font>
							<a href="javascript:pageGo()">跳转</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer"><p>Copyright©   版权所有 </p></div>
	<script src="admin/js/adminHomePage.js"></script>
  </body>
</html>
