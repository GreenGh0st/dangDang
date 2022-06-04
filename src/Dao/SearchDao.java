package Dao;

import entity.FoodInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * ��Ʒ������
 * @author Administrator
 *
 */
public class SearchDao {
	/**
	 * ���ݹؼ��ֲ�ѯ��Ʒ
	 * @param foodsId
	 * @return
	 */
	public ArrayList<FoodInfo> showFoodsByKey(String searchKey){
		ArrayList<FoodInfo> allfood = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from foodinfo where foodName like '%"+searchKey+"%'";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allfood==null){
					allfood=new ArrayList<FoodInfo>();					
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
				allfood.add(foods);
				}
			} catch (SQLException e) {		
			e.printStackTrace();
			}finally {
				DBHelperDao.close(conn,stmt,rs);
				}
		return allfood;
		}
	/**
	 * �����������ѯ���ID
	 * @param foodsId
	 * @return
	 */
	public int showSotrID(String sortKey){
		int sortId = 0;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select sortId from foodssort where sortName='"+sortKey+"'";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				sortId = rs.getInt("sortId");
				}
			} catch (SQLException e) {		
			e.printStackTrace();
			}finally {
				DBHelperDao.close(conn,stmt,rs);
				}
		return sortId;
		}
	/**
	 * ��������ѯ��Ʒ
	 * @param foodsId
	 * @return
	 */
	public ArrayList<FoodInfo> showFoodsBySort(int sortId){
		ArrayList<FoodInfo> allfood = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from foodinfo where sortId="+sortId;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allfood==null){
					allfood=new ArrayList<FoodInfo>();					
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
				allfood.add(foods);
				}
			} catch (SQLException e) {		
			e.printStackTrace();
			}finally {
				DBHelperDao.close(conn,stmt,rs);
				}
		return allfood;
		}	
	/**
	 * ����ԭ���ز�ѯ��Ʒ
	 * @param foodsId
	 * @return
	 */
	public ArrayList<FoodInfo> showFoodsByAddr(String foodAddr){
		ArrayList<FoodInfo> allfood = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from foodinfo where foodAddr='"+foodAddr+"'";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allfood==null){
					allfood=new ArrayList<FoodInfo>();					
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
				allfood.add(foods);
				}
			} catch (SQLException e) {		
			e.printStackTrace();
			}finally {
				DBHelperDao.close(conn,stmt,rs);
				}
		return allfood;
		}
	/**
	 * ����������Ʒ
	 * @param foodsId
	 * @return
	 */
	public ArrayList<FoodInfo> showFoodsByOrder(int flag){
		String sql = null;
		ArrayList<FoodInfo> allfood = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		if(flag == 1) {
			sql = "select * from foodinfo order by foodPrice asc";
		}
		else {
			sql = "select * from foodinfo order by foodPrice desc";
		}
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allfood==null){
					allfood=new ArrayList<FoodInfo>();					
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
				allfood.add(foods);
				}
			} catch (SQLException e) {		
			e.printStackTrace();
			}finally {
				DBHelperDao.close(conn,stmt,rs);
				}
		return allfood;
		}
	/**
	 * ���ݼ۸������ѯ��Ʒ
	 * @param foodsId
	 * @return
	 */
	public ArrayList<FoodInfo> showFoodsByPrice(int pricedown,int priceup){
		ArrayList<FoodInfo> allfood = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select *from foodinfo where foodPrice between "+pricedown+" and "+priceup;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(allfood==null){
					allfood=new ArrayList<FoodInfo>();					
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
				allfood.add(foods);
				}
			} catch (SQLException e) {		
			e.printStackTrace();
			}finally {
				DBHelperDao.close(conn,stmt,rs);
				}
		return allfood;
		}
}
