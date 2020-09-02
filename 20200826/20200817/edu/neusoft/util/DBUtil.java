package edu.neusoft.util;

import java.sql.*;;

/*���ݿ����Ӻ��ͷŹ�����*/
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

    /*��������*/
    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * method   : getConnection
     * function ����ȡ���ݿ�����
     * input    ����
     * return   �����ݿ����Ӷ���Connection
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
     * ��������closeJDBC
     * ���ܣ��ر����ݿ�����
     * ��������������ResultSet rs, ����Statement stmt, ���ݿ�����Connection conn
     * ����ֵ����
     * @return
     */
    public static void closeJDBC(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {    //�ȹرս����ResultSet
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stmt != null) {  //�ٹر�Statement����
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {  //���ر�Connection���ݿ�����
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
