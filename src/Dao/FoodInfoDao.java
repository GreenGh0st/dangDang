package Dao;


import entity.FoodInfo;
import entity.FoodInfoCar;
import entity.FoodType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;


/**
 * 商品操作类
 * @author Administrator
 *
 */
public class FoodInfoDao {

    /**
	 * 添加商品方法
	 * @param foods
	 * @return
	 */
	public int addFood(FoodInfo foods) {
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement pst= null;
		String sql = "insert into foodinfo values (default,?,?,?,?,?,?,?,?)";
		  try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, foods.getFoodName());
			pst.setString(2, foods.getRemark());
			pst.setString(3, foods.getFoodAddr());
			pst.setDouble(4, foods.getFoodPrice());
			pst.setString(5, foods.getDescription());
			pst.setString(6, foods.getFoodImage());
			pst.setInt(7, foods.getFoodCount());
			pst.setInt(8,foods.getSortID());
			res = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,pst,null);
		}	  
		return res;		
	}
	
	/*==商品列表数据分页显示==*/
	/**
	 * 根据当前页数和每页显示的行数来查询相应的结果
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 * @param pageNow
	 *            当前的页数
	 * @return
	 */
	public ArrayList<FoodInfo> getFoodForPage(int pageSize,int pageNow){
		ArrayList<FoodInfo> afoods=null;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from foodinfo limit "+pageSize*(pageNow-1)+","+pageSize+"";
			
		try {
			pst = conn.prepareStatement(sql);
			rs= pst.executeQuery();
			while(rs.next()) {
			   if(afoods==null) {
				   afoods=new ArrayList<FoodInfo>();
			   }
			   FoodInfo foods = new FoodInfo();
			   foods.setFoodID(rs.getInt("foodID"));
			   foods.setFoodName(rs.getString("foodName"));
			   foods.setSortID(rs.getInt("sortId"));	
			   foods.setRemark(rs.getString("remark"));
			   foods.setFoodAddr(rs.getString("foodAddr"));
			   foods.setFoodPrice(rs.getDouble("foodPrice"));
			   foods.setDescription(rs.getString("description"));
			   foods.setFoodImage(rs.getString("foodImage"));
			   foods.setFoodCount(rs.getInt("foodCount"));
			   afoods.add(foods);	   
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,pst,rs);
		}	  
		return afoods;			
	}
	/**
	 * 获取总页数
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize){
		int pageCount = 0;
		int foodsCount = 0;//获取到商品的总数
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select count(*) as foodsCount from foodinfo";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				foodsCount = rs.getInt("foodsCount");
			}
			//页数计算
			if(foodsCount % pageSize == 0){
				pageCount = foodsCount / pageSize;
			}else{
				pageCount = foodsCount / pageSize + 1; 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn,pst,rs);
		}
		return pageCount;
	}
	/**
	 * 修改商品方法
	 */
	public int updateFoods(FoodInfo foods) throws IOException {
		HttpServletResponse response = null;
		PrintWriter out = response.getWriter();
		int res = 0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement pst = null;
		String sql = "update book set name=?,type=?,price=?,jj=?" + " where sy=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, foods.getSy());
			pst.setString(2, foods.getName());
			pst.setDouble(3, foods.getPrice());
			pst.setString(4, foods.getJj());
			pst.setString(5, foods.getType());
			res = pst.executeUpdate();
			
		} catch (Exception e) {
			out.println(e);
			e.printStackTrace();

		}finally {
			DBHelperDao.close(conn,pst,null);
		}
		return res;		
	}
	/**
	 * 查询所有商品
	 * @param foodsId
	 * @return
	 */
	public ArrayList<FoodInfo> showFoods() {
		ArrayList<FoodInfo> al = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from foodinfo";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(al==null){
					al=new ArrayList<FoodInfo>();					
				}
				FoodInfo foods = new FoodInfo();
			   foods.setFoodID(rs.getInt("foodID"));
			   foods.setFoodName(rs.getString("foodName"));
			   foods.setSortID(rs.getInt("sortId"));	
			   foods.setRemark(rs.getString("remark"));
			   foods.setFoodAddr(rs.getString("foodAddr"));
			   foods.setFoodPrice(rs.getDouble("foodPrice"));
			   foods.setDescription(rs.getString("description"));
			   foods.setFoodImage(rs.getString("foodImage"));
			   foods.setFoodCount(rs.getInt("foodCount"));
				al.add(foods);
				}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,stmt,rs);
		}	  
		return al;			
	}
	/**
	 *根据ID删除商品方法
	 */
	public int deleteFoods(int foodID) {
		int res = 0;
		String sql = "delete from book where sy='" + foodID + "'";
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			res = pst.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,pst,null);
		}		
		return res;		
	}
	/**商品详情
	 * 根据ID查询商品方法
	 * @param foodsId
	 * @return
	 */
	public FoodInfo getFoodInfoById(int id) {
		FoodInfo food =null;
		Connection conn =DBHelperDao.getConnection();
		ResultSet rs =null;
		Statement stmt =null;
		String sql ="select * from foodinfo where foodID='"+id+"'";
			try {
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()){
					food = new FoodInfo();
					food.setFoodID(rs.getInt("foodID"));	
					food.setFoodName(rs.getString("foodName"));	
					food.setSortID(rs.getInt("sortId"));		
					food.setRemark(rs.getString("remark"));		
					food.setFoodAddr(rs.getString("foodAddr"));		
					food.setFoodPrice(rs.getDouble("foodPrice"));		
					food.setDescription(rs.getString("description"));		
					food.setFoodImage(rs.getString("foodImage"));		
					food.setFoodCount(rs.getInt("foodCount"));						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, rs);
			}
		return food;		
	}

	/**
	 * 根据ID查询商品方法
	 * @param userId
	 * @return
	 */
	public ArrayList<FoodInfo> selFood(int foodID){
		ArrayList<FoodInfo> afoods = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from FoodInfo where foodID='" + foodID + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				   if(afoods==null) {
					   afoods=new ArrayList<FoodInfo>();
				   }
				   FoodInfo foods = new FoodInfo();
				   foods.setFoodID(rs.getInt("foodID"));
				   foods.setFoodName(rs.getString("foodName"));
				   foods.setRemark(rs.getString("remark"));
				   foods.setFoodAddr(rs.getString("foodAddr"));
				   foods.setFoodPrice(rs.getDouble("foodPrice"));
				   foods.setDescription(rs.getString("description"));
				   foods.setFoodImage(rs.getString("foodImage"));
				   foods.setFoodCount(rs.getInt("foodCount"));
				   foods.setSortID(rs.getInt("sortId"));
				   afoods.add(foods);		   		   
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close( conn,stmt,rs);
		}		
		return afoods;
	}
	
	/**
	 * 根据ID查询购物车商品方法
	 * @param foodsId
	 * @return
	 */
	public FoodInfoCar getCarFoodId(int foodid) {
		FoodInfoCar food =null;
		Connection conn =DBHelperDao.getConnection();
		ResultSet rs =null;
		Statement stmt =null;
		String sql ="select * from foodcart where foodID="+ foodid;
			try {
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()){
					food = new FoodInfoCar();
					food.setFoodID(rs.getInt("foodID"));
					food.setFoodImage(rs.getString("foodImage"));	
					food.setFoodDesc(rs.getString("description"));	
					food.setFoodPrice(rs.getDouble("foodPrice"));		
					food.setFoodNumber(rs.getInt("foodCarNum"));		
					food.setCount(rs.getInt("foodCount"));				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, rs);
			}
		return food;		
	}
	
	/**
	 * 添加购物车商品
	 * @param user
	 * @return
	 */
	public int addFoodCar(FoodInfo foodinfo,int number){
		int res =0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="insert into foodcart values(?,?,?,?,?,?)";
		try {
			stmt =conn.prepareStatement(sql);
			stmt.setInt(1, foodinfo.getFoodID());
			stmt.setString(2, foodinfo.getFoodImage());
			stmt.setString(3, foodinfo.getDescription());
			stmt.setDouble(4, foodinfo.getFoodPrice());
			stmt.setInt(5, number);
			stmt.setInt(6, foodinfo.getFoodCount());
			res = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}
    /*==商品分类分页显示==*/
	/**
	 * 根据当前页数和每页显示的行数来查询相应的结果
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 * @param pageNow
	 *            当前的页数
	 * @return
	 */
	public ArrayList<FoodType> getFoodTypeForPage(int pageSize,int pageNow){
		ArrayList<FoodType> afoods=null;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		System.out.println(pageSize);
		System.out.println(pageNow);
		String sql = "select * from foodssort limit "+pageSize*(pageNow-1)+","+pageSize+"";		
		try {
			pst = conn.prepareStatement(sql);
			rs= pst.executeQuery();
			while(rs.next()) {
			   if(afoods==null) {
				   afoods=new ArrayList<FoodType>();
			   }
			   FoodType foodtype = new FoodType();
			   foodtype.setSortId(rs.getInt("sortId"));
			   foodtype.setSortName(rs.getString("sortName"));
			   afoods.add(foodtype);		   		   
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,pst,rs);
		}	  
		return afoods;			
	}
	/**
	 * 获取总页数
	 * @param pageSize
	 * @return
	 */
	public int getSortCount(int pageSize){
		int pageCount = 0;
		int foodsCount = 0;//获取到商品的总数
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select count(*) as foodsCount from foodssort";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				foodsCount = rs.getInt("foodsCount");
			}
			//页数计算
			if(foodsCount % pageSize == 0){
				pageCount = foodsCount / pageSize;
			}else{
				pageCount = foodsCount / pageSize + 1; 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn,pst,rs);
		}
		return pageCount;
	}
	/**
	 *添加商品分类方法
	 */
	public int addFoodType(FoodType foodtype) {
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement pst= null;
		String sql = "insert into foodssort (sortId,sortName) values(default,?)";
		  try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, foodtype.getSortName());
			res = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,pst,null);
		}	  
		return res;		
	}
	
	/**
	 *根据ID删除商品分类方法
	 */
	public int deleteFoodType(int foodSortId) {
		int res = 0;
		String sql = "delete from foodssort where sortId='" + foodSortId + "'";
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			res = pst.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,pst,null);
		}		
		return res;		
	}
	
	/**
	 * 根据ID查询类别方法
	 * @param userId
	 * @return
	 */
	public FoodType selType(int foodSortId){
		FoodType foodtype = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from foodssort where sortId=" + foodSortId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){				
				foodtype = new FoodType();
				foodtype.setSortName(rs.getString("sortName"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close( conn,stmt,rs);
		}		
		return foodtype;
	}

    /**
	 * 修改商品类别方法
	 */
	public int updateType(FoodType foodtype){
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update foodssort set sortName=?" +" where sortId=?";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, foodtype.getSortName());
				stmt.setInt(2, foodtype.getSortId());
				res = stmt.executeUpdate();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 DBHelperDao.close(conn, stmt,null );
			}
		
		return res;
		
	}
	public ResultSet selectAl(){
		ResultSet resultSet = null;

		try{
			// 连接
			Connection conn = DBHelperDao.getConnection();
			// 创建sql语句
			String sql="select * from `book`";
			Statement statement = conn.createStatement();
			/**
			 * 使用JDBC连接数据库需要4步：
			 * 1、加载驱动程序；
			 * 2、连接数据库；
			 * 3、访问数据库；
			 * 4、执行查询；要用statement类的executeQuery()方法来下达select指令以查询数据库，executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。即语句：ResultSet rs=s.executeQuery(sql);
			 */
			resultSet = statement.executeQuery(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		return resultSet;
	}
}