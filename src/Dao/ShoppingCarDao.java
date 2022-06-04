package Dao;

import entity.FoodInfo;
import entity.FoodInfoCar;

import java.sql.*;
import java.util.ArrayList;

/**
 * ���ﳵʵ����
 * @author Administrator
 *
 */
public class ShoppingCarDao {
    static int number = 1;
    /**
     * �����Ʒ�����ﳵ
     * @param id
     * @param session
     */
    public void addCard(int id){
        FoodInfoDao fd=new FoodInfoDao();
        //��ȡҪ���빺�ﳵ����Ʒ
        FoodInfo foodinfo = fd.getFoodInfoById(id);

        FoodInfoCar foodCart = fd.getCarFoodId(id);
        //�ж��Ƿ���ڹ��ﳵ���񴴽�
        if (foodCart==null) {
            number = 1;
            fd.addFoodCar(foodinfo, number);

        }else{
            UpNum(id);
        }
    }

/**
 * ���ﳵ��Ʒ������һ
 * @param session
 */
public void UpNum(int id){
    int res;
    number++;
    Connection conn =DBHelperDao.getConnection();
    PreparedStatement stmt =null;
    String sql = "update foodcart set foodCarNum=?" +" where foodID="+id;
        try {
            stmt =conn.prepareStatement(sql);
            stmt.setInt(1, number);
            res =stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBHelperDao.close(conn, stmt, null);
        }
}
/**
 * ���ﳵ��Ʒ������һ
 * @param session
 */
public void DownNum(int id){
    int res;
    FoodInfoDao fi = new FoodInfoDao();
    FoodInfoCar fc = fi.getCarFoodId(id);
    number = fc.getFoodNumber();
    number--;
    Connection conn =DBHelperDao.getConnection();
    PreparedStatement stmt =null;
    String sql = "update foodcart set foodCarNum=?" +" where foodID="+id;
        try {
            stmt =conn.prepareStatement(sql);
            stmt.setInt(1, number);
            res =stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBHelperDao.close(conn, stmt, null);
        }
}

    /**
 * ��ѯ���ﳵ��Ʒ����
 * @param foodsId
 * @return
 */
public int showFoodCarNumber() {
    int Count = 0;
    Connection conn = DBHelperDao.getConnection();
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "select sum(foodCarNum) as Count  FROM foodcart";
    try {
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        while(rs.next()){
                Count = rs.getInt("Count");
            }

    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        DBHelperDao.close(conn,stmt,rs);
    }
    return Count;
}

/**
 **��չ��ﳵ
 * @param session
 */
public void clearAll(){
    Connection conn = DBHelperDao.getConnection();
    Statement stmt = null;
    int rs = 0;
    String sql = "delete from foodcart";
    try {
        stmt=conn.createStatement();
        rs=stmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        DBHelperDao.close(conn, stmt, null);
    }
}
/**
 *����IDɾ�����ﳵ��Ʒ
 * @return
 */
public void Delete(int id){
    Connection conn = DBHelperDao.getConnection();
    Statement stmt = null;
    int rs = 0;
    String sql = "delete from foodcart where foodID ="+id;
    try {
        stmt=conn.createStatement();
        rs=stmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        DBHelperDao.close(conn, stmt, null);
    }
}
}
