package edu.neusoft.control;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import edu.neusoft.model.Request;
import edu.neusoft.model.Service;
import edu.neusoft.model.User;
import edu.neusoft.service.RquestService;
import edu.neusoft.service.ServiceSerivce;
import edu.neusoft.view.PrincipalMenu;
import edu.neusoft.view.VolunteerMenu;

public class VolunterrController {
    private ServiceSerivce serviceService = new ServiceSerivce();
    private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
   // private String userName = null;
    private Scanner sc = new Scanner(System.in);
    private RquestService rs = new RquestService();
	private int user_id=10;
    
	public VolunterrController(int user_id) {
	    this.user_id=user_id;
	    VolunteerMenu vm =new VolunteerMenu();

	}
 
	



	//1.查看所有的服务，相当于listall,然后选择自己要报名的sv_id，进行报名即可
	public void getlistservice() {
		List<Service> list=serviceService.getallservice();
	      
        System.out.println("-------------------------------------");
        System.out.println("服务编号\t 服务名称 \t 需求负责人名称\t 区域名编号\t 所需人数\t 开始时间\t 结束时间\t 服务需求说明\t 服务需求发布");
        System.out.println("-------------------------------------");

        for (Service service : list) {
            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
        }
	}
	
	
        public void req(int  vid) {
        	  System.out.print("\n===== 志愿者你好，您正在申请服务 ====\n");
              System.out.print("请输入要申请的服务id：");
              int id = sc.nextInt();
              Request request = new Request();
              int x=vid;
              request.setSr_volunteer_id(x);
              request.setSr_sv_id(id);
              Date date = new Date();  
              		//把当前时间转换为sql里面的时间
              request.setSt_time(new java.sql.Date(date.getTime()));
 
              if (rs.insertRequest(request)>0)
         	        System.out.println("请求成功！");
         	    else
         	        System.out.println("请求失败！");

        }
		
	//2.查看自己报名的状态,查询request表
        public void check(int id) {
        	List<Request> list=rs.getRequestbyvtid(id);
  	      
            System.out.println("-------------------------------------");
            System.out.println("请求编号\t 志愿者id \t 服务id\t 请求时间\t 状态\t 管理员审核时间\t 管理员审核意见");
            System.out.println("-------------------------------------");

            for (Request request : list) {
                System.out.println(request.getSr_id() + " \t " + request.getSr_volunteer_id()+ " \t " + request.getSr_sv_id()+ " \t " + request.getSt_time()+ " \t " + request.getSr_status()+ " \t " + request.getSr_audio_time()+ " \t " + request.getSr_audio_info());
            }
        }
	
	//3.退出系统
}
