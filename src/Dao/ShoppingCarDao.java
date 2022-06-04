package Dao;

import entity.FoodInfo;
import entity.FoodInfoCar;

import java.sql.*;
import java.util.ArrayList;

/**
 * 购物车实现类
 * @author Administrator
 *
 */
public class ShoppingCarDao {
    static int number = 1;
    /**
     * 添加商品到购物车
     * @param id
     * @param session
     */
    public void addCard(int id){
        FoodInfoDao fd=new FoodInfoDao();
        //获取要加入购物车的商品
        FoodInfo foodinfo = fd.getFoodInfoById(id);

        FoodInfoCar foodCart = fd.getCarFoodId(id);
        //判断是否存在购物车，否创建
        if (foodCart==null) {
            number = 1;
            fd.addFoodCar(foodinfo, number);

        }else{
            UpNum(id);
        }
    }

/**
 * 购物车商品数量加一
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
 * 购物车商品数量减一
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
 * 查询购物车商品数量
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
 **清空购物车
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
 *根据ID删除购物车商品
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
