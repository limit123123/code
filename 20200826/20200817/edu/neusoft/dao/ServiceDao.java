package edu.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neusoft.model.Area;
import edu.neusoft.model.Service;
import edu.neusoft.util.DBUtil;

public class ServiceDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
	  public int insertService(Service service) {
	        int rst = -1;
	        if (service == null)
	            rst = -1;
	        conn = DBUtil.getConnection();
	        String sql = "insert into service values (null,?,?,?,?,?,?,?,?)";
	        try {
	            pst = conn.prepareStatement(sql);
	         //   pst.setInt(1, service.getSv_id());
	            pst.setString(1, service.getSv_name());
	            pst.setString(2,service.getSv_company());
	            pst.setInt(3, service.getSv_area_id());
	            pst.setInt(4, service.getSv_number());
	            pst.setDate(5, service.getSv_start_time());
	            pst.setDate(6, service.getSv_end_time());
	            pst.setString(7, service.getSv_info());
	            pst.setInt(8, service.getSv_head_id());
	            rst = pst.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeJDBC(rs, pst, conn);
	        }
	        return rst;
	    }

	public  List<Service> searchServiceByName(String sv_company) {
		  List<Service> ServiceList = new ArrayList<>();
	        conn = DBUtil.getConnection();// 和数据库建立连接
	        String sql = "select * from service WHERE sv_company = ?";
	        try {
	            pst = conn.prepareStatement(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            pst.setString(1,sv_company);
	            rs = pst.executeQuery();
	            while (rs.next()) {
	            Service service = new	Service();
	            service.setSv_id(rs.getInt("sv_id"));
	            service.setSv_name(rs.getString("sv_name")) ;
	            service.setSv_company(rs.getString("sv_company"));
	            service.setSv_area_id(rs.getInt("sv_area_id"));
	            service.setSv_number(rs.getInt("sv_number"));
	            service.setSv_start_time(rs.getDate("sv_start_time"));
	            service.setSv_end_time(rs.getDate("sv_end_time"));
	            service.setSv_info(rs.getString("sv_info"));
	            service.setSv_head_id(rs.getInt("sv_head_id"));
	 
	                ServiceList.add(service);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeJDBC(rs, pst, conn);
	        }
	        return ServiceList;
	    }
	public  List<Service> searchServiceByServiceName(String sv_name) {
		  List<Service> ServiceList = new ArrayList<>();
	        conn = DBUtil.getConnection();// 和数据库建立连接
	        String sql = "select * from service WHERE sv_name = ?";
	        try {
	            pst = conn.prepareStatement(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            pst.setString(1,sv_name);
	            rs = pst.executeQuery();
	            while (rs.next()) {
	            Service service = new	Service();
	            service.setSv_id(rs.getInt("sv_id"));
	            service.setSv_name(rs.getString("sv_name")) ;
	            service.setSv_company(rs.getString("sv_company"));
	            service.setSv_area_id(rs.getInt("sv_area_id"));
	            service.setSv_number(rs.getInt("sv_number"));
	            service.setSv_start_time(rs.getDate("sv_start_time"));
	            service.setSv_end_time(rs.getDate("sv_end_time"));
	            service.setSv_info(rs.getString("sv_info"));
	            service.setSv_head_id(rs.getInt("sv_head_id"));
	 
	                ServiceList.add(service);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeJDBC(rs, pst, conn);
	        }
	        return ServiceList;
	    }

	public List<Service> searchServiceAll() {
		  List<Service> ServiceList = new ArrayList<>();
	        conn = DBUtil.getConnection();// 和数据库建立连接
	        String sql = "select * from service";
	        try {
	            pst = conn.prepareStatement(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            rs = pst.executeQuery();
	            while (rs.next()) {
	            Service service = new	Service();
	            service.setSv_id(rs.getInt("sv_id"));
	            service.setSv_name(rs.getString("sv_name")) ;
	            service.setSv_company(rs.getString("sv_company"));
	            service.setSv_area_id(rs.getInt("sv_area_id"));
	            service.setSv_number(rs.getInt("sv_number"));
	            service.setSv_start_time(rs.getDate("sv_start_time"));
	            service.setSv_end_time(rs.getDate("sv_end_time"));
	            service.setSv_info(rs.getString("sv_info"));
	            service.setSv_head_id(rs.getInt("sv_head_id"));
	 
	                ServiceList.add(service);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeJDBC(rs, pst, conn);
	        }
	        return ServiceList;
	}

	public int delServiceById(int serviceID) {
		  String sql = "DELETE FROM service WHERE sv_id = ?";
	        conn = DBUtil.getConnection();  //连接数据库
	        if (conn == null) {
	            System.out.println("数据库连接失败。");
	            return 0;
	        }
	        int result = -1;
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(1, serviceID);
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

	public int updateService(Service service) {
		  int rst = -1;

	        conn = DBUtil.getConnection();
	        String sql = "update service set sv_id = " + service.getSv_id();

	        if (service.getSv_name() != null)
	            sql = sql + ",sv_name = \"" + service.getSv_name() + "\"";
	        if (service.getSv_info()!= null)
	            sql = sql + ",sv_info= \"" + service.getSv_info() + "\"";

	        sql = sql + " where sv_id = " + service.getSv_id();  //组装sql语句

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
	

