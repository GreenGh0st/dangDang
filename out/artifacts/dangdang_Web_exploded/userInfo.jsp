<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Dao.DBHelperDao" %>

<%
    UserInfo ui = (UserInfo)session.getAttribute("ui");
    if(ui==null){
        response.sendRedirect("login.jsp");
        return ;
    }
%>



<html>
<head>
    <title>Title</title>
</head>
<body style="background: #ffffff">
<%@include file="header.jsp" %>

<div style="text-align:center;" class="ms-body">
    <div class="title1">个人信息</div>
    <div class="form-list">
        <form action="servlet/UpdateUserInfo" method="post">
            <div class="reg-form">
                <div class="user">
                    用户编号：<input type="number" name="userId" readonly="readonly" value="<%=ui.getUserId()%>"/>
                </div>
                <div class="status">
                    <%if(ui.getUserZt()==0) {%>
                    账号状态：<span style="color: #00C65D;">正常</span>
                    <%}else{ %>
                    账号状态：<span style="color: red;">冻结中</span>
                    <%} %>
                </div>
                <!--姓名-->
                <div class="item name">
                    <label for="name"><span>*</span>真实姓名:</label>
                    <input type="text" name="name" class="compellation infoinPut" placeholder="请输入您的姓名" value="<%=ui.getName()%>">
                    <%--<span class="title">姓名不能为空！</span>--%>
                </div>
                <!--性别-->
                <div class="item sex">
                    <label for="userSex"><span>*</span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
                    <div class="sexDiv">
                        <%
                            if(ui.getUserSex().charAt(0)=='男'){
                        %>
                        男<input type="radio" name="sex" class="selectSex" value="男" checked="true">
                        女<input type="radio" name="sex" class="selectSex" value="女">
                        <%}else{ %>
                        男<input type="radio" name="sex" class="selectSex" value="男">
                        女<input type="radio" name="sex" class="selectSex" value="女" checked="true">
                        <%} %>
                    </div>
                    <%--<span class="title">选择你的性别！</span>--%>
                </div>
                <!--用户名-->
                <div class="item userName">
                    <label for="userName"><span>*</span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                    <input type="text" name="userName" class="accounts infoinPut" placeholder="账号长度6-12，英文数字组合" minlength="6" maxlength="12" value="<%=ui.getUserName() %>">
                    <%--<span class="title">账号不能为空！</span>--%>
                </div>
                <!--密码-->
                <div class="item password">
                    <label for="userPwd"><span>*</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                    <input type="password" name="userPwd" class="userPwd infoinPut" placeholder="密码长度6-12个字符" minlength="6" maxlength="12" value="<%=ui.getUserPwd() %>">
                    <%--<span class="title">密码不能为空！</span>--%>
                </div>
                <!--确认密码-->
                <%--<div class="item password1">
                    <label for="userPwd1"><span>*</span>确认密码:</label>
                    <input type="password" name="userPwd1" class="userPwd1 infoinPut" placeholder="请重复输入密码" maxlength="12">
                    <span class="title">请确认密码！</span>
                </div>--%>
                <!--电话-->
                <div class="item tel">
                    <label for="userTel"><span>*</span>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label>
                    <input type="number" name="userTel" class="userTel infoinPut" placeholder="请输入您的电话" maxlength="11" value="<%=ui.getUserTel() %>">
                    <%--<span class="title">电话不能为空！</span>--%>
                </div>
                <!--地址-->
                <div class="item address">
                    <label for="userAddr"><span>*</span>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</label>
                    <input type="text" name="userAddr" class="userAddr infoinPut" placeholder="请输入您的地址" value="<%=ui.getUserAddr() %>">
                    <%--<span class="title">地址不能为空！</span>--%>
                </div>
                <!--邮箱-->
                <div class="item address">
                    <label for="userEmail"><span>*</span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
                    <input type="text" name="userEmail" class="userEmail infoinPut" placeholder="请输入您的邮箱" value="<%=ui.getUserEmail() %>">
                    <%--<span class="title">邮箱不能为空！</span>--%>
                </div>
            </div>
        </form>
    </div>
    <td ><a href="index.jsp">返回</a></td>
</div>
<%--<div align="center">
    <div style="height: 15%;padding-top: 20px;">
        <h1 style="height: 10%">用 户 详 情</h1>
    </div>
    <!-- 展示用户信息  -->
    <div>
        <table>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>密码</th>
                <th>年龄</th>
                <th>性别</th>
                <th>爱好</th>
                <th>手机号</th>
                <th>头像</th>
                <th>操作</th>
            </tr>
            <%
                // 创建dbHelper工具类对象
                DBHelperDao db = new DBHelperDao();
                // 获取数据库查询结果集
                ResultSet resultSet = db.selectAll();
                // 遍历结果集
                while (resultSet.next()){
            %>
            <tr>
                <td><%=resultSet.getInt(1)%></td> <!-- 获取id -->
                <td><%=resultSet.getString(2)%></td> <!-- 获取username -->
                <td><%=resultSet.getString(3)%></td> <!-- 获取pwd -->
                <td><%=resultSet.getString(4)%></td> <!-- 获取age -->
                <td><%=resultSet.getString(5)%></td> <!-- 获取sex -->
                <td><%=resultSet.getString(6)%></td> <!-- 获取hobby -->
                <td><%=resultSet.getString(7)%></td> <!-- 获取phone -->
                <td><%=resultSet.getString(8)%></td>
                <td>
                    &lt;%&ndash;问号右边表示要传递的内容&ndash;%&gt;
                    <a href="#" style="color: red">删除</a>
                    |
                    <a href="#" style="color:blue">修改</a>
                    |
                    <a href="#" style="color:blue">修改头像</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>--%>
</body>


</html>
