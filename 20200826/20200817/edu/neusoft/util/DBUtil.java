package edu.neusoft.util;

import java.sql.*;;

/*数据库连接和释放工具类*/
public class DBUtil {
    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static String dbURL ="jdbc:mysql://localhost:3306/aevsp?rewriteBatchedStatements=true";
    /*jdbc:mysql://localhost:3306/students?rewriteBatchedStatements=true
    		"jdbc:mysql://localhost:3306/aevsp"
            + "?serverTimezone=UTC&useUnicode=true"
            + "&characterEncoding=utf8&useSSL=false";
            */
    private static String userName = "root";
    private static String userPwd = "0000";

    /*加载驱动*/
    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * method   : getConnection
     * function ：获取数据库连接
     * input    ：无
     * return   ：数据库连接对象Connection
     * @author  : Steel_HK
     **/
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, userName, userPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 方法名：closeJDBC
     * 功能：关闭数据库连接
     * 输入参数：结果集ResultSet rs, 对象Statement stmt, 数据库连接Connection conn
     * 返回值：无
     * @return
     */
    public static void closeJDBC(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {    //先关闭结果集ResultSet
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stmt != null) {  //再关闭Statement对象
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {  //最后关闭Connection数据库连接
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
