package edu.neusoft.service;

import java.util.List;

import edu.neusoft.dao.RequestDao;
import edu.neusoft.model.Request;

public class RquestService {
	RequestDao requestDao=	new RequestDao();

	public  int insertRequest(Request request) {
		// TODO �Զ����ɵķ������
		  return requestDao.insertRequest(request);
	}



	public  List<Request> getRequestbyvtid(int id) {
		// TODO �Զ����ɵķ������
		  return requestDao.getRequestbyvtid(id);
	}



	public int updateRequest(Request request) {
		// TODO �Զ����ɵķ������
		  return requestDao.updateRequest(request);
	}



	public List<Request> getAllRequest() {
		// TODO �Զ����ɵķ������
		  return requestDao.searchrequestAll();
	}



	public int delServiceById(int requestID) {
		// TODO �Զ����ɵķ������
		  return requestDao.delServiceById(requestID);
	}



	public List<Request> searchRequestByrID(int id) {
		// TODO �Զ����ɵķ������
		  return requestDao.searchRequestByrID(id);
	}





}
