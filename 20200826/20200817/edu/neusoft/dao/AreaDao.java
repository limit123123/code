package edu.neusoft.dao;

import edu.neusoft.model.Area;
import edu.neusoft.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AreaDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * ��������searchAllArea
     * ���ܣ���ѯ���е�������Ϣ
     * �����������
     * ����ֵ������������Ϣ�ļ���
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:06
     */
    public List<Area> searchAllArea() {
        List<Area> areaList = new ArrayList<>();
        conn = DBUtil.getConnection();  //�������ݿ�
        String sql = "SELECT * FROM area";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Area area = new Area();
                area.setAreaID(rs.getInt("area_id"));
                area.setAreaName(rs.getString("area_name"));
                area.setAreaInfo(rs.getString("area_info"));
                areaList.add(area);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return areaList;
    }

    /**
     * method   : searchAreaByName
     * function ��������������ģ����ѯ����
     * input    ����������
     * return   �������б�
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:04
     **/
    public List<Area> searchAreaByName(String areaName) {
        List<Area> areaList = new ArrayList<>();
        conn = DBUtil.getConnection();// �����ݿ⽨������
        String sql = "SELECT * FROM area WHERE area_name like ?";
        try {
            pst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.setString(1, areaName);
            rs = pst.executeQuery();
            while (rs.next()) {
                Area area = new Area();
                area.setAreaID(rs.getInt("area_id"));
                area.setAreaName(rs.getString("area_name"));
                area.setAreaInfo(rs.getString("area_info"));
                areaList.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return areaList;
    }

    /**
     * ��������delAreaByID
     * ���ܣ�����IDɾ��һ������ ,����Ƿ�
     * �������������ID
     * ����ֵ��1:ɾ���ɹ�,-1:ɾ��ʧ��
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:06
     */
    public int delAreaByID(int areaID) {
        String sql = "DELETE FROM area WHERE area_id = ?";
        conn = DBUtil.getConnection();  //�������ݿ�
        if (conn == null) {
            System.out.println("���ݿ�����ʧ�ܡ�");
            return 0;
        }
        int result = -1;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, areaID);
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
     * method   : insertArea
     * function ����������
     * input    ������Area����
     * return   ��1:��ӳɹ�,0:���ʧ��,-1:����Ϊ��
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:01
     **/
    public int insertArea(Area area) {
        int rst = -1;
        if (area == null)
            rst = -1;
        conn = DBUtil.getConnection();
        String sql = "insert into area values (null,?,?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, area.getAreaName());
            pst.setString(2, area.getAreaInfo());
            rst = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return rst;
    }

    /**
     * method   : updateArea
     * function ����������ID��������
     * input    ���������
     * return   ��1:���³ɹ�,0:û�и���,-1:����ʧ��
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:06
     **/
    public int updateArea(Area area) {
        int rst = -1;

        conn = DBUtil.getConnection();
        String sql = "update area set area_id = " + area.getAreaID();

        if (area.getAreaName() != null)
            sql = sql + ",area_name = \"" + area.getAreaName() + "\"";
        if (area.getAreaInfo() != null)
            sql = sql + ",area_info = \"" + area.getAreaInfo() + "\"";

        sql = sql + " where area_id = " + area.getAreaID();  //��װsql���

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
