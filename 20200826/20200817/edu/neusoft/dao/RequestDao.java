package edu.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neusoft.model.Request;
import edu.neusoft.model.Service;
import edu.neusoft.util.DBUtil;

public class RequestDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

//志愿者插入数据
	public int insertRequest(Request request) {
		  int rst = -1;
	        if (request == null)
	            rst = -1;
	        conn = DBUtil.getConnection();
	        String sql = "insert into sv_request values (null,?,?,?,1,null,null)";
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(1, request.getSr_volunteer_id());
	            pst.setInt(2,request.getSr_sv_id());
	            pst.setDate(3,request.getSt_time());
	            rst = pst.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeJDBC(rs, pst, conn);
	        }
	        return rst;
	
}

	public List<Request> getRequestbyvtid(int id) {
		// TODO 自动生成的方法存根
		List<Request> RequestList = new ArrayList<>();
        conn = DBUtil.getConnection();// 和数据库建立连接
        String sql = "select * from sv_request WHERE sr_volunteer_id= ?";
        try {
            pst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
            	Request request = new	Request();
            request.setSr_id(rs.getInt("sr_id"));
            request.setSr_volunteer_id(rs.getInt("sr_volunteer_id"));
            request.setSr_sv_id(rs.getInt("sr_sv_id"));
            request.setSt_time(rs.getDate("st_time"));
            request.setSr_status(rs.getInt("sr_status"));
            request.setSr_audio_time(rs.getDate("sr_audio_time"));
            request.setSr_audio_info(rs.getNString("sr_audio_info"));
            RequestList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return RequestList;
	}
	
//更新
	public int updateRequest(Request request) {
	    int rst = -1;

        conn = DBUtil.getConnection();
        String sql = "update sv_request set sr_id = " + request.getSr_id();

        if (request.getSr_status()!=0)
            sql = sql + ",sr_status = \"" + request.getSr_status() + "\"";
        if (request.getSr_audio_info() != null)
            sql = sql + ",sr_audio_info = \"" + request.getSr_audio_info() + "\"";

        sql = sql + " where sr_id = " + request.getSr_id();  //组装sql语句

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

	public List<Request> searchrequestAll() {
		  List<Request> RequestList = new ArrayList<>();
	        conn = DBUtil.getConnection();// 和数据库建立连接
	        String sql = "select * from sv_request";
	        try {
	            pst = conn.prepareStatement(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            rs = pst.executeQuery();
	            while (rs.next()) {
	            	Request request = new Request();
	            	request.setSr_audio_info(rs.getString("sr_audio_info"));
	            	request.setSr_audio_time(rs.getDate("sr_audio_time"));
	            	request.setSr_id(rs.getInt("sr_id"));
	            	request.setSr_status(rs.getInt("sr_status"));
	            	request.setSr_sv_id(rs.getInt("sr_sv_id"));
	            	request.setSr_volunteer_id(rs.getInt("sr_volunteer_id"));
	            	request.setSt_time(rs.getDate("st_time"));
	            	 RequestList.add(request);
	            }
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeJDBC(rs, pst, conn);
	        }
	        return  RequestList;
	}

	public int delServiceById(int requestID) {
		
		  String sql = "DELETE FROM sv_request WHERE sr_id = ?";
	        conn = DBUtil.getConnection();  //连接数据库
	        if (conn == null) {
	            System.out.println("数据库连接失败。");
	            return 0;
	        }
	        int result = -1;
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(1, requestID);
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

	public List<Request> searchRequestByrID(int id) {
		// TODO 自动生成的方法存根
		List<Request> RequestList = new ArrayList<>();
        conn = DBUtil.getConnection();// 和数据库建立连接
        String sql = "select * from sv_request WHERE sr_id= ?";
        try {
            pst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
            	Request request = new	Request();
            request.setSr_id(rs.getInt("sr_id"));
            request.setSr_volunteer_id(rs.getInt("sr_volunteer_id"));
            request.setSr_sv_id(rs.getInt("sr_sv_id"));
            request.setSt_time(rs.getDate("st_time"));
            request.setSr_status(rs.getInt("sr_status"));
            request.setSr_audio_time(rs.getDate("sr_audio_time"));
            request.setSr_audio_info(rs.getNString("sr_audio_info"));
            RequestList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return RequestList;
	}
}
