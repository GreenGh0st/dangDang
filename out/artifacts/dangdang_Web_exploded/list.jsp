<%@page import="java.util.Vector" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>筛选列表</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/list.js"></script>
    <link href="css/list.css" rel="stylesheet" type="text/css">
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8" user="root"
                   password="xiao502"/>

<sql:query dataSource="${db}" var="rs">
    <c:if test="${not empty param.type}">
        select name,price,jj,sy from book where type="${param.type}";
    </c:if>
    <c:if test="${not empty param.search}">
        select name,price,jj,sy from book where name like "%${param.search}%";
    </c:if>
</sql:query>

<ul class="list">
    <c:forEach var="row" items="${rs.rows}">
        <li>
            <img src="img/${row.name}.jpg" width="200" height="200"/>
            <p>《${row.name}》<span style="color: red; ">价格：${row.price}元</span></p>
            <p class="jj">${row.jj}</p>
            <form id="${row.name}form" action="UpGwc" method="post">
                <input type="hidden" name="book" value="${row.name}"/>
                <a href="javascript:f('${row.name}num');"
                   style="background:#333; margin-right:4px; padding:1px 7px 1px 7px">-</a>
                <input id="${row.name}num" name=num type="text" value="1" style="width:15px">
                <a href="javascript:j('${row.name}num');" style="background:#333;padding:2px 5px 2px 5px">+</a>
            </form>
            <a class="gwc" href="javascript:ale('#${row.name}form');" style="background:#F90">加入购物车</a>
            <a class="gwc" href="shop.jsp?book=${row.name}">去购买</a>
        </li>
        <tr>
            <td height="40" align="center" valign="middle" bgcolor="#FFFFFF"><a href="#">关注 </a> <a href="#">分享</a></td>
        </tr>
        <tr>
            <td width="100" height="50" bgcolor="#FFFFFF" class="xiangqing">商品介绍</td>
        </tr>
        <tr>
            <td width="100" height="100"><img src="<c:url value="/img/haoping.jpg"/>" width="100" height="100"/></td>
            <td width="900" height="100"><p class="jj">${row.jj}</p>　</td>
        </tr>
    </c:forEach>
</ul>
</body>
</html>