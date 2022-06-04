<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>买买买！</title>
    <script type="text/javascript" src="js/list.js"></script>
    <style type="text/css">
        .gm {
            width: 100px;
            height: 40px;
            line-height: 38px;
            background: #ff2832;
            border-radius: 3px;
            display: inline-block;
            color: #fff;
            text-align: center;
            font-size: 15px;
            margin-bottom: 10px;
        }

        .gm:hover {
            background-color: #4d4d4d;
            color: #b3d7ff;
            cursor: pointer;
        }

        .jiajian {
            width: 20px;
            height: 20px;
            line-height: 20px;
            background: #ff2832;
            border-radius: 3px;
            display: inline-block;
            color: #fff;
            text-align: center;
            font-size: 15px;
            margin-bottom: 10px;
        }

        .jiajian:hover {
            background-color: #4d4d4d;
            color: #b3d7ff;
            cursor: pointer;
        }
    </style>
</head>
<body style="background: #ffffff">
<%@include file="header.jsp" %>
<table align="center" width="1190">
    <tr>
        <td id="contents">

            <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                               url="jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8"
                               user="root" password="xiao502"/>

            <sql:query dataSource="${db}" var="rs">
            select * from comment where bookName="${param.book}";

                <%--select * from comments where (select jj from book where comments.bookName = book.type)="${param.book}";--%>
            </sql:query>
            <sql:query dataSource="${db}" var="get">
            select * from book where type="${param.book}";
            </sql:query>
            <table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="1190" height="20">&nbsp;</td>
                </tr>
            </table>
            <table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="350" height="400" align="center" valign="middle" bgcolor="#FFFFFF"><img
                            src="img/${param.book}.jpg" width="350" height="400"/></td>
                    <td rowspan="2" valign="top" bgcolor="#FFFFFF">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td height="50"><p class="xiangqing">${param.book}</p></td>
                            </tr>
                            <tr>
                                <td width="650" height="150">
                                    <c:forEach var="row" items="${get.rows}">
                                        <li>
                                            <p><span style="color: red; font-size: 40px;">价格：${row.price}元</span></p>
                                            <form id="${row.name}form" action="UpGwc" method="post">
                                                <input type="hidden" name="book" value="${row.name}"/>
                                                <a class="jiajian" href="javascript:f('${row.name}num');"
                                                   style="background:#FF9900; margin-right:4px; padding:2px 5px 2px 5px">-</a>
                                                <input id="${row.name}num" name=num type="text" value="1"
                                                       style="width:15px">
                                                <a class="jiajian" href="javascript:j('${row.name}num');"
                                                   style="background:#FF9900;padding:2px 5px 2px 5px">+</a>
                                            </form>
                                        </li>
                                    </c:forEach>
                                </td>
                            </tr>

                            <c:forEach var="row" items="${get.rows}">
                                <tr>
                                    <td height="100" align="center" valign="middle" bgcolor="#F3F3F3">　${row.jj}</td>
                                </tr>

                                <tr>
                                    <td height="50" align="center" valign="middle">
                                        <form id="form1" name="form1" method="post" action="">
                                            <div align="left" style="float:right">
                                                <a class="gm" href="Iorder?book=${param.book}">立即购买</a>
                                            </div>
                                        </form>
                                        <div align="right">
                                            <a class="gm" href="javascript:ale('#${row.name}form');"
                                               style="background:#F90">加入购物车</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td height="40" align="center" valign="middle" bgcolor="#FFFFFF"><a href="#">关注 </a> <a
                            href="#">分享</a></td>
                </tr>
            </table>
            <table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="1190" height="20">&nbsp;</td>
                </tr>
            </table>
            <table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="100" height="50" bgcolor="#FFFFFF" class="xiangqing">商品评价</td>
                </tr>
                <tr>
                    <td height="100" bgcolor="#FFFFFF">
                        <table width="1190" border="0" cellspacing="0" cellpadding="0">
                            <c:forEach var="row" items="${get.rows}">
                                <tr>
                                    <td width="100" height="100"><img src="<c:url value="/img/haoping.jpg"/>"
                                                                      width="100" height="100"/></td>
                                    <td width="900" height="100">　${row.jj}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="100" height="50" bgcolor="#FFFFFF">
                        <table width="1190" border="0" cellpadding="0" cellspacing="0" class="pj">
                            <c:forEach var="row" items="${rs.rows}">
                                <tr>
                                    <td width="150" height="50" align="center" valign="middle">用户：${row.name}</td>
                                    <td height="50" align="left" valign="middle">评论：${row.comment}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
            <%@include file="footer.jsp" %>
</body>
</html>