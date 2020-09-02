package edu.neusoft.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import edu.neusoft.service.AreaService;

import edu.neusoft.model.Area;
import edu.neusoft.model.Service;


import edu.neusoft.service.ServiceSerivce;
import edu.neusoft.service.UserService;
import edu.neusoft.view.PrincipalMenu;

public class CompanyController {
    private enum AdminMenuStatus {ROOT_MENU, VOLUNTEER_MANGE, COMPANY_MANGE, AREA_MANAGE, SERVICE_MANAGE, EXIT, RETURN}

    ;

    private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private AdminMenuStatus adminMenuStatus = AdminMenuStatus.ROOT_MENU;
    private String userName = null;
    private int user_id=0;
    private Scanner sc = new Scanner(System.in);
    private AreaService areaService = new AreaService();
    private ServiceSerivce serviceService = new ServiceSerivce();


    public CompanyController(String userName) {
        this.userName = userName;
        PrincipalMenu principalMenu = new  PrincipalMenu();
    }
    public CompanyController(int user_id) {
     this.user_id=user_id;
    }


  


	public void add(String i,int q) {
		   System.out.print("\n===== 负责人你好，您正在发布服务需求 ====\n");
//   	    System.out.print("请输入服务需求编号：");
//   	    int  sv_id=sc.nextInt() ;
   	    System.out.print("请输入服务需求名称：");
   	    String sv_name=sc.next();
   	    //即为负责人username
   	//   System.out.print("请输入服务需求单位：");
   	    String sv_company=i;
   	    System.out.print("请输入服务需求区域编号：");
   	    int sv_area_id=sc.nextInt() ;
   	    System.out.print("请输入服务需求人数：");
   	    int sv_number=sc.nextInt();
   	    System.out.print("请输入服务需求开始时间：");
   	    String sv_start_time = sc.next();
   	    System.out.print("请输入服务需求结束时间：");
   	    String sv_end_time = sc.next();
   	    
   	    Date date = null;
   	    try {
   	        date = (Date) format.parse(sv_start_time);
   	        date = (Date) format.parse(sv_end_time);
   	        
   	        
   	    } catch (ParseException e) {
   	        e.printStackTrace();
   	    }
   	    System.out.print("请输入服务需求说明：");
   	    String sv_info=sc.next();
   	  //  System.out.print("请输入服务需求发布：");
   	    int sv_head_id=q;
   	    
   	    Service service = new Service();
   	//    service.setSv_id(sv_id);
   	    service.setSv_area_id(sv_area_id);
   	    service.setSv_company(sv_company);
   	    //处理结束时间
   	    service.setSv_end_time(new java.sql.Date(date.getTime()));
   	    service.setSv_head_id(sv_head_id);
   	    service.setSv_info(sv_info);
   	    service.setSv_name(sv_name);
   	    service.setSv_number(sv_number);
   	    service.setSv_start_time(new java.sql.Date(date.getTime()));
   	    
//   	    //调用service层的添加志愿者方法
   	    if (serviceService.insertService(service)>0)
   	        System.out.println("服务项添加成功！");
   	    else
   	        System.out.println("服务项添加失败！");

   
   }


//该函数用于用户输出自己用户名创建的
	public void printself(String i) {
		List<Service> list=serviceService.printmyself(i);
		      
		        System.out.println("-------------------------------------");
		        System.out.println("服务编号\t 服务名称 \t 需求负责人名称\t 区域名编号\t 所需人数\t 开始时间\t 结束时间\t 服务需求说明\t 服务需求发布");
		        System.out.println("-------------------------------------");

		        for (Service service : list) {
		            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
		        }
		    
		
		
	}



	public void searchAllAreas() {
		  //调用service层的查询所有区域的服务
        List<Area> list = areaService.searchAllAreaS();
        //list，打印输出所有的区域信息
        System.out.println("-------------------------------------");
        System.out.println("区域编号\t 区域名称 \t 区域信息");
        System.out.println("-------------------------------------");

        for (Area area : list) {
            System.out.println(area.getAreaID() + " \t " + area.getAreaName() + " \t " + area.getAreaInfo());
        }
		
	}
	
}
