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
    String type = request.getParameter("type");
    String jj = request.getParameter("jj");
    String price = request.getParameter("price");
    int sy = Integer.parseInt(request.getParameter("foodID"));
    String sql = "update book set name=?,type=?,price=?,jj=?" + " where sy=?";
    ps = conn.prepareStatement(sql);
    ps.setString(1, name);
    ps.setString(2, type);
    ps.setString(3, price);
    ps.setString(4, jj);
    ps.setInt(5,sy);
    int row = ps.executeUpdate();
    if (row > 0) {
        out.print("<script>alert('修改成功！');window.location.href='foods_Manage.jsp';</script>");
    }else{
        out.print("<script>alert('修改失败！');window.history.back();</script>");
    }

%>
