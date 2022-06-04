package Dao;

import entity.Admin_NewInfo;

import java.sql.*;
import java.util.ArrayList;

public class NewInfoDao {
	/**
	 * ������ŷ���
	 * @param user
	 * @return
	 */
	public int Admin_addNews(Admin_NewInfo news){
		int res =0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt =null;
		String sql ="insert into news values(default,?,?,?)";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, news.getNewsTitle());
				stmt.setString(2, news.getNewsContent());
				stmt.setString(3, news.getNewsDate());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error");
			}finally{
				DBHelperDao.close(conn,stmt,null);
			}
		return res;
	}
	/*==�����б����ݷ�ҳ==*/
	/**
	 * ���ݵ�ǰҳ����ÿҳ��ʾ����������ѯ��Ӧ�Ľ��
	 * 
	 * @param pageSize
	 *            ÿҳ��ʾ������
	 * @param pageNow
	 *            ��ǰ��ҳ��
	 * @return
	 */
	public ArrayList<Admin_NewInfo> getNewsForPage(int pageSize, int pageNow) {
		ArrayList<Admin_NewInfo> anews = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from news limit "+pageSize*(pageNow-1)+","+pageSize+"";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(anews==null){
					anews=new ArrayList<Admin_NewInfo>();					
				}
				Admin_NewInfo news = new Admin_NewInfo();
				news.setNewsId(rs.getInt("newsId"));
				news.setNewsTitle(rs.getString("newsTitle"));	
				news.setNewsContent(rs.getString("newsContent"));
				news.setNewsDate(rs.getString("newsDate"));
				anews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close( conn, stmt,rs);
		}
		return anews;
	}
	/**
	 * ��ȡ��ҳ��
	 * @param pageSize
	 * @return
	 */
	public int getNewsCount(int pageSize){
		int pageCount = 0;
		int newsCount = 0;//��ȡ�������б������
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as newsCount from news";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				newsCount = rs.getInt("newsCount");
			}
			//ҳ������
			if(newsCount % pageSize == 0){
				pageCount = newsCount / pageSize;
			}else{
				pageCount = newsCount / pageSize + 1; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt,rs);
		}
		return pageCount;
	}
	/**
	 * ����ID��ѯ���ŷ���
	 * @param userId
	 * @return
	 */
	public Admin_NewInfo selNews(int newsId){
		Admin_NewInfo news = null;
		Connection conn = DBHelperDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from news where newsId=" + newsId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){				
				news = new Admin_NewInfo();				
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsContent(rs.getString("newsContent"));
				news.setNewsDate(rs.getString("newsDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close( conn,stmt,rs);
		}		
		return news;
	}
	/**
	 * �޸��������Ϸ���
	 */
	public int updateNews(Admin_NewInfo news){
		int res = 0;
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		String sql = "update news set newsTitle=?,newsContent=?,newsDate=?" +" where newsId=?";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, news.getNewsTitle());
				stmt.setString(2, news.getNewsContent());
				stmt.setString(3, news.getNewsDate());
				stmt.setInt(4, news.getNewsId());
				res = stmt.executeUpdate();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 DBHelperDao.close(conn, stmt,null );
			}
		
		return res;
		
	}
	/**
	 * ����IDɾ������
	 * @param userId
	 * @return
	 */
	public int deleteNews(int newsId){
		int res = 0;
		String sql = "delete from news where newsId=?";
		Connection conn = DBHelperDao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  newsId);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelperDao.close(conn, stmt,null );
		}
		return res;
	}
	
}
