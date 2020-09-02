package edu.neusoft.test;

import edu.neusoft.util.DBUtil;

import java.sql.*;

public class DBUtilTest {
    public static void main(String[] args) {
        String sql = "INSERT INTO area values (null,?,?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,"��ʯ��");
            pst.setString(2,"��ʯ������");
            pst.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
