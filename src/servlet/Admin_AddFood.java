package servlet;

import Dao.FoodInfoDao;
import entity.FoodInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Admin_AddFood extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Admin_AddFood() {
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
		FoodInfo foods = new FoodInfo();
		FoodInfoDao fc = new FoodInfoDao();
		String foodName = request.getParameter("foodName");
		String remark = request.getParameter("remark");
		String foodAddr = request.getParameter("foodAddr");
		double foodPrice = Double.parseDouble(request.getParameter("foodPrice"));
		String description = request.getParameter("description");
		String foodImage = request.getParameter("foodImage");
		int foodCount =Integer.parseUnsignedInt(request.getParameter("foodCount"));
		foods.setFoodName(foodName);
		foods.setRemark(remark);
		foods.setFoodAddr(foodAddr);
		foods.setFoodPrice(foodPrice);
		foods.setDescription(description);
		foods.setFoodImage(foodImage);
		foods.setFoodCount(foodCount);
		int res =fc.addFood(foods);
		if(res>0){
			out.print("<script>alert('添加成功！');window.location.href='../admin/foods/foods_Manage.jsp';</script>");
		}else{
			out.print("<script>alert('添加失败！');window.history.back();</script>");
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
