package servlet;

import Dao.UserCtrl;
import entity.MyAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserAddressServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int res;

	/**
		 * Constructor of the object.
		 */
	public UserAddressServlet() {
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

		String action=request.getParameter("action");

		UserCtrl uc = new UserCtrl();
		
		if(!action.equals("del")) {
			MyAddress ma = new MyAddress();
			
			String addType = request.getParameter("addrType");
			String username =request.getParameter("consigneeName");
			String address =request.getParameter("consigneeAddress");
			String zipCode =request.getParameter("zipCode");
			String phone = request.getParameter("phone");
			String useremail =request.getParameter("userEmail");
			String type = request.getParameter("type");
			String userYX = useremail + type;
			
			ma.setName(username);
			ma.setAddress(address);
			ma.setZipCode(zipCode);
			ma.setPhone(phone);
			ma.setEmail(userYX);
			ma.setAddralias(addType);
			
			//新建地址信息
			if (action.equals("add")) {
				System.out.println(action);
				int userID = Integer.parseInt(request.getParameter("userID"));
				ma.setUserId(userID);
				res = uc.addAddress(ma);
			}
			//编辑地址信息
			if (action.equals("edit")) {
				System.out.println(action);
				int addressId = Integer.parseInt(request.getParameter("addressId"));
				res = uc.updateAddress(ma,addressId);
				System.out.println(res);
			}
		}
		//删除地址
		if (action.equals("del")) {
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			uc.DelAddress(addressId);
		}
		//设置为默认地址
		if (action.equals("status")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			ArrayList<Integer> addr = uc.getAddressId(userId);
			for (int i = 0; i < addr.size(); i++) {
	            if(addr.get(i)==addressId)
	            	res = uc.updateStatus(addr.get(i),1);
	            else
	            	res = uc.updateStatus(addr.get(i),0);
	        }			
		}
		//订单核对页面选择地址
		if (action.equals("selAddre")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			ArrayList<Integer> addr = uc.getAddressId(userId);
			for (int i = 0; i < addr.size(); i++) {
	            if(addr.get(i)==addressId)
	            	res = uc.updateStatus(addr.get(i),1);
	            else
	            	res = uc.updateStatus(addr.get(i),0);
	        }			
		}
		if(res <= 0)
			out.print("<script>alert('操作失败！');window.location.href='../shipAddr.jsp';</script>");
		response.sendRedirect("../shipAddr.jsp");
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
