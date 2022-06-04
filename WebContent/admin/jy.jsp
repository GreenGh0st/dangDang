<%@page import="Dao.DBHelperDao"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<jsp:useBean id="userBean" class="Dao.DBHelperDao" scope="request"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>验证登录页面</title>
    
  </head>
  
  <body>
  <%
  	request.setCharacterEncoding("utf-8");
  	String name = request.getParameter("userName");
  	String pass = request.getParameter("userPwd");
  		Connection con = userBean.getConnection();
  		Statement stmt = con.createStatement();
  		String sql = "select * from admin where loginName='"+name+"'and loginPass = '"+pass+"'";
  		ResultSet rs = stmt.executeQuery(sql);
  		if(rs.next())
  		{
  			session.setAttribute("userName", name);
  			response.sendRedirect("adminIndex.jsp");
  		}
  		else
  		{
			out.print("<script>alert('用户名或密码错误，请重新输入！'); window.location='admin/adminLogin.jsp'</script>");
  		}
  		rs.close();
  		stmt.close();
  		con.close();
  	%>
  </body>
</html>
