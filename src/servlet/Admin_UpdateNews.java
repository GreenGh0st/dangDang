package servlet;

import Dao.NewInfoDao;
import entity.Admin_NewInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Admin_UpdateNews extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Admin_UpdateNews() {
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String s = simpleDateFormat.format(date);
		System.out.println(s);
		NewInfoDao ac = new NewInfoDao();
		Admin_NewInfo news = new Admin_NewInfo();
		int newsId =(int)request.getSession().getAttribute("newsid");
		String newsTitle =request.getParameter("newsTitle");
		String newsContent =request.getParameter("newsContent");
		news.setNewsId(newsId);
		news.setNewsTitle(newsTitle);
		news.setNewsContent(newsContent);
		news.setNewsDate(s);
		int res =ac.updateNews(news);
		if(res>0){
			out.print("<script>alert('修改成功！');window.location.href='../admin/news/news_Manage.jsp';</script>");
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
