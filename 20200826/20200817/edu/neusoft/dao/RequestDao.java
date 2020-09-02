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

//־Ը�߲�������
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
		// TODO �Զ����ɵķ������
		List<Request> RequestList = new ArrayList<>();
        conn = DBUtil.getConnection();// �����ݿ⽨������
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
	
//����
	public int updateRequest(Request request) {
	    int rst = -1;

        conn = DBUtil.getConnection();
        String sql = "update sv_request set sr_id = " + request.getSr_id();

        if (request.getSr_status()!=0)
            sql = sql + ",sr_status = \"" + request.getSr_status() + "\"";
        if (request.getSr_audio_info() != null)
            sql = sql + ",sr_audio_info = \"" + request.getSr_audio_info() + "\"";

        sql = sql + " where sr_id = " + request.getSr_id();  //��װsql���

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
	        conn = DBUtil.getConnection();// �����ݿ⽨������
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
	        conn = DBUtil.getConnection();  //�������ݿ�
	        if (conn == null) {
	            System.out.println("���ݿ�����ʧ�ܡ�");
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
	            System.out.println("�����ѱ�ɾ���ɹ���");
	        } else {
	            System.out.println("����ɾ��ʧ�ܣ���δ�ҵ��й�ID������֤�����ԡ�");
	        }
	        return result;
	}

	public List<Request> searchRequestByrID(int id) {
		// TODO �Զ����ɵķ������
		List<Request> RequestList = new ArrayList<>();
        conn = DBUtil.getConnection();// �����ݿ⽨������
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
