package servlet;

import Dao.FoodInfoDao;
import entity.FoodInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class DetailsServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public DetailsServlet() {
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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		int orderId = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		if(request.getParameter("orderId")!=null) {
			orderId = Integer.parseInt(request.getParameter("orderId"));
		}
		FoodInfoDao fc = new FoodInfoDao();
		FoodInfo fi = fc.getFoodInfoById(id);

		request.getSession().setAttribute("orderId", orderId);
		
		
		
		if(request.getParameter("flag")!=null) {
			int flag = Integer.parseInt(request.getParameter("flag"));
			if(flag == 1)
				request.getSession().setAttribute("flag", flag);
			else
				request.getSession().removeAttribute("flag");
		}
		
		if(fi!=null){
			HttpSession session =request.getSession();
			session.setAttribute("fi",fi);
			response.sendRedirect("../details.jsp");
		}else{
			out.print("<script>alert('³öÏÖ´íÎó£¡');window.location.href='../shop.jsp';</script>");
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
