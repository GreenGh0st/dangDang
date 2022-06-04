<%--
  Created by IntelliJ IDEA.
  User: a9149
  Date: 2022/3/21
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Vector" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<head>
    <title>Title</title>
    <link href="css/cpu.css" rel="stylesheet" type="text/css">
</head>
<body>
<td class="button"><a href="index.jsp">返回</a></td>
<%

    String str = (String) session.getAttribute("sessionName");

    out.print("当前用户:" + str);

%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8" user="root"
                   password="xiao502"/>

<sql:query dataSource="${db}" var="rs">

        select * from book where userName="+str+";


</sql:query>
<%

    String username = (String) session.getAttribute("sessionName");

    String password = request.getParameter("password").trim();

    String role = request.getParameter("role").trim();

    String sql="select * from user where userName="+str+"";



    }
%>


</body>
</html>
