<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="css/sousuo.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
    body {
        background-color: #F0F3EF;
    }

    #a1 {
        position: absolute;

        z-index: 2;
        background-color: #ffffff;
    }

    #a2 {
        position: absolute;

        z-index: 3;
        background-color: #ffffff;
    }

    #a3 {
        position: absolute;

        z-index: 4;
        background-color: #ffffff;
    }

    #a4 {
        position: absolute;

        z-index: 5;
        background-color: #ffffff;
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
        color: #000;

    }

    a:visited {
        text-decoration: none;
        color: #000;
    }

    a:hover {
        text-decoration: none;


    }

    a:active {
        text-decoration: none;
    }

    a.searchB {
        width: 100px;
        height: 40px;
        line-height: 38px;
        background: #ff2832;
        border-radius: 7px;
        display: inline-block;
        color: #fff;
        text-align: center;
        font-size: 15px;
        margin-bottom: 10px;
        position: relative;
        bottom: 6px;
    }

    a.searchB:hover {
        background-color: #4d4d4d;
        color: #b3d7ff;
        cursor: pointer;
    }
</style>

<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    function MM_showHideLayers() { //v9.0
        var i, p, v, obj, args = MM_showHideLayers.arguments;
        for (i = 0; i < (args.length - 2); i += 3)
            with (document) if (getElementById && ((obj = getElementById(args[i])) != null)) {
                v = args[i + 2];
                if (obj.style) {
                    obj = obj.style;
                    v = (v == 'show') ? 'visible' : (v == 'hide') ? 'hidden' : v;
                }
                obj.visibility = v;
            }
    }

    add = function (url) {
        $.get(url, function (data, status) {
            $("#contents").html(data);
        });
    }
</script>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="toubu">
    <tr>
        <td height="30" align="center" bgcolor="#CCCCCC">
            <table width="1190" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="100" height="30" align="center" valign="middle"><img src="<c:url value="/img/定位图标.png"/>"
                                                                                    width="30"
                                                                                    height="30"/>广东
                    </td>
                    <td height="30" align="center" valign="middle">&nbsp;</td>
                    <td width="50" height="30" align="center" valign="middle" class="gwc"><a href="index.jsp">首页</a>
                    </td>
                    <td width="50" align="center" valign="middle" class="gwc"><a href="gwc.jsp">购物车</a></td>
                    <td width="100" height="30" align="center" valign="middle" class="gwc"><a
                            href="orderList.jsp">我的订单</a></td>
                    <td width="100" height="30" align="center" valign="middle" class="gwc"><a href="userInfo.jsp">用户中心</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="150" height="150" align="center" valign="middle"><a href="index.jsp" style="color:#1a2bea"><img
                src="<c:url value="/img/logo.png"/>" width="150" height="150"/></a>
        </td>
        <td height="150" align="center" valign="middle">
            <form action="list.jsp" method="post" id="searchForm">
                <label for="textfield"></label>
                <input name="search" type="text" class="sousuo" id="textfield"/>

                <a class="searchB"
                   href="javascript:$.post('list.jsp',$('#searchForm').serialize(),function(data,status){$('#contents').html(data);});">查询</a>
            </form>
        </td>
        <td width="200" height="150" align="center" valign="middle">Welcome to EdgeTech&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
                href="login.jsp" class="denglu" style="color:#1a2bea">
            <%
                String user = "";
                try {
                    user = (String) session.getAttribute("user");
                } catch (Exception e) {
                }

                if (user == null || "".equals(user)) {
                    out.println("登录");
                } else {
                    out.println("用户：" + user);
                }
                session.setAttribute("sessionName", user);

            %>
        </a><a href="register.jsp" class="denglu" style="color:#1a2bea">
            <%
                if (user == null || "".equals(user)) {
                    out.println("注册");
                }

            %>
        </a></td>

    </tr>
</table>
<table width="1190" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td class="wenxue"><a href="motherborder.html">
            <div><font color="#f0f8ff">主板</font></div>
        </a></td>
        <td class="daohang"><a href="CPU.html">
            <div>处理器</div>
        </a></td>
        <td class="daohang"><a href="javascript:add('list.jsp?type=显卡');">
            <div>显卡</div>
        </a></td>
        <td class="daohang"><a href="javascript:add('list.jsp?type=硬盘');">
            <div>硬盘</div>
        </a></td>
        <td class="daohang"><a href="javascript:add('list.jsp?type=内存');">
            <div>内存</div>
        </a></td>
        <td class="daohang"><a href="javascript:add('list.jsp?type=电源');">
            <div>电源</div>
        </a></td>
        <td class="daohang"><a href="javascript:add('list.jsp?type=外设');">
            <div>外设</div>
        </a></td>
    </tr>
</table>

<table width="100%" height="5" border="0" cellpadding="0" cellspacing="0" class="zhongxian">
    <tr>
        <td bgcolor="#FF3300"></td>
    </tr>
</table>