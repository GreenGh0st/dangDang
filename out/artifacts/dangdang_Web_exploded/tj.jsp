<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*" %>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8" user="root"
                   password="xiao502"/>

<sql:query dataSource="${db}" var="rs">
    select newsContent from news where newsTitle='公告1';
</sql:query>
<sql:query dataSource="${db}" var="get">
    select newsContent from news where newsTitle='公告2';
</sql:query>
<sql:query dataSource="${db}" var="hq">
    select newsContent from news where newsTitle='公告3';
</sql:query>
<base href="<%=basePath%>">
<link href="css/cpu.css" rel="stylesheet" type="text/css">
<link href="css/sousuo.css" rel="stylesheet" type="text/css">
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="180" height="400" align="center" valign="middle">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="cat">图书、童书</td>
                </tr>
                <tr>
                    <td class="cat">电子书、网络文学</td>
                </tr>
                <tr>
                    <td class="cat">创意文具、当当拍卖</td>
                </tr>
                <tr>
                    <td class="cat">服饰、内衣</td>
                </tr>
                <tr>
                    <td class="cat">鞋靴、箱包</td>
                </tr>
                <tr>
                    <td class="cat">运动户外</td>
                </tr>
                <tr>
                    <td class="cat">手机数码</td>
                </tr>
                <tr>
                    <td class="cat">电脑办公</td>
                </tr>
                <tr>
                    <td class="cat">家用电器</td>
                </tr>
                <tr>
                    <td class="cat">EdgeTech礼品卡</td>
                </tr>
            </table>
        </td>
        <td width="760" height="400" align="left" valign="top">
            <div id="a1">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="760" height="400"><img class="img" src="<c:url value="/img/a.jpg"/>" width="760"
                                                          height="400"/></td>
                    </tr>
                </table>
            </div>
            <div id="a2">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="760" height="400"><img class="img" src="<c:url value="/img/b.jpg"/>" width="760"
                                                          height="400"/></td>
                    </tr>
                </table>
            </div>
            <div id="a3">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="760" height="400"><img class="img" src="<c:url value="/img/c.jpg"/>" width="760"
                                                          height="400"/></td>
                    </tr>
                </table>
            </div>
            <div id="a4">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="760" height="400"><img class="img" src="<c:url value="/img/d.jpg"/>" width="760"
                                                          height="400"/></td>
                    </tr>
                </table>
            </div>
            <div class="b" id="b1"
                 onmouseover="MM_showHideLayers('a1','','show','a2','','hide','a3','','hide','a4','','hide','b1','','show','b2','','show','b3','','show','b4','','show')">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="30" height="30" align="center" valign="middle">1</td>
                    </tr>
                </table>
            </div>
            <div class="b" id="b2"
                 onmouseover="MM_showHideLayers('form1','','show','textfield','','show','button','','show','a1','','hide','a2','','show','a3','','hide','a4','','hide','b1','','show','b2','','show','b3','','show','b4','','show')">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="30" height="30" align="center" valign="middle">2</td>
                    </tr>
                </table>
            </div>
            <div class="b" id="b3"
                 onmouseover="MM_showHideLayers('form1','','show','textfield','','show','button','','show','a1','','hide','a2','','hide','a3','','show','a4','','hide','b1','','show','b2','','show','b3','','show','b4','','show')">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="30" height="30" align="center" valign="middle">3</td>
                    </tr>
                </table>
            </div>
            <div class="b" id="b4"
                 onmouseover="MM_showHideLayers('form1','','show','textfield','','show','button','','show','a1','','hide','a2','','hide','a3','','hide','a4','','show','b1','','show','b2','','show','b3','','show','b4','','show')">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="30" height="30" align="center" valign="middle">4</td>
                    </tr>
                </table>
            </div>
        </td>
        <td width="200" height="400" align="center" valign="middle">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="200" height="40" align="center" valign="middle" bgcolor="#FFFFFF" class="gonggao">信息公告
                    </td>
                </tr>

                <tr>
                    <td height="160" align="center" valign="middle" bgcolor="#FFFFFF">
                    <c:forEach var="row" items="${rs.rows}">
                        <p class="cat">${row.newsContent}</p>
                    </c:forEach>
                    <c:forEach var="row" items="${get.rows}">
                        <p class="cat">${row.newsContent}</p>
                    </c:forEach>
                    <c:forEach var="row" items="${hq.rows}">
                        <p class="cat">${row.newsContent}</p></td>
                    </c:forEach>
                </tr>

                <tr>
                    <td width="200" height="40" align="center" valign="middle" bgcolor="#FFFFFF" class="gonggao">服务公告
                    </td>
                </tr>
                <tr>
                    <td><p class="cat">积分支付上线了直接当钱用</p>
                        <p class="cat">话费卡兑换EdgeTech礼品卡</p></td>
                </tr>

            </table>
        </td>
    </tr>
</table>
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="1190" height="50">&nbsp;<img src="<c:url value="/img/bar.webp"/>" width="1190" height="50"/></td>
    </tr>
</table>
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="166" height="200" align="center" valign="middle"><a href="javascript:add('list.jsp?type=处理器');"><img
                src="<c:url value="/img/intel.webp"/>" class="img"/></a></td>
        <td width="166" height="200" align="center" valign="middle"><a href="javascript:add('list.jsp?type=baimaozi');"><img
                src="<c:url value="/img/lx.webp"/>" class="img"/></a></td>
        <td width="166" height="200" align="center" valign="middle"><a href="javascript:add('list.jsp?type=baimaozi');"><img
                src="<c:url value="/img/dell.webp"/>" class="img"/></a></td>
        <td width="166" height="200" align="center" valign="middle"><a href="javascript:add('list.jsp?type=baimaozi');"><img
                src="<c:url value="/img/wd.webp"/>" class="img"/></a></td>
        <td width="166" height="200" align="center" valign="middle"><a href="javascript:add('list.jsp?type=baimaozi');"><img
                src="<c:url value="/img/lj.gif"/>" class="img"/></a></td>
        <td width="166" height="200" align="center" valign="middle"><a href="javascript:add('list.jsp?type=baimaozi');"><img
                src="<c:url value="/img/ry.webp"/>" class="img"/></a></td>
    </tr>
</table>
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="1190" height="20">&nbsp;</td>
    </tr>
</table>
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="333" height="350" align="left" valign="middle">
            <table width="97%" border="0" cellpadding="0" cellspacing="0" class="lingquanzhongxin">
                <tr>
                    <td width="322" height="40" align="center" valign="middle" class="gonggao">排行榜</td>
                </tr>
                <tr>
                    <td width="322" height="250" align="center" valign="middle">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="83" height="83" align="center" valign="middle"><img src="img/1.jpg"
                                                                                               width="83" height="95"/>
                                </td>
                                <td width="240" height="83"><img src="img/bmz.jpg" width="240" height="95"/></td>
                            </tr>
                            <tr>
                                <td width="83" height="83" align="center" valign="middle"><img src="img/2.jpg"
                                                                                               width="83" height="95"/>
                                </td>
                                <td width="240" height="83"><img src="img/ja.jpg" width="240" height="95"/></td>
                            </tr>
                            <tr>
                                <td width="83" height="83" align="center" valign="middle"><img src="img/3.jpg"
                                                                                               width="83" height="95"/>
                                </td>
                                <td width="240" height="83"><img src="img/py.jpg" width="240" height="95"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="322" height="60" align="center" valign="middle">专属你的购物指南</td>
                </tr>
            </table>
        </td>
        <td height="350" align="center" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="40" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF" class="gonggao">猜你喜欢
                    </td>
                </tr>
                <tr>
                    <td class="guess"><a href="javascript:add('list.jsp?type=baimaozi');"><img
                            src="<c:url value="/img/baimaozi.jpg"/>" width="166" height="130"/></a></td>
                    <td class="guess"><a href="javascript:add('list.jsp?type=跳绳');"><img
                            src="<c:url value="/img/shouhuan.jpg"/>" width="166" height="130"/></a></td>
                </tr>
                <tr>
                    <td width="166" height="30" align="center" valign="middle" bgcolor="#FFFFFF">白帽子</td>
                    <td width="166" height="30" align="center" valign="middle" bgcolor="#FFFFFF">小米手环三</td>
                </tr>
                <tr>
                    <td class="guess"><a href="javascript:add('list.jsp?type=呼啦圈');"><img
                            src="<c:url value="/img/xiaoai.jpg"/>" width="166" height="130"/></a></td>
                    <td class="guess"><a href="javascript:add('list.jsp?type=滚轮');"><img
                            src="<c:url value="/img/xiaomi8.jpg"/>" width="166" height="130"/></a></td>
                </tr>
                <tr>
                    <td align="center" valign="middle" bgcolor="#FFFFFF">小爱音响</td>
                    <td align="center" valign="middle" bgcolor="#FFFFFF">小米手机</td>
                </tr>
            </table>
        </td>
        <td width="333" height="350" align="right" valign="middle">
            <table width="97%" border="0" cellpadding="0" cellspacing="0" class="lingquanzhongxin">
                <tr>
                    <td height="40" align="center" valign="middle" class="gonggao">领券中心</td>
                </tr>
                <tr>
                    <td width="322" height="250" align="center" valign="middle"><img
                            src="<c:url value="/img/lingquan.jpg"/>" width="322" height="285"/></td>
                </tr>
                <tr>
                    <td height="60" align="center" valign="middle">先领券在下单有优惠哦！</td>
                </tr>
            </table>
        </td>
    </tr>
</table>