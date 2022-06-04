import Dao.UserCtrl;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Log
 */
@WebServlet("/AdminLog")
public class AdminLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLog() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        PreparedStatement p = null;
        HttpSession session = request.getSession();
        String list = null;
        String userName = request.getParameter("txt");
        String userPass = request.getParameter("passwd");
        String sql = "select * from admin where loginName=? and loginPass=?;";
        filter.Filte f = new filter.Filte();
        UserCtrl ac = new UserCtrl();
        UserInfo ui = ac.login(userName, userPass);
        try {
            p = f.getPre(sql);
        } catch (java.sql.SQLException e) {
            out.print("connect error!");
        }
        try {
            p.setString(1, userName);
            p.setString(2, userPass);
        } catch (SQLException e) {
            out.print("connect error!");
        }

        try {
            list = f.getR(p, 1);
        } catch (SQLException e) {
            out.println("<script>alert('用户名或密码错误！');window.location.href='adminLogin.jsp';</script>");
        }

        if (list == null || list.equals("")) {
            out.println("<script>alert('用户名或密码错误！');window.location.href='adminLogin.jsp';</script>");
        } else {
            session.setAttribute("user", userName);
            response.sendRedirect("adminIndex.jsp");
        }
    }

}
