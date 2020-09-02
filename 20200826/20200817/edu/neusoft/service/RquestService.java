package edu.neusoft.service;

import java.util.List;

import edu.neusoft.dao.RequestDao;
import edu.neusoft.model.Request;

public class RquestService {
	RequestDao requestDao=	new RequestDao();

	public  int insertRequest(Request request) {
		// TODO 自动生成的方法存根
		  return requestDao.insertRequest(request);
	}



	public  List<Request> getRequestbyvtid(int id) {
		// TODO 自动生成的方法存根
		  return requestDao.getRequestbyvtid(id);
	}



	public int updateRequest(Request request) {
		// TODO 自动生成的方法存根
		  return requestDao.updateRequest(request);
	}



	public List<Request> getAllRequest() {
		// TODO 自动生成的方法存根
		  return requestDao.searchrequestAll();
	}



	public int delServiceById(int requestID) {
		// TODO 自动生成的方法存根
		  return requestDao.delServiceById(requestID);
	}



	public List<Request> searchRequestByrID(int id) {
		// TODO 自动生成的方法存根
		  return requestDao.searchRequestByrID(id);
	}





}
