<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>淘四季后台管理系统登录</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/adminLogin.css"/>
	<script src="https://cdn.jsdelivr.net/npm/vue"></script>
	<script src="./js/jquery-3.4.1.js"></script>

</head>

<body>
<div class="header">
	后台管理系统
</div>
<div class="login_main">
	<div class="login">
		<div class="login_tab">
			<span>管理员登录</span>
			<a href="#">
				注册管理员
				<i class="icon"></i>
			</a>
		</div>
		<div class="login_body">
			<ul class="phone_ul">
				<form id="fm4" name="Regsiter" action="servlet/Admin_LoginServlet" method="post">
					<li>
						<div class="loginErrorBox">
							<div class="loginErro" id="loginErro">
								<span class="erroIcon"></span>
								<span class="erroTips">错误提示</span>
							</div>
						</div>
						<div class="loginPhone">
							<div class="phone_icon">
								<span class="icon"></span>
							</div>
							<div class="phone_ipt">
								<input class="userName" name="userName" size="25" type="text" size="20" placeholder="请输入账号">
								<em class="closeIcon" id="usernamelogo"></em>
							</div>

						</div>
					</li>
					<li class="m-t14">
						<div class="loginCode">
							<div class="code_icon">
								<span class="icon"></span>
							</div>
							<div class="code_ipt">
								<input class="userPwd" name="userPwd" placeholder="请输入密码" size="20" type="password">
							</div>
							<a href="javascript:void(0)" class="verificationCode">忘记密码</a>
						</div>
					</li>
					<li class="btn_sub" id="btn_sub">
						<input class="login_sub" type="submit" value="登录">
					</li>
					<li>
						<div class="pwlogin">
							<a href="login.jsp" class="phone-words floatleft ac_loginUsername">返回用户界面 > </a>
							<input type="reset"value="重置">
						</div>
					</li>
				</form>
			</ul>
		</div>
	</div>
</div>
<div class="footer">
			<span>
				<a href="" class="footerlink1" rel="nofollow">关于我们</a>
				<a href="" class="footerlink1" rel="nofollow">联系我们</a>
				<a href="" class="footerlink1" rel="nofollow">人才招聘</a>
				<a href="" class="footerlink1" rel="nofollow">友情链接</a>
				<a href="" class="footerlink1 clear" rel="nofollow">供应商链接</a>
			</span>
	<p>计算机与信息工程学院<br>肖子键</p>
</div>
<script src="admin/js/jiaoyan.js"></script>
</body>
</html>
