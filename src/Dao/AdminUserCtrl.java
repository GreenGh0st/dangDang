package Dao;

import entity.Admin_UserInfo;
import entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;

public class AdminUserCtrl {
	/*
	 * ��̨����Ա��¼����
	 * 
	 * @param userName
	 * 
	 * @param userPwd
	 * 
	 * @return
	 */
	public Admin_UserInfo login(String loginName, String pass) {
		Admin_UserInfo user = null;
		Connection conn = DBHelperDao.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select * from admin where loginName='" + loginName + "'and loginPass = '" + pass + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				user = new Admin_UserInfo();
				user.setAdmin_loginName(rs.getString("loginName"));
				user.setAdmin_Name(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, rs);
		}
		return user;
	}


    /* ==�û��б����ݷ�ҳ== */
	/**
	 * ���ݵ�ǰҳ����ÿҳ��ʾ����������ѯ��Ӧ�Ľ��
	 * 
	 * @param pageSize ÿҳ��ʾ������
	 * @param pageNow  ��ǰ��ҳ��
	 * @return
	 */
	public ArrayList<UserInfo> getUserForPage(int pageSize, int pageNow) {
		ArrayList<UserInfo> al = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println(pageNow);
		System.out.println(pageSize);
		String sql = "select * from user limit " + pageSize * (pageNow - 1) + "," + pageSize + "";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (al == null) {
					al = new ArrayList<UserInfo>();
				}
				UserInfo userinfo = new UserInfo();
				userinfo.setUserId(rs.getInt("user_id"));
				userinfo.setUserName(rs.getString("userName"));
				userinfo.setUserpwd(rs.getString("password"));
				userinfo.setUserSex(rs.getString("gender"));
				userinfo.setName(rs.getString("name"));
				userinfo.setUserEmail(rs.getString("userEmail"));
				userinfo.setUserAddr(rs.getString("address"));
				userinfo.setUserTel(rs.getString("tel"));
//				userinfo.setUserState(rs.getInt("userState"));
				userinfo.setUserZt(rs.getInt("userZt"));
				al.add(userinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, rs);
		}
		return al;
	}

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize) {
		int pageCount = 0;
		int userCount = 0;// ��ȡ���û�������
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as userCount from user";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				userCount = rs.getInt("userCount");
			}
			// ҳ������
			if (userCount % pageSize == 0) {
				pageCount = userCount / pageSize;
			} else {
				pageCount = userCount / pageSize + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, rs);
		}
		return pageCount;
	}

	
	/** ɾ���û����� **/
	public int deleteUser(int userId) {
		int res = 0;
		String sql = "delete from user where user_id=?";
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, null);
		}
		return res;
	}
	
	/**
	 * ����id��ѯ�û�����
	 */
	public UserInfo selUser(int userId) {
		UserInfo user = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from user where user_id="+userId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				user = new UserInfo();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("userName"));
				user.setUserpwd(rs.getString("password"));
				user.setUserSex(rs.getString("gender"));
				user.setName(rs.getString("name"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserAddr(rs.getString("address"));
				user.setUserTel(rs.getString("tel"));
				user.setUserZt(rs.getInt("userZt"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, rs);
		}
		return user;
	}

	/**
	 * �޸��û����Ϸ���
	 */
	public int updateUser(UserInfo user) {
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update user set userName=?,name=?,password=?,gender=?,userEmail=?,tel=?,address=?,userZt=?" + " where user_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getUserPwd());
			stmt.setString(4, user.getUserSex());
			stmt.setString(5, user.getUserEmail());
			stmt.setString(6, user.getUserTel());
			stmt.setString(7, user.getUserAddr());
			stmt.setInt(8, user.getUserZt());
			stmt.setInt(9, user.getUserId());
			res = stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, null);
		}

		return res;

	}

	/**
	 * �޸��û�״̬����
	 */
	public int updateZt(int userId, int userZt) {
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update user set userZt=?" + " where user_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userZt);
			stmt.setInt(2, userId);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelperDao.close(conn, stmt, null);
		}

		return res;

	}

	/**
	 * ����û�����
	 */
		  public int addUser(UserInfo user) {
			  int res = 0; 
			  Connection conn = DBHelperDao.getConnection(); 
			  PreparedStatement stmt = null; 
			  String sql ="insert into user values (default,?,?,?,?,?,?,?,?)"; 
		try { 
			stmt = conn.prepareStatement(sql); 
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserPwd());
		    stmt.setString(3, user.getName());   
		    stmt.setString(4, user.getUserSex()); 
		    stmt.setString(5, user.getUserEmail());
		    stmt.setString(6, user.getUserTel()); 
		    stmt.setString(7, user.getUserAddr());
		    stmt.setInt(8, user.getUserZt()); 
		    res = stmt.executeUpdate();
		    
		  } catch (SQLException e) { 
			  // TODO Auto-generated catch block
		  e.printStackTrace(); 	  
		  }finally{ 
			  DBHelperDao.close(conn,stmt,null); 
		 }	  
		  return res; 
   	}
		 

}