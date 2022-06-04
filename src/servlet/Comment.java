package servlet;

import Dao.CommentInfoDao;
import Dao.OrderCtrl;
import entity.CommentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Comment() {
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

		doPost(request, response);
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
		
		CommentInfo ci = new CommentInfo();
		CommentInfoDao cid= new CommentInfoDao();

		String DateTime;
		int foodID =Integer.parseInt(request.getParameter("foodID"));
		String userName =request.getParameter("userName");
		String esContent =request.getParameter("esContent");
		String quality =request.getParameter("quality");
		String delivery =request.getParameter("delivery");
		String serve =request.getParameter("serve");
		int orderId = (int)request.getSession().getAttribute("orderId");
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateTime = sdf.format(dt);

		System.out.println("foodID："+foodID);
		System.out.println("userName："+userName);
		System.out.println("esContent："+esContent);
		System.out.println("商品质量："+quality);
		System.out.println("配送服务："+delivery);
		System.out.println("卖家服务："+serve);
		System.out.println("评价事件："+DateTime);
		
		ci.setFoodID(foodID);
		ci.setOrderID(orderId);
		ci.setUserName(userName);
		ci.setCom_context(esContent);
		ci.setFoodQuality(quality);
		ci.setCom_delivery(delivery);
		ci.setCom_serve(serve);
		ci.setCom_data(DateTime);
		
		int res = cid.addComment(ci);
		
		request.getSession().setAttribute("flag", 1); 

		OrderCtrl oc = new OrderCtrl();
		
		if(res>0){
			oc.updateCommZt(orderId);
			out.print("<script>alert('评论成功！');window.location.href='../details.jsp';</script>");
		}else{
			out.print("<script>alert('评论失败！');window.history.back();</script>");
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
