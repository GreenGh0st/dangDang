package servlet;

import Dao.OrderCtrl;
import entity.OrderInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OrderOperation extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public OrderOperation() {
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
//		PrintWriter out = response.getWriter();
		OrderCtrl order = new OrderCtrl();
		ArrayList<OrderInfo> allOrder = null;
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if(action.equals("orderNumber")){
			String orderNumber = request.getParameter("orderNumber");
			allOrder = order.showOrderNumber(orderNumber);
		}
		if(action.equals("orderStatus")){
			String orderNumber = request.getParameter("orderNumber");
			allOrder = order.showOrderStatus(action);
		}
		if(action.equals("allOrder")){
			allOrder = order.showOrder();
		}
		request.getSession().setAttribute( "allOrder",allOrder); 
		response.sendRedirect("../order.jsp");
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
