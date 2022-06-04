package Dao;

import entity.OrderInfo;
import entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * 订单操作方法类
 * @author Administrator
 *
 */

public class OrderCtrl {

	/**
	 * 修改评论状态
	 * @param orderId
	 * @return
	 */
	public int updateCommZt(int orderId){
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update orders set comment = 1 where orderId=" + orderId;
			try {
				stmt =conn.prepareStatement(sql);	
				res = stmt.executeUpdate();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}		
		return res;		
	}
	/*==订单列表数据分页==*/

	/**
	 * 根据订单号查询用户订单信息
	 * @param orderId
	 * @return
	 */
	public OrderInfo selOrder(int orderId){
		OrderInfo order = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from orders left join user on orders.userID = user.user_id where orderId=" + orderId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){				
				order = new OrderInfo();	
				order.setOrderId(rs.getInt("orderID"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setUserID(rs.getInt("userID"));
				order.setShipStatus(rs.getInt("shipStatus"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setAddrID(rs.getInt("addressID"));
				order.setFoodID(rs.getInt("foodID"));
				order.setFoodImage(rs.getString("foodImage"));
				order.setFoodName(rs.getString("foodsName"));
				order.setFoodPrice(rs.getDouble("foodsPrice"));
				order.setFoodCount(rs.getInt("foodsCount"));
				order.setConsignee(rs.getString("consignee"));
				order.setOrderStatus(rs.getString("orderStatus"));
				order.setComment(rs.getInt("comment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt, rs);
		}		
		return order;
	}
	/**
	 * 根据订单ID修改发货状态
	 * @param orderId
	 * @param orderZt
	 * @return
	 */
	public int updateOrder(int orderId,int shipStatus){
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update orders set shipStatus=?" +" where orderID=?";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setInt(1, shipStatus);
				stmt.setInt(2, orderId);
				res = stmt.executeUpdate();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}		
		return res;		
	}
	/**
	 * 生成订单方法
	 * @param order
	 * @return
	 */
	public int addOrder(OrderInfo order){
		int res =0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="insert into orders values(default,?,?,?,?,?,?,?,?,?,?,?,?,default)";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1,order.getOrderNumber());
				stmt.setInt(2,order.getUserID());
				stmt.setInt(3,order.getShipStatus());
				stmt.setInt(4,order.getAddrID());
				stmt.setString(5,order.getOrderDate());
				stmt.setInt(6,order.getFoodID());
				stmt.setString(7,order.getFoodImage());
				stmt.setString(8,order.getFoodName());
				stmt.setDouble(9,order.getFoodPrice());
				stmt.setInt(10,order.getFoodCount());
				stmt.setString(11,order.getConsignee());
				stmt.setString(12,order.getOrderStatus());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}
	/**
	 * 查询所有订单
	 * @param
	 * @return OrderInfo
	 */
	public ArrayList<OrderInfo> showOrder() {
		ArrayList<OrderInfo> allorder = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from order";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allorder==null){
					allorder=new ArrayList<OrderInfo>();					
				}
				OrderInfo orders = new OrderInfo();
				orders.setOrderId(rs.getInt("orderID"));
				orders.setOrderNumber(rs.getString("orderNumber"));
				orders.setUserID(rs.getInt("userID"));
				orders.setShipStatus(rs.getInt("shipStatus"));
				orders.setAddrID(rs.getInt("addressID"));
				orders.setOrderDate(rs.getString("orderDate"));
				orders.setFoodID(rs.getInt("foodID"));
				orders.setFoodImage(rs.getString("foodImage"));
				orders.setFoodName(rs.getString("foodsName"));
				orders.setFoodPrice(rs.getDouble("foodsPrice"));
				orders.setFoodCount(rs.getInt("foodsCount"));
				orders.setConsignee(rs.getString("consignee"));
				orders.setOrderStatus(rs.getString("orderStatus"));
				orders.setComment(rs.getInt("comment"));
				allorder.add(orders);
				}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,stmt,rs);
		}	  
		return allorder;			
	}
	/**
	 * 根据订单号查询订单
	 * @param
	 * @return OrderInfo
	 */
	public ArrayList<OrderInfo> showOrderNumber(String orderNumber) {
		ArrayList<OrderInfo> allorder = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from orders where orderNumber =" + orderNumber;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allorder==null){
					allorder=new ArrayList<OrderInfo>();					
				}
				OrderInfo orders = new OrderInfo();
				orders.setOrderId(rs.getInt("orderID"));
				orders.setOrderNumber(rs.getString("orderNumber"));
				orders.setUserID(rs.getInt("userID"));	
				orders.setShipStatus(rs.getInt("shipStatus"));	
				orders.setAddrID(rs.getInt("addressID"));
				orders.setOrderDate(rs.getString("orderDate"));
				orders.setFoodID(rs.getInt("foodID"));
				orders.setFoodImage(rs.getString("foodImage"));
				orders.setFoodName(rs.getString("foodsName"));
				orders.setFoodPrice(rs.getDouble("foodsPrice"));
				orders.setFoodCount(rs.getInt("foodsCount"));
				orders.setConsignee(rs.getString("consignee"));
				orders.setOrderStatus(rs.getString("orderStatus"));
				orders.setComment(rs.getInt("comment"));
				allorder.add(orders);
				}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,stmt,rs);
		}	  
		return allorder;			
	}
	/**
	 * 根据订单状态查询订单
	 * @param
	 * @return OrderInfo
	 */
	public ArrayList<OrderInfo> showOrderStatus(String orderStatus) {
		ArrayList<OrderInfo> allorder = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from orders where orderStatus =" + orderStatus;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allorder==null){
					allorder=new ArrayList<OrderInfo>();					
				}
				OrderInfo orders = new OrderInfo();
				orders.setOrderId(rs.getInt("orderID"));
				orders.setOrderNumber(rs.getString("orderNumber"));
				orders.setUserID(rs.getInt("userID"));	
				orders.setShipStatus(rs.getInt("shipStatus"));	
				orders.setAddrID(rs.getInt("addressID"));
				orders.setOrderDate(rs.getString("orderDate"));
				orders.setFoodID(rs.getInt("foodID"));
				orders.setFoodImage(rs.getString("foodImage"));
				orders.setFoodName(rs.getString("foodsName"));
				orders.setFoodPrice(rs.getDouble("foodsPrice"));
				orders.setFoodCount(rs.getInt("foodsCount"));
				orders.setConsignee(rs.getString("consignee"));
				orders.setOrderStatus(rs.getString("orderStatus"));
				orders.setComment(rs.getInt("comment"));
				allorder.add(orders);
				}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,stmt,rs);
		}	  
		return allorder;			
	}
	/**
	 *根据ID删除订单
	 * @return
	 */
	public int DeleteOrder(int orderID){
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		int rs = 0;
		String sql = "delete from `order` where orderID =" + orderID;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeUpdate(sql);
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn, stmt, null);
		}
		return rs;
	}

}
