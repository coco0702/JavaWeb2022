package controller;

public class DruidUtil {

   /* static DruidDataSource dataSource;

    static {
        Properties prop = new Properties();
        try {
            prop.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
            //dataSource.addFilters("stat,log4j,wall");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/


}
