package servlet;

import Dao.UserCtrl;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public UpdateUserInfo() {
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		UserInfo user = new UserInfo();
		UserCtrl uc = new UserCtrl();
		
		String userId = request.getParameter("userId");
		String username =request.getParameter("userName");
		String userpwd =request.getParameter("userPwd");
		String userxm =request.getParameter("name");
		String usersex =request.getParameter("sex");
		String usertel =request.getParameter("userTel");
		String useraddr =request.getParameter("userAddr");
		String useremail =request.getParameter("userEmail");
		String mail = request.getParameter("mail");
		String userYX = useremail + mail;

		user.setUserName(username);
		user.setUserpwd(userpwd);		
		user.setName(userxm);			
		user.setUserSex(usersex);		
		user.setUserTel(usertel);		
		user.setUserAddr(useraddr);
		user.setUserEmail(userYX);
		
		int res =uc.updateUser(user,userId);
		if(res>0){
			UserCtrl ac = new UserCtrl();
			UserInfo ui = ac.login(username, userpwd);
			if(ui!=null){
				HttpSession session =request.getSession();
				session.setAttribute("ui",ui);
				response.sendRedirect("../userInfo.jsp");
			}
			out.print("<script>alert('修改成功！');</script>");
		}else{
			out.print("<script>alert('修改失败！');window.history.back();</script>");
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
