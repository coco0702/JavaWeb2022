package dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean authenticate(String username, String pwd) {
        Connection conn = null;
        //Statement stmt = null;
        //预编译SQL
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //步骤一：实现并注册一个驱动（Driver对象）;
            //步骤二：创建一个连接到数据库的连接（Connection对象）;
            conn = DBUtil.getConnection();
            //步骤三：创建一个执行SQL语句的对象（Statement对象）;
            //stmt = conn.createStatement();
            String sql = "SELECT * FROM `t_user` WHERE username = ? AND pwd =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2, pwd);
            //步骤四：执行SQL语句;
            //String sql = "SELECT * FROM `t_user` WHERE username = '"+username+"' AND pwd = '"+pwd+"'";
            System.out.println(sql);
            rs = pstmt.executeQuery();
            //步骤五：处理结果（ResultSet对象）;
            return rs.next();
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.release(conn,pstmt,rs);
        }
    }

    @Override
    public List<User> selectAll()  {
        List<User> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            //步骤三：创建一个执行SQL语句的对象（Statement对象）;
            stmt = conn.createStatement();
            //步骤四：执行SQL语句;
            String sql = "select * from t_user";
            rs = stmt.executeQuery(sql);
            //步骤五：处理结果（ResultSet对象）;
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString(2));
                user.setPwd(rs.getString("pwd"));
                user.setGender(rs.getString("gender"));
                user.setCategory(rs.getString("category"));
                user.setInterest(rs.getString("interest"));
                list.add(user);
            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
            return list;
        }finally {
            //步骤六：关闭相关资源（各种JDBC对象）
          DBUtil.release(conn,stmt,rs);
        }
    }
}
