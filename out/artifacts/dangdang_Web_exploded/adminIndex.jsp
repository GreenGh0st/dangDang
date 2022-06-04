<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.util.Vector" %>
<%@page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
  Admin_UserInfo au = (Admin_UserInfo)session.getAttribute("au");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>EDGETECH后台管理</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link type="text/css" rel="stylesheet" href="admin/css/style.css" />
  <script src="./js/jquery-3.4.1.js"></script>
</head>

<body>

<div id="header">
  <div class="logo"><span></span>EDGETECH后台管理系统</div>
  <div class="navigation">
    <ul>
      <li>欢迎您！</li>

      <li><a class="loginUserName" href=""><% String str = (String) session.getAttribute("user");out.print(str); %></a></li>
      <li><a href="">修改密码</a></li>
      <li><a href="">设置</a></li>
      <li><a href="index.jsp">退出</a></li>
    </ul>
  </div>
</div>
<div id="content">
  <div class="left_menu">
    <ul id="nav_dot">
      <li class="nav_dot_li">
        <h4 class="M1"><a href='javascript:void(0)'><span></span>系统公告</a></h4>
        <div class="list-item none">
          <a href="<%=path %>/admin/news/news_Manage.jsp" target="contextFrame">管理网站公告</a>
          <a href="<%=path %>/admin/news/news_Add.jsp" target="contextFrame">添加网站公告</a>
          <!-- <a href=''>系统公告3</a>
          <a href=''>系统公告4</a> -->
        </div>
      </li>

      <li class="nav_dot_li">
        <h4  class="M2"><a href='javascript:void(0)'><span></span>商品类别管理</a></h4>
        <div class="list-item none">
          <a href="<%=path %>/admin/foodstype/foodstype_Manage.jsp" target="contextFrame">管理商品类别</a>
          <a href="<%=path %>/admin/foodstype/foodstype_Add.jsp" target="contextFrame">添加商品类别</a>
        </div>
      </li>

      <li class="nav_dot_li">
        <h4 class="M3"><a href='javascript:void(0)'><span></span>商品信息管理</a></h4>
        <div class="list-item none">
          <a href="<%=path %>/admin/foods/foods_Manage.jsp" target="contextFrame">管理商品信息</a>
          <a href="<%=path %>/admin/foods/foods_Add.jsp" target="contextFrame">添加新的商品</a>
          <!-- <a href=''>添加记录</a> -->
        </div>

      </li>
      <li class="nav_dot_li">
        <h4 class="M4"><a href='javascript:void(0)'><span></span>用户信息管理</a></h4>
        <div class="list-item none">
          <a href="<%=path %>/admin/user/user_Manage.jsp" target="contextFrame">管理用户信息</a>
          <a href="<%=path %>/admin/user/user_Add.jsp" target="contextFrame">添加新的用户</a>
        </div>
      </li>
      <!-- <li class="nav_dot_li">
        <h4 class="M5"><a href='javascript:void(0)'><span></span>购物车管理</a></h4>
        <div class="list-item none">
          <a href=''>评论管理1</a>
          <a href=''>评论管理2</a>
          <a href=''>评论管理3</a>
        </div>
      </li> -->
      <li class="nav_dot_li">
        <h4 class="M6"><a href='javascript:void(0)'><span></span>订单管理</a></h4>
        <div class="list-item none">
          <a href="<%=path %>/admin/order/order_Manage.jsp" target="contextFrame">管理订单信息</a>
          <a href="<%=path %>/admin/order/order_Manage.jsp">审核订单信息</a>
        </div>
      </li>

      <li class="nav_dot_li">
        <h4  class="M7"><a href='javascript:void(0)'><span></span>顾客评价管理</a></h4>
        <div class="list-item none">
          <a href="<%=path %>/admin/comment/comment_Manage.jsp" target="contextFrame">管理顾客评价</a>
          <!--  <a href=" " target="contextFrame">奖励管理2</a> -->

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
        <li><a href="#">顾客信息管理</a></li>
        <li>></li>
        <li><a href="#">顾客信息列表</a></li>
      </ul>
    </div>


    <div class="context">
      <div class="iFrame">
        <iframe name="contextFrame" src="<%=path %>/admin/user/user_Manage.jsp" scrolling="yes" class="x-iframe" ></iframe>
      </div>
    </div> <!--内容网页-->




  </div>
</div>
<div id="footer"><p>Copyright©   版权所有 </p></div>
<script src="admin/js/adminHomePage.js"></script>

</body>
</html>
