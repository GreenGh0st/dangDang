package servlet;

import Dao.CommentInfoDao;
import entity.Admin_UserInfo;
import entity.CommentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Admin_ReplyComment extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Admin_ReplyComment() {
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
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date date = new Date();
		//String s = simpleDateFormat.format(date);
		//System.out.println(s);
		
		CommentInfoDao ac = new CommentInfoDao();
		CommentInfo comment= new CommentInfo();
		
		/*
		 * Admin_UserInfo au = (Admin_UserInfo)session.getAttribute("au"); String name =
		 * au.getAdmin_Name();
		 */
		
		  Admin_UserInfo au = (Admin_UserInfo) request.getSession().getAttribute("au");
		  String admin_name=au.getAdmin_Name();
		 
		int commentId =(int)request.getSession().getAttribute("commentId");
	 	
		String admin_Reply = request.getParameter("reply");
		comment.setCom_id(commentId);
		comment.setAdmin_name(admin_name);
		comment.setAdmin_Reply(admin_Reply);
		
		
		int res =ac.ReplyComment(comment);
		if(res>0){
			out.print("<script>alert('管理员回复成功！');window.location.href='../admin/comment/comment_Manage.jsp';</script>");
		}else{
			out.print("<script>alert('回复失败！');window.history.back();</script>");
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
