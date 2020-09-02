package edu.neusoft.control;

import edu.neusoft.model.Area;
import edu.neusoft.model.Request;
import edu.neusoft.model.Service;
import edu.neusoft.model.User;
import edu.neusoft.service.AreaService;
import edu.neusoft.service.RquestService;
import edu.neusoft.service.ServiceSerivce;
import edu.neusoft.service.UserService;
import edu.neusoft.view.AdminMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private enum AdminMenuStatus {ROOT_MENU, VOLUNTEER_MANGE, COMPANY_MANGE, AREA_MANAGE, SERVICE_MANAGE, EXIT, RETURN}

    ;

    private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private AdminMenuStatus adminMenuStatus = AdminMenuStatus.ROOT_MENU;
    private String userName = null;
    private AreaService areaService = new AreaService();
    private UserService userService = new UserService();
    private ServiceSerivce s = new ServiceSerivce();
    private RquestService rs=new RquestService();
    private Scanner sc = new Scanner(System.in);
    private AdminMenu adminMenu = null;

    public AdminController(String userName) {
        this.userName = userName;
        adminMenu = new AdminMenu();
    }

    public void adminController() {
        int rst = -1;

        do {
            switch (adminMenuStatus) {
                case ROOT_MENU:
                    System.out.println("");
                    rst = adminMenu.adminRootMenu();
                    if (rst == 1) adminMenuStatus = AdminMenuStatus.VOLUNTEER_MANGE;
                    else if (rst == 2) adminMenuStatus = AdminMenuStatus.COMPANY_MANGE;
                    else if (rst == 3) adminMenuStatus = AdminMenuStatus.AREA_MANAGE;
                    else if (rst == 4) adminMenuStatus = AdminMenuStatus.SERVICE_MANAGE;
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.RETURN;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("输入数据错误，请重新输入！");
                    break;
                case VOLUNTEER_MANGE:
                    rst = adminMenu.adminUserManageMenu();
                    if (rst == 1) addUser();
                    else if (rst == 2) delUser();
                    else if (rst == 3) editUser();
                    else if (rst == 4) searchUser();
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("输入数据错误，请重新输入！");
                    break;
                case COMPANY_MANGE:
                    rst = adminMenu.adminPrincipalManageMenu();
                    if (rst == 1) addPrincipal();
                    else if (rst == 2) delPrincipal();
                    else if (rst == 3) editPrincipal();
                    else if (rst == 4) searchPrincipal();
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("输入数据错误，请重新输入！");
                case AREA_MANAGE:
                    rst = adminMenu.adminAreaManageMenu();
                    if (rst == 1) addArea();
                    else if (rst == 2) delArea();
                    else if (rst == 3) editArea();
                    else if (rst == 4) searchArea();
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("输入数据错误，请重新输入！");
                    break;
                case SERVICE_MANAGE:
                	 rst = adminMenu.adminServiceManageMenu();
                	
  
                	  if (rst == 1) delService();
                      else if (rst == 2) editService();
                      else if (rst == 3) searchService();
                
                      else if (rst == 4) delRequest();
                      else if (rst == 5) editRequest();
                      else if (rst == 6) searchRequest();
                    
                      else if (rst == 7) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                      else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                      else System.out.println("输入数据错误，请重新输入！");
                      break;
                    //++
                case RETURN:
                    return;
                case EXIT:
                    System.exit(0);
            }
        } while (true);
    }
    
    
	private void searchRequest() {
		System.out.println("请输入是要全部查询（1）还是通过id查询（2）：");
		int rst=sc.nextInt();
        if (rst == 1) searchAllRequest();
            else if(rst == 2)  searchRequestByrID();
    
        else System.out.println("输入数据错误，请重新输入！");
		
	}

	private void searchRequestByrID() {
		  System.out.print("请输入要查询的请求标号（id）：");
		  int x=sc.nextInt();
		List<Request> list=rs.searchRequestByrID(x);
	      
        System.out.println("-------------------------------------");
        System.out.println("请求编号\t 志愿者id \t 服务id\t 请求时间\t 状态\t 管理员审核时间\t 管理员审核意见");
        System.out.println("-------------------------------------");

        for (Request request : list) {
            System.out.println(request.getSr_id() + " \t " + request.getSr_volunteer_id()+ " \t " + request.getSr_sv_id()+ " \t " + request.getSt_time()+ " \t " + request.getSr_status()+ " \t " + request.getSr_audio_time()+ " \t " + request.getSr_audio_info());
        }
		
	}
	private void delRequest() {
		 //显示所有的区域，供用户选择
		searchAllRequest();
	        System.out.print("请选择要删除请求的ID：");
	        //根据id删除区域
	        int RequestID = sc.nextInt();
	        if (rs.delServiceById(RequestID) > 0)
	            System.out.println("删除成功！");
	        else
	            System.out.println("删除失败");
	    }
		


	private void editRequest() {
		  //显示所请求务，供管理员选择
			searchAllRequest();
		        System.out.print("请选择要更新请求的ID：");
		        //输入需要修改的信息
		        int RequestID = sc.nextInt();
		        System.out.print("请输入更新后的请求状态(不更新输入0)：");
		        int status=sc.nextInt();
		        System.out.print("请输入更新后的请求信息(不更新输入否)：");
		        String Info = sc.next();
		        Request request = new Request();
		        request.setSr_id(RequestID);
		      	
		        if (status!=0)
		        	request.setSr_status(status);
		        if (!"否".equals(Info))
					request.setSr_audio_info(Info);
		        //调用更新的请求
		        if (rs.updateRequest(request) > 0)
		            System.out.println("更新成功！");
		        else
		            System.out.println("更新失败");
		
	}

	private void searchAllRequest() {
		List<Request> list=rs.getAllRequest();
	      
        System.out.println("-------------------------------------");
        System.out.println("请求编号\t 志愿者id \t 服务id\t 请求时间\t 状态\t 管理员审核时间\t 管理员审核意见");
        System.out.println("-------------------------------------");

        for (Request request : list) {
            System.out.println(request.getSr_id() + " \t " + request.getSr_volunteer_id()+ " \t " + request.getSr_sv_id()+ " \t " + request.getSt_time()+ " \t " + request.getSr_status()+ " \t " + request.getSr_audio_time()+ " \t " + request.getSr_audio_info());
        }
    }
		
	
	
	private void editService() {
		  //显示所有服务，供管理员选择
		searchAllService();
        System.out.print("请选择要更新服务的ID：");
        //输入需要修改的信息
        int serviceID = sc.nextInt();
        System.out.print("请输入更新后的区域名称(不更新输入否)：");
        String serviceName = sc.next();
        System.out.print("请输入更新后的区域信息(不更新输入否)：");
        String Info = sc.next();
      Service service = new  Service();
      	service.setSv_id(serviceID);
      	
        if (!"否".equals(serviceName))
        	service.setSv_name(serviceName);
        
        if (!"否".equals(Info))
			service.setSv_info(Info);

        //调用更新区域的服务
        if (s.updateService(service) > 0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败");
    }
		
	
	

	private void searchService() {
		System.out.println("请输入是要全部查询（1）还是通过name查询（2）：");
		int rst=sc.nextInt();
        if (rst == 1) searchAllService();
            else if(rst == 2)  searchServiceByName();
    
        else System.out.println("输入数据错误，请重新输入！");
    }



	private void searchServiceByName() {
		  System.out.print("请输入服务名称：");
	      String ServiceName = sc.next();
	        List<Service> list = s.searchServiceByServiceName(ServiceName);
        System.out.println("-------------------------------------");
        System.out.println("服务编号\t 服务名称 \t 需求负责人名称\t 区域名编号\t 所需人数\t 开始时间\t 结束时间\t 服务需求说明\t 服务需求发布");
        System.out.println("-------------------------------------");

        for (Service service : list) {
            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
        }
		
	}

	private void searchAllService() {
		List<Service> list=s.getallservice();
	  
        System.out.println("-------------------------------------");
        System.out.println("服务编号\t 服务名称 \t 需求负责人名称\t 区域名编号\t 所需人数\t 开始时间\t 结束时间\t 服务需求说明\t 服务需求发布");
        System.out.println("-------------------------------------");

        for (Service service : list) {
            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
        }
		
	}

	private void delService() {
		 //显示所有的区域，供用户选择
		searchAllService();
        System.out.print("请选择要删除服务的ID：");
        //根据id删除区域
        int serviceID = sc.nextInt();
        if (s.delServiceById(serviceID) > 0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败");
    }
	

	private void searchArea() {
        int rst = adminMenu.searchAreaView();
        if (rst == 1) searchAllAreas();
            else if(rst == 2)  searchAreaByName();
            //else if(rst == 3)  searchAreaByID();
        else System.out.println("输入数据错误，请重新输入！");
    }

    private void searchAllAreas() {
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

    private void searchAreaByName() {
        System.out.print("请输入区域名称：");
        String areaName = sc.next();
        List<Area> list = areaService.searchAreaByName(areaName);
        //list，打印输出所有的区域信息
        System.out.println("-------------------------------------");
        System.out.println("区域编号\t 区域名称 \t 区域信息");
        System.out.println("-------------------------------------");

        for (Area area : list) {
            System.out.println(area.getAreaID() + " \t " + area.getAreaName() + " \t " + area.getAreaInfo());
        }
    }

    private void addArea() {
        //用户输入区域信息
        System.out.print("请输入区域名称：");
        String areaName = sc.next();
        System.out.print("请输入区域信息：");
        String areaInfo = sc.next();
        Area area = new Area();
        area.setAreaName(areaName);
        area.setAreaInfo(areaInfo);
        //调用service层的添加区域方法
        if (areaService.insertArea(area) > 0)
            System.out.println("区域添加成功！");
        else
            System.out.println("区域添加失败！");
    }

    private void delArea() {
        //显示所有的区域，供用户选择
        searchAllAreas();
        System.out.print("请选择要删除区域的ID：");
        //根据id删除区域
        int areaID = sc.nextInt();
        if (areaService.delAreaById(areaID) > 0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败");
    }

    private void editArea() {
        //显示所有区域，供用户选择
        searchAllAreas();
        System.out.print("请选择要更新区域的ID：");
        //输入需要修改的信息
        int areaID = sc.nextInt();
        System.out.print("请输入更新后的区域名称(不更新输入否)：");
        String areaName = sc.next();
        System.out.print("请输入更新后的区域信息(不更新输入否)：");
        String areaInfo = sc.next();

        Area area = new Area();
        area.setAreaID(areaID);
        if (!"否".equals(areaName))
            area.setAreaName(areaName);
        if (!"否".equals(areaInfo))
            area.setAreaInfo(areaInfo);

        //调用更新区域的服务

        if (areaService.updateArea(area) > 0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败");
    }

    private void addUser() {
        //用户输入志愿者信息
        System.out.print("\n===== 您正在添加志愿者 ====\n");
        System.out.print("请输入用户姓名：");
        String userName = sc.next();
        System.out.print("请输入用户性别：");
        String userSex = sc.next();
        System.out.print("请输入用户生日：");
        String userBirthday = sc.next();
        Date date = null;
        try {
            date = (Date) format.parse(userBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("请输入用户邮箱：");
        String userEmail = sc.next();
        System.out.print("请输入用户名：");
        String userUsername = sc.next();
        System.out.print("请输入密码：");
        String userPassword = sc.next();
        User user = new User();
        user.setUser_name(userName);
        user.setUser_sex(userSex);
        user.setUser_birthday(new java.sql.Date(date.getTime()));
        user.setUser_email(userEmail);
        user.setUser_username(userUsername);
        user.setUser_password(userPassword);
        user.setUser_role(2);
        //调用service层的添加志愿者方法
        if (userService.insertUser(user) > 0)
            System.out.println("志愿者添加成功！");
        else
            System.out.println("志愿者添加失败！");
    }

    private void addPrincipal() {
        //用户输入负责人信息
        System.out.print("\n===== 您正在添加负责人 ====\n");
        System.out.print("请输入负责人姓名：");
        String principalName = sc.next();
        System.out.print("请输入负责人性别：");
        String principalSex = sc.next();
        System.out.print("请输入负责人生日：");
        String principalBirthday = sc.next();
        Date date = null;
        try {
            date = (Date) format.parse(principalBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("请输入负责人邮箱：");
        String principalEmail = sc.next();
        System.out.print("请输入用户名：");
        String principalUsername = sc.next();
        System.out.print("请输入密码：");
        String principalPassword = sc.next();
        User user = new User();
        user.setUser_name(principalName);
        user.setUser_sex(principalSex);
        user.setUser_birthday(new java.sql.Date(date.getTime()));
        user.setUser_email(principalEmail);
        user.setUser_username(principalUsername);
        user.setUser_password(principalPassword);
        user.setUser_role(1);
        //调用service层的添加志愿者方法
        if (userService.insertUser(user) > 0)
            System.out.println("负责人添加成功！");
        else
            System.out.println("负责人添加失败！");
    }

    private void searchUser() {
        int rst = adminMenu.searchUserView();
        if (rst == 1) searchAllUser();
        else System.out.println("输入数据错误，请重新输入！");
    }

    private void searchPrincipal() {
        int rst = adminMenu.searchPrincipalView();
        if (rst == 1) searchAllUser();
        else System.out.println("输入数据错误，请重新输入！");
    }

    private void searchAllUser() {
        //调用service层的查询所有志愿者
        List<User> list = userService.searchAllUser();
        //list，打印输出所有的区域信息
        System.out.println("----------------------------------------------------------------");
        System.out.println("编号\t姓名\t\t性别\t\t生日\t\t邮箱\t\t\t\t\t登录名\t\t密码");
        System.out.println("----------------------------------------------------------------");

        for (User user : list) {
            System.out.println(user.getUser_id() + "\t" + user.getUser_name() + "\t" + user.getUser_sex()
            + "\t" + user.getUser_birthday()+ "\t" +user.getUser_email()+ "\t" +user.getUser_username()
                    + "\t" +user.getUser_password());
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println();
    }

    private void delUser() {
        //显示所有的区域，供用户选择
        searchAllUser();
        System.out.print("请选择要删除的志愿者ID：");
        //根据id删除区域
        int userID = sc.nextInt();
        if (userService.delUserById(userID) > 0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败");
    }

    private void delPrincipal() {
        //显示所有的区域，供用户选择
        searchAllUser();
        System.out.print("请选择要删除的负责人ID：");
        //根据id删除区域
        int userID = sc.nextInt();
        if (userService.delUserById(userID) > 0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败");
    }

    private void editUser() {
        //显示所有志愿者，供管理员选择
        searchAllUser();
        System.out.print("请选择要更新信息的志愿者ID：");
        //输入需要修改的信息
        int userID = sc.nextInt();
        System.out.print("请输入更新后的志愿者邮箱(不更新输入否)：");
        String userEmail = sc.next();
        System.out.print("请输入更新后的志愿者密码(不更新输入否)：");
        String userPassword = sc.next();
        User user = new User();
        user.setUser_id(userID);
        if (!"否".equals(userEmail))
            user.setUser_email(userEmail);
        if (!"否".equals(userPassword))
            user.setUser_password(userPassword);
        //调用更新区域的服务
        if (userService.updateUser(user) > 0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败");
    }

    private void editPrincipal() {
        //显示所有志愿者，供管理员选择
        searchAllUser();
        System.out.print("请选择要更新信息的负责人ID：");
        //输入需要修改的信息
        int userID = sc.nextInt();
        System.out.print("请输入更新后的负责人邮箱(不更新输入否)：");
        String userEmail = sc.next();
        System.out.print("请输入更新后的负责人密码(不更新输入否)：");
        String userPassword = sc.next();
        User user = new User();
        user.setUser_id(userID);
        if (!"否".equals(userEmail))
            user.setUser_email(userEmail);
        if (!"否".equals(userPassword))
            user.setUser_password(userPassword);
        //调用更新区域的服务
        if (userService.updateUser(user) > 0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败");
    }
}