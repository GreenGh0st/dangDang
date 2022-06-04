package Dao;

import entity.MyAddress;
import entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;

public class UserCtrl {
	/* 
	  * 前台用户登录方法
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public UserInfo login(String userName,String userPass){
			UserInfo user =null;
			Connection conn =DBHelperDao.getConnection();
			ResultSet rs =null;
			Statement stmt =null;
			String sql ="select * from user where userName='"+ userName+"'and password = '"+userPass+"'";
				try {
					stmt=conn.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs.next()){
						user = new UserInfo();
						user.setUserId(rs.getInt(1));	
						user.setUserName(rs.getString(2));	
						user.setUserpwd(rs.getString(3));	
						user.setName(rs.getString(4));	
						user.setUserSex(rs.getString(5));
						user.setUserEmail(rs.getString(6));		
						user.setUserTel(rs.getString(7));	
						user.setUserAddr(rs.getString(8));	
						user.setUserZt(rs.getInt(9));				
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBHelperDao.close(conn, stmt, rs);
				}
			return user;
	}
	/* 
	 *通过手机号登录
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public UserInfo PhoneLogin(String phone){
			UserInfo user =null;
			Connection conn =DBHelperDao.getConnection();
			ResultSet rs =null;
			Statement stmt =null;
			String sql ="select * from user where tel="+ phone;
				try {
					stmt=conn.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs.next()){
						user = new UserInfo();
						user.setUserId(rs.getInt(1));	
						user.setUserName(rs.getString(2));	
						user.setUserpwd(rs.getString(3));	
						user.setName(rs.getString(4));	
						user.setUserSex(rs.getString(5));
						user.setUserEmail(rs.getString(6));		
						user.setUserTel(rs.getString(7));	
						user.setUserAddr(rs.getString(8));	
						user.setUserZt(rs.getInt(9));				
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBHelperDao.close(conn, stmt, rs);
				}
			return user;
	}
	/* 
	 *查询手机号是否注册
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public int SelectPhone(String phone){
		int flag = 0;
		Connection conn =DBHelperDao.getConnection();
		ResultSet rs =null;
		Statement stmt =null;
		String sql ="select count(*) as telPhone from user where tel ="+phone;
			try {
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()){
					flag = rs.getInt("telPhone");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, rs);
			}
		return flag;
	}
	/**
	 * 用户注册方法
	 * @param user
	 * @return
	 */
	public int addUser(UserInfo user){
		int res =0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="insert into user values(default,?,?,?,?,?,?,?,default)";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, user.getUserName());
				stmt.setString(2, user.getUserPwd());
				stmt.setString(3, user.getName());
				stmt.setString(4, user.getUserSex());
				stmt.setString(5, user.getUserEmail());
				stmt.setString(6, user.getUserTel());
				stmt.setString(7, user.getUserAddr());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}
	/**
	 * 判断用户名是否重复
	 * @param user
	 * @return
	 */
	public int toRepeat(String userName){
		int flag =0;
		ResultSet rs =null;
		Statement stmt =null;
		Connection conn =DBHelperDao.getConnection();
		String sql ="select userName from user where locate('"+userName+"',userName)";
			try {
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()) {
					flag++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return flag;
	}
	/**
	 * 用户修改资料方法
	 * @param user
	 * @return
	 */
	public int updateUser(UserInfo user,String userId){
		int res =0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql = "update user set userName=?,password=?,name=?,gender=?,userEmail=?,tel=?,address=?" +" where user_id="+userId;
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, user.getUserName());
				stmt.setString(2, user.getUserPwd());
				stmt.setString(3, user.getName());
				stmt.setString(4, user.getUserSex());
				stmt.setString(5, user.getUserEmail());
				stmt.setString(6, user.getUserTel());
				stmt.setString(7, user.getUserAddr());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}
	/**
	 * 添加收货地址
	 * @param user
	 * @return
	 */
	public int addAddress(MyAddress ma){
		int res =0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="insert into receive values(default,?,?,?,?,?,?,?,default)";
		try {
			stmt =conn.prepareStatement(sql);
			stmt.setInt(1, ma.getUserId());
			stmt.setString(2, ma.getName());
			stmt.setString(3, ma.getAddress());
			stmt.setString(4, ma.getZipCode());
			stmt.setString(5, ma.getPhone());
			stmt.setString(6, ma.getEmail());
			stmt.setString(7, ma.getAddralias());
			res = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}

    /**
	 *根据ID删除收货地址
	 * @return
	 */
	public void DelAddress(int addressId){
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		String sql = "delete from receive where address_id ="+addressId;
		try {
			stmt=conn.createStatement();
			res=stmt.executeUpdate(sql);
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn, stmt, null);
		}	  
	}
	/**
	 * 用户修改地址信息
	 * @param user
	 * @return
	 */
	public int updateAddress(MyAddress addr,int addressId){
		int res =0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql = "update receive set name=?,address=?,postalcode=?,phone=?,email=?,addralias=?"+"where address_id="+addressId;
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, addr.getName());
				stmt.setString(2, addr.getAddress());
				stmt.setString(3, addr.getZipCode());
				stmt.setString(4, addr.getPhone());
				stmt.setString(5, addr.getEmail());
				stmt.setString(6, addr.getAddralias());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}
	/**
	 * 查询地址id
	 * @param foodsId
	 * @return
	 */
	public ArrayList<Integer>  getAddressId(int userId) {
		ArrayList<Integer> addressList = new ArrayList<Integer>();
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT address_id FROM receive WHERE user_id="+userId;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				addressList.add(rs.getInt("address_id"));
				}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,stmt,rs);
		}	  
		return addressList;			
	}
	/**
	 * 设置默认地址
	 * @param user
	 * @return
	 */
	public int updateStatus(int addressId,int state){
		int res = 0;
		Connection conn =DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql = "update receive set status=? where address_id="+addressId;
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setInt(1, state);
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBHelperDao.close(conn, stmt, null);
			}
		return res;
	}
	/**
	 * 查询默认收货地址
	 * @param foodsId
	 * @return
	 */
	public MyAddress selStatusAddress() {
		MyAddress addr = new MyAddress();
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from receive where status="+1;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				addr.setAddressId(rs.getInt("address_id"));
				addr.setUserId(rs.getInt("user_id"));
				addr.setName(rs.getString("name"));
				addr.setAddress(rs.getString("address"));	
				addr.setZipCode(rs.getString("postalcode"));
				addr.setPhone(rs.getString("phone"));
				addr.setEmail(rs.getString("email"));
				addr.setAddralias(rs.getString("addralias"));
				addr.setStatus(rs.getInt("status"));
				}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBHelperDao.close(conn,stmt,rs);
			}
		return addr;
	}

}