package app;

import java.sql.*;

public class DBDemo {
    public static void main(String[] args) throws SQLException {
        //步骤一：实现并注册一个驱动（Driver对象）;
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        //步骤二：创建一个连接到数据库的连接（Connection对象）;
        String url = "jdbc:mysql://localhost:3306/jspcourse";
        Connection conn = DriverManager.getConnection(url,"root","root123456");
        //步骤三：创建一个执行SQL语句的对象（Statement对象）;
        Statement stmt = conn.createStatement();
        //步骤四：执行SQL语句;
        String sql = "select * from t_user";
        ResultSet rs = stmt.executeQuery(sql);
        //步骤五：处理结果（ResultSet对象）;
        while (rs.next()) {
            System.out.println("id:"+rs.getInt("id")+"  username:"+rs.getString(2));
        }
        //步骤六：关闭相关资源（各种JDBC对象）
        rs.close();
        stmt.close();
        conn.close();
    }
}
