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
     * 方法名：searchAllArea
     * 功能：查询所有的区域信息
     * 输入参数：无
     * 返回值：所有区域信息的集合
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:06
     */
    public List<Area> searchAllArea() {
        List<Area> areaList = new ArrayList<>();
        conn = DBUtil.getConnection();  //连接数据库
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
     * function ：根据区域名称模糊查询区域
     * input    ：区域名称
     * return   ：区域列表
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:04
     **/
    public List<Area> searchAreaByName(String areaName) {
        List<Area> areaList = new ArrayList<>();
        conn = DBUtil.getConnection();// 和数据库建立连接
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
     * 方法名：delAreaByID
     * 功能：根据ID删除一个区域 ,标记是否
     * 输入参数：区域ID
     * 返回值：1:删除成功,-1:删除失败
     *
     * @author : Steel_HK
     * @create : 2020/8/21 14:06
     */
    public int delAreaByID(int areaID) {
        String sql = "DELETE FROM area WHERE area_id = ?";
        conn = DBUtil.getConnection();  //连接数据库
        if (conn == null) {
            System.out.println("数据库连接失败。");
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
            System.out.println("数据已被删除成功。");
        } else {
            System.out.println("数据删除失败，或未找到有关ID，请验证后重试。");
        }
        return result;
    }

    /**
     * method   : insertArea
     * function ：插入区域
     * input    ：输入Area对象
     * return   ：1:添加成功,0:添加失败,-1:对象为空
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
     * function ：根据区域ID更新区域
     * input    ：区域对象
     * return   ：1:更新成功,0:没有更新,-1:更新失败
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

        sql = sql + " where area_id = " + area.getAreaID();  //组装sql语句

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
