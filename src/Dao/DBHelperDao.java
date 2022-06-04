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
			System.out.println("数据库连接成功");
			
        } catch (Exception e) {
            System.out.println("获取连接时，异常" + e.getMessage());
            conn = null;
        }
        return conn;
    }
		/**
		 * 
		 关闭数据库连接
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
			// 连接
			Connection conn = DBHelperDao.getConnection();
			// 创建sql语句
			String sql="select * from `order`";
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
