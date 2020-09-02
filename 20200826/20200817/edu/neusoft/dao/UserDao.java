package edu.neusoft.dao;

import edu.neusoft.model.Area;
import edu.neusoft.model.User;
import edu.neusoft.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * method   : getUserRole
     * function ����ȡ�û���ɫ
     * input    ���û�
     * return   ��0:����Ա,1:������,2:־Ը��,-1�û����������
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:24
     **/
    public int getUserRole(User user) {
        int rst = -1;
        conn = DBUtil.getConnection();
        String sql = "SELECT user_password,user_role FROM user WHERE user_username = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUser_username());
            rs = pst.executeQuery();
            if (!rs.next()) rst = -1;
            else {
                if (user.getUser_password().equals(rs.getString("user_password"))) {
                    rst = rs.getInt("user_role");
                } else {
                    rst = -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return rst;
    }
    
    public int getDist(String name) {
    	//������ڣ�rst=0
        int rst = -1;
        conn = DBUtil.getConnection();
        String sql = "SELECT * FROM user WHERE user_username = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (!rs.next()) rst = -1;
            else {
                if (name.equals(rs.getString("user_username"))) {
                   rst=0;
                } else {
                    rst = -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return rst;
    }

    /**
     * method   : insertUser
     * function �����һ���û�
     * input    ���û�
     * return   ��1:��ӳɹ�,0:���ʧ��,-1:����Ϊ��
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:26
     **/
    public int insertUser(User user) {
        int rst = -1;
        if (user == null)
            rst = -1;
        conn = DBUtil.getConnection();
        String sql = "insert into user values (null,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUser_name());
            pst.setString(2, user.getUser_sex());
            pst.setDate(3, user.getUser_birthday());
            pst.setString(4, user.getUser_email());
            pst.setString(5, user.getUser_username());
            pst.setString(6, user.getUser_password());
            pst.setInt(7, user.getUser_role());
            rst = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return rst;
    }

    /**
     * method   : searchAllUser
     * function ����ѯ����־Ը��
     * input    ����
     * return   ���û��б�
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:28
     **/
    public List<User> searchAllUser() {
        List<User> userList = new ArrayList<>();
        conn = DBUtil.getConnection();  //�������ݿ�
        String sql = "SELECT * FROM user WHERE user_role = 2";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_birthday(rs.getDate("user_birthday"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_username(rs.getString("user_username"));
                user.setUser_password(rs.getString("user_password"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    /**
     * method   : searchAllUser
     * function ����ѯ���и�����
     * input    ����
     * return   ���������б�
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:28
     **/
    public List<User> searchAllPrincipal() {
        List<User> userList = new ArrayList<>();
        conn = DBUtil.getConnection();  //�������ݿ�
        String sql = "SELECT * FROM user WHERE user_role = 1";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_birthday(rs.getDate("user_birthday"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_username(rs.getString("user_username"));
                user.setUser_password(rs.getString("user_password"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    /**
     * method   : delUserByID
     * function �������û�IDɾ���û�
     * input    ���û�ID
     * return   ��1:ɾ���ɹ�,-1:ɾ��ʧ��
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:29
     **/
    public int delUserByID(int userID) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        conn = DBUtil.getConnection();
        if (conn == null) {
            System.out.println("���ݿ�����ʧ�ܡ�");
            return 0;
        }
        int result = -1;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, userID);
            pst.executeUpdate();
            result = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        if (result == 1) {
            System.out.println("�����ѱ�ɾ���ɹ���");
        } else {
            System.out.println("����ɾ��ʧ�ܣ���δ�ҵ��й�ID������֤�����ԡ�");
        }
        return result;
    }

    /**
     * method   : updateUser
     * function ������ID�����û������������
     * input    ���û����䡢�û�����
     * return   ��1:���³ɹ�,0:�޸���,-1:����ʧ��
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:31
     **/
    public int updateUser(User user) {
        int rst = -1;
        conn = DBUtil.getConnection();
        String sql = "update user set user_id = " + user.getUser_id();
        if (user.getUser_email() != null)
            sql = sql + ",user_email = \"" + user.getUser_email() + "\"";
        if (user.getUser_password() != null)
            sql = sql + ",user_password = \"" + user.getUser_password() + "\"";

        sql = sql + " where user_id = " + user.getUser_id();  //��װsql���
        try {
            pst = conn.prepareStatement(sql);
            rst = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return rst;
    }
}

