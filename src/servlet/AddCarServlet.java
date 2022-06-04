package servlet;

import Dao.ShoppingCarDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddCarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public AddCarServlet() {
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

		request.setCharacterEncoding("UTF-8");
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
		
		//获取action
		String action=request.getParameter("action");
		ShoppingCarDao shoppingCar=new ShoppingCarDao();
		//添加购物车
		if (action.equals("add")) {
			int id =Integer.parseInt(request.getParameter("foodID"));
			shoppingCar.addCard(id);
		}
		//清空购物车
		if (action.equals("clear")) {
			shoppingCar.clearAll();
		}
		//数量加一
		if(action.equals("up")) {
			int id =Integer.parseInt(request.getParameter("foodID"));
			shoppingCar.UpNum(id);
		}
		//数量减一
		if(action.equals("down")) {
			int id =Integer.parseInt(request.getParameter("foodID"));
			shoppingCar.DownNum(id);
		}
		//部分删除
		if(action.equals("partDel")) {
			String[] item = request.getParameterValues("chkItem");
			String delStr = "";
			System.out.println("length"+item.length);
			for(int i=0;i<item.length;i++) {
				delStr=item[i];
				int id =Integer.parseInt(delStr);
				shoppingCar.Delete(id);
			}
		}
		

		//从主页面添加
		if (action.equals("add1")) {
			int id =Integer.parseInt(request.getParameter("foodID"));
			shoppingCar.addCard(id);
			ShoppingCarDao scd = new ShoppingCarDao();
			int shopNumber = scd.showFoodCarNumber();
			out.print(shopNumber);
			out.flush();
			out.close();  //这里就是关键
			return;
		}
		//从主页面删除
		if (action.equals("del")) {
			int id =Integer.parseInt(request.getParameter("foodID"));
			shoppingCar.Delete(id);
			ShoppingCarDao scd = new ShoppingCarDao();
			int shopNumber = scd.showFoodCarNumber();
			out.print(shopNumber);
			out.flush();
			out.close();  //这里就是关键
			return;
		}
		 response.sendRedirect("../shopCar.jsp");
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
