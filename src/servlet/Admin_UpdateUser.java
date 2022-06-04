package servlet;

import Dao.AdminUserCtrl;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Admin_UpdateUser extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Admin_UpdateUser() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doDelete method of the servlet. <br>
		 *
		 * This method is called when a HTTP delete request is received.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
        AdminUserCtrl ac = new AdminUserCtrl();
        UserInfo user = new UserInfo();
        int user_id =(int)request.getSession().getAttribute("userid");
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("sex");
		String userEmail = request.getParameter("userEmail");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		int userState = Integer.parseInt(request.getParameter("userState"));
		user.setUserId(user_id);
		user.setUserName(userName);
		user.setUserpwd(pwd);
		user.setName(name);
		user.setUserSex(gender);
		user.setUserEmail(userEmail);
        user.setUserTel(tel);
        user.setUserAddr(address);
        user.setUserZt(userState);
        System.out.print(name);
		System.out.print(gender);
		System.out.print(address);
		int res =ac.updateUser(user);
		if(res>0){
			out.print("<script>alert('修改成功！');window.location.href='../admin/user/user_Manage.jsp';</script>");
			  
			}else{ out.print("<script>alert('修改失败！');window.history.back();</script>");
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
