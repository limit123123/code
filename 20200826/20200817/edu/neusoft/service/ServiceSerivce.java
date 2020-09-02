package edu.neusoft.service;

import java.util.List;

import edu.neusoft.dao.ServiceDao;
import edu.neusoft.model.Area;
import edu.neusoft.model.Service;

public class ServiceSerivce {
	
	private ServiceDao serviceDao=new ServiceDao();
	 //添加用户
	    public int insertService(Service service) {
	        return serviceDao.insertService(service);
	    }
	    
	  //查询所有自己创建的服务
		public List<Service> printmyself(String sv_company) {

		        return serviceDao.searchServiceByName(sv_company);
		    }

		public List<Service> getallservice() {
			// TODO 自动生成的方法存根
			  return serviceDao.searchServiceAll();
		}

		public int delServiceById(int serviceID) {
			  return serviceDao.delServiceById(serviceID);
		}
		
		 public List<Service> searchServiceByName(String ServiceName){
		        return serviceDao.searchServiceByName(ServiceName);
		    }
		 public List<Service> searchServiceByServiceName(String ServiceName){
		        return serviceDao.searchServiceByServiceName(ServiceName);
		    }

		public int updateService(Service service) {
			
			 return serviceDao.updateService(service);
		}
		
			
		}
		

