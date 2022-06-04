package servlet;

import Dao.FoodInfoDao;
import Dao.SearchDao;
import entity.FoodInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserSearchServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserSearchServlet() {
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
		ArrayList<FoodInfo> arrfood = null;
		SearchDao search = new SearchDao();
		
		String action = request.getParameter("action");
		System.out.println(action);

		if(action.equals("key")){
			int flag = 2;
			request.getSession().setAttribute("flag", flag);
			String searchKey = request.getParameter("searchKey");
			arrfood = search.showFoodsByKey(searchKey);
			request.getSession().setAttribute("Arrfood",arrfood); 
		}
		if(action.equals("sort")){
			String sortKey = request.getParameter("sortKey");
			int sortId;
			sortId = search.showSotrID(sortKey);
			arrfood = search.showFoodsBySort(sortId);
			request.getSession().setAttribute( "Arrfood",arrfood); 
		}
		if(action.equals("addr")){
			String addrKey = request.getParameter("addrKey");
			addrKey = addrKey+"ÊÐ";
			arrfood = search.showFoodsByAddr(addrKey);
			request.getSession().setAttribute( "Arrfood",arrfood); 
		}
		if(action.equals("comp")){
			FoodInfoDao fid = new FoodInfoDao();
			arrfood = fid.showFoods();
			request.getSession().setAttribute( "Arrfood",arrfood); 
		}
		if(action.equals("priceOrder")){
			int flag =Integer.parseInt(request.getParameter("flag"));
			System.out.println("flag "+flag);
			request.getSession().setAttribute("flag",flag);
			arrfood = search.showFoodsByOrder(flag);
			request.getSession().setAttribute( "Arrfood",arrfood); 
		}
		if(action.equals("price")){
			int pricedown =Integer.parseInt(request.getParameter("pricedown"));
			int priceup =Integer.parseInt(request.getParameter("priceup"));
			System.out.println("pricedown "+pricedown);
			System.out.println("priceup "+priceup);
			arrfood = search.showFoodsByPrice(pricedown,priceup);
			request.getSession().setAttribute("Arrfood",arrfood); 
		}
		response.sendRedirect("../search.jsp");
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
