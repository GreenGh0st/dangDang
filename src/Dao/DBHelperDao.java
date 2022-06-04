package Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;


public class DBHelperDao {
	
	private static final String DIRVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/book";
	private static final String USER = "root";
	private static final String PASS = "xiao502";
	
	public static Connection getConnection() {
         Connection conn = null;
         
        try {
            Class.forName(DIRVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(conn.toString());
			System.out.println("���ݿ����ӳɹ�");
			
        } catch (Exception e) {
            System.out.println("��ȡ����ʱ���쳣" + e.getMessage());
            conn = null;
        }
        return conn;
    }
		/**
		 * 
		 �ر����ݿ�����
		 * 
		 */
		 public static void close(Connection conn, Statement stmt, ResultSet rs) {

		        try {
		            if (rs != null) {
		                rs.close();
		            }
		            if (stmt != null) {
		            	stmt.close();
		            }
		            if (conn != null) {
		                conn.close();
		            }
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		    }
	public ResultSet selectAll(){
		ResultSet resultSet = null;

		try{
			// ����
			Connection conn = DBHelperDao.getConnection();
			// ����sql���
			String sql="select * from `order`";
			Statement statement = conn.createStatement();
			/**
			 * ʹ��JDBC�������ݿ���Ҫ4����
			 * 1��������������
			 * 2���������ݿ⣻
			 * 3���������ݿ⣻
			 * 4��ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ⣬executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ�á�����䣺ResultSet rs=s.executeQuery(sql);
			 */
			resultSet = statement.executeQuery(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		return resultSet;
	}

}
