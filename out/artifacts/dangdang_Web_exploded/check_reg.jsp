<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    String url = "jdbc:mysql://localhost:3306/book?useSSL=false";
    String username = "root";
    String password = "xiao502";
    try {
        conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    request.setCharacterEncoding("utf-8");//设置编码方式，防止中文乱码
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");
    String realname = request.getParameter("realname");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String tel = request.getParameter("tel");
    String address = request.getParameter("address");
    String sql = "INSERT into user VALUES(default,?,?,?,?,?,?,?,default)";
    ps = conn.prepareStatement(sql);
    ps.setString(1, name);
    ps.setString(2, pwd);
    ps.setString(3, realname);
    ps.setString(4, gender);
    ps.setString(5, email);
    ps.setString(6, tel);
    ps.setString(7, address);
    int row = ps.executeUpdate();
    if (row > 0) {
        response.sendRedirect("./login.jsp");//重定向到登陆页面
    }
%>