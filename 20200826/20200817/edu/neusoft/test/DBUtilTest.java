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
            pst.setString(1,"ºÚÊ¯½¸");
            pst.setString(2,"ºÚÊ¯½¸¸½½ü");
            pst.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
