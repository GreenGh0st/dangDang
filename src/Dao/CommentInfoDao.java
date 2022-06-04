package Dao;

import entity.CommentInfo;

import java.sql.*;
import java.util.ArrayList;

public class CommentInfoDao {

	/**
	 * 添加商品评论方法
	 * @param comment
	 * @return
	 */
	public int addComment(CommentInfo comment){
		int res =0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="insert into commentinfo values(default,?,?,?,?,?,?,?,?,?,?) ";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setInt(1, comment.getFoodID());
				stmt.setInt(2, comment.getOrderID());
				stmt.setString(3, comment.getUserName());
				stmt.setString(4, comment.getCom_context());
				stmt.setString(5, comment.getCom_data());
				stmt.setString(6, comment.getFoodQuality());
				stmt.setString(7, comment.getCom_delivery());
				stmt.setString(8, comment.getCom_serve());
				stmt.setString(9, comment.getAdmin_name());
				stmt.setString(10, comment.getAdmin_Reply());
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
	 * 回复商品评论方法
	 * @param comment
	 * @return
	 */
	public int ReplyComment(CommentInfo comment){
		int res =0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="update commentinfo set admin_name=?,admin_Reply=?" +" where com_id=?";
			try {
				stmt =conn.prepareStatement(sql);						
				stmt.setString(1, comment.getAdmin_name());
				stmt.setString(2, comment.getAdmin_Reply());
				stmt.setInt(3, comment.getCom_id());
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
	 * 查看商品评论方法
	 * @param goodsId
	 * @return
	 */
	public ArrayList<CommentInfo> goodsComment(int commentId) {
		ArrayList<CommentInfo> acomment = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from commentinfo where com_id="+commentId;
		try {			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(acomment==null){
					acomment=new ArrayList<CommentInfo>();					
				}
				CommentInfo comment = new CommentInfo();
				comment.setCom_id(rs.getInt("com_id"));
				comment.setFoodID(rs.getInt("foodID"));
				comment.setUserName(rs.getString("userName"));
				comment.setCom_context(rs.getString("com_context"));
				comment.setCom_data(rs.getString("com_data"));
				comment.setFoodQuality(rs.getString("com_fooaQua"));
				comment.setCom_delivery(rs.getString("com_delivery"));
				comment.setCom_serve(rs.getString("com_serveQua"));
				comment.setAdmin_name(rs.getString("admin_name"));
				comment.setAdmin_Reply(rs.getString("admin_Reply"));						
				acomment.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt,rs );
		}
		return acomment;
	}	
	/*==评论列表数据分页==*/
	/**
	 * 根据当前页数和每页显示的行数来查询相应的结果
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 * @param pageNow
	 *            当前的页数
	 * @return
	 */
	public ArrayList<CommentInfo> selgoodsComment(int pageSize, int pageNow,int foodId) {
		ArrayList<CommentInfo> acomment = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		if(foodId==0) {
			sql = "select * from commentinfo limit "+pageSize*(pageNow-1)+","+pageSize+"";
		}
		else {
			sql = "select * from commentinfo where foodID="+foodId+" limit "+pageSize*(pageNow-1)+","+pageSize+"";
		}
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(acomment==null){
					acomment=new ArrayList<CommentInfo>();					
				}
				CommentInfo comment = new CommentInfo();
				comment.setCom_id(rs.getInt("com_id"));
				comment.setFoodID(rs.getInt("foodID"));
				comment.setOrderID(rs.getInt("orderID"));
				comment.setUserName(rs.getString("userName"));
				comment.setCom_context(rs.getString("com_context"));
				comment.setCom_data(rs.getString("com_data"));
				comment.setFoodQuality(rs.getString("com_fooaQua"));
				comment.setCom_delivery(rs.getString("com_delivery"));
				comment.setCom_serve(rs.getString("com_serveQua"));
				comment.setAdmin_name(rs.getString("admin_name"));
				comment.setAdmin_Reply(rs.getString("admin_Reply"));				
				acomment.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt, rs);
		}
		return acomment;
	}
	/**
	 * 获取商品评论总页数
	 * @param pageSize
	 * @return
	 */
	public int goodsCommentCount(int pageSize){
		int pageCount = 0;
		int CommentCount = 0;//获取到商品的总数
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as goodsCommentCount from commentinfo";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				CommentCount = rs.getInt("goodsCommentCount");
			}
			//页数计算
			if(CommentCount % pageSize == 0){
				pageCount = CommentCount / pageSize;
			}else{
				pageCount = CommentCount / pageSize + 1; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt, rs);
		}
		return pageCount;
	}
	/**
	 * 删除商品评论
	 * @param commentId
	 * @return
	 */
	public int deleteGoodsComment(int commentId){
		int res = 0;
		String sql = "delete from commentinfo where commentId=?";
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, commentId);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt, null );
		}
		return res;
	}
}
