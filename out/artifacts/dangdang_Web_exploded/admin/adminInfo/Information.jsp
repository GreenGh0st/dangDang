<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Information.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
         <div class="member_show" >
<div class="member_jbxx clearfix" >
  <img class="img" src="images/user.png">
  <dl  class="right_xxln">
  <dt><span class="">康佳</span> <span class="">余额：40</span></dt>
  <dd class="" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
  </dl>
</div>
<div class="member_content">
  <ul>
   <li><label class="label_name">性别：</label><span class="name">男</span></li>
   <li><label class="label_name">手机：</label><span class="name">13456765555</span></li>
   <li><label class="label_name">固定电话：</label><span class="name">021-454443344</span></li>
   <li><label class="label_name">邮箱：</label><span class="name">admin@mail.com</span></li>
   <li><label class="label_name">地址：</label><span class="name">江苏南京市雨花台区创业路5号紫荆花园2懂4单元402</span></li>
   <li><label class="label_name">注册时间：</label><span class="name">2014.12.20</span></li>
   <li><label class="label_name">积分：</label><span class="name">330</span></li>
   <li><label class="label_name">等级：</label><span class="name">普通用户</span></li>
   
  </ul>
</div>
</div>
  </body>
</html>
