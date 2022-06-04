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
    <link href="css/sousuo.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        body {
            background-color: #F0F3EF;
        }

        #a1 {
            position: absolute;
            width: 600px;
            height: 400px;
            z-index: 2;
            background-color: #0000FF;
        }

        #a2 {
            position: absolute;
            width: 600px;
            height: 400px;
            z-index: 3;
            background-color: #00FF99;
        }

        #a3 {
            position: absolute;
            width: 600px;
            height: 400px;
            z-index: 4;
            background-color: #CC66CC;
        }

        #a4 {
            position: absolute;
            width: 600px;
            height: 400px;
            z-index: 5;
            background-color: #FFCCFF;
        }

        #b1 {
            position: absolute;
            width: 30px;
            height: 30px;
            z-index: 6;
            left: 743px;
            top: 600px;
        }

        #b2 {
            position: absolute;
            width: 30px;
            height: 30px;
            z-index: 6;
            left: 789px;
            top: 601px;
        }

        #b3 {
            position: absolute;
            width: 30px;
            height: 30px;
            z-index: 6;
            left: 838px;
            top: 600px;
        }

        #b4 {
            position: absolute;
            width: 30px;
            height: 30px;
            z-index: 6;
            left: 884px;
            top: 600px;
        }

        a:link {
            text-decoration: none;
        }

        a:visited {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        a:active {
            text-decoration: none;
        }
    </style>
</head>

<body style="background: #ffffff">
<%@include file="header.jsp" %>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8" user="root"
                   password="xiao502"/>
<sql:query dataSource="${db}" var="rs">
    select bookName,num,price,jj from gwc JOIN book where `name`=bookName and `userName`="${sessionScope.user}";
</sql:query>
<table align="center" width="1190">
    <tr>
        <td id="contents">
            <ul class="list">
                <c:forEach var="row" items="${rs.rows}">
                    <li>
                        <img src="img/${row.bookName}.jpg" width="120" height="200"/>
                        <p>《${row.bookName}》<font color="red">价格：${row.price}元</font></p>
                        <p class="jj">${row.jj}</p>
                        <form id="${row.bookName}form">
                            <input type="hidden" name="book" value="${row.bookName}"/>
                            <input type="hidden" name="number" value="${row.num}"/>
                        </form>
                        <p>数量：${row.num}</p>
                        <a class="gwc" href="javascript:qx('#${row.bookName}form');" style="background:#F90">取消加入购物车</a>
                        <a class="gwc" href="shop.jsp?book=${row.bookName}">去购买</a>
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>
<%@include file="footer.jsp" %>
</body>
</html>