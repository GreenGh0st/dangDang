package filter;

import java.sql.*;

public class Filte {
    public static void main(String[] args) throws SQLException {
        Filte f = new Filte();
        int n = 5;
        PreparedStatement p = f.getPre("select * from `order` where userName=?;");
        p.setString(1, "q");
        String info = f.getR(p, n);
        if (!info.equals("") && info != null) {
            String[] s = info.split(" ");
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        }
    }

    public PreparedStatement getPre(String sql) throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("class not");
        }
        String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "xiao502";
        con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        return con.prepareStatement(sql);
    }

    public String getR(PreparedStatement pstmt, int i) throws SQLException {
        ResultSet r = pstmt.executeQuery();
        String list = "";
        while (r.next()) {
            for (int j = 1; j <= i; j++)
                list = list + r.getString(j) + " ";
        }
        return list;
    }
}
