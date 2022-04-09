package dao;

import java.sql.*;

public class DBUtil {
    static {
        Driver driver = null;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jspcourse";
        return DriverManager.getConnection(url,"root","root123456");
    }
    public static void release(Connection connection, Statement stmt,ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
