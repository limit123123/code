package edu.neusoft.control;
import edu.neusoft.model.User;
import edu.neusoft.service.AreaService;
import edu.neusoft.service.UserService;
import edu.neusoft.view.Menu;
import edu.neusoft.view.PrincipalMenu;
import edu.neusoft.view.VolunteerMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainController {
    public enum UserStatus{INIT,LOGIN,REGIST,ADMIN,VOLUNTEER,COMPANY,EXIT}; //用户状态

    private UserStatus userStatus = UserStatus.INIT;
    private Menu menu = new Menu();
    private PrincipalMenu pm =new PrincipalMenu();
    private VolunteerMenu vm =new VolunteerMenu();
    private UserService userService = new UserService();
    private AdminController adminController = null;
    private CompanyController companyController = null;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private String userName = null;
    private AreaService areaService = new AreaService();
    private Scanner sc = new Scanner(System.in);


    //构造方法
    public MainController() {
        userStatus = UserStatus.INIT;
    }

    public void mainController() throws ParseException {
        User user = new User();
      
        
        int rst = 0;
        do {
            switch(userStatus) {
                case INIT:
                    rst = menu.startMenu();  //显示欢迎界面，返回用户选择
                    if(rst == 1) userStatus = UserStatus.LOGIN;
                    else if(rst == 2) userStatus = UserStatus.REGIST;
                    else if(rst == 3) userStatus = UserStatus.EXIT;
                    else System.out.println("数据不合法，请重新输入！");
                    break;
                case LOGIN:
                    user = menu.loginMenu(); //显示登录界面，获取用户信息（用户名和密码）
                    int userRole = getUserRole(user);  //获取用户角色
                    if(userRole == 0)
                        userStatus = UserStatus.ADMIN;
                    else if(userRole == 1)
                        userStatus = UserStatus.COMPANY;
                    else if(userRole == 2)
                        userStatus = UserStatus.VOLUNTEER;
                    else
                        System.out.println("用户名或密码错误，请重新输入！");
                    break;
                case REGIST:
                	  rst = menu.RegistMenu();  //显示注册界面，返回用户选择
                	  if(rst == 1) 
                		  	//1注册志愿者
                			
                  		  	addUser();
                		  
                		
                	 
                      else if(rst == 2) 
                    	  //2注册负责人
                  
                	  addPrincipal();
                	  break;

                case ADMIN:
                    adminController = new AdminController(user.getUser_username());
                    adminController.adminController();
              
                    break;
                case COMPANY://负责人
//                	1.获取当前用户id
                	
               CompanyController companyController = new CompanyController(user.getUser_username());
               rst=pm.adminPrincipalManageMenu();
               String i=user.getUser_username();
              
               if(rst == 1) {
            		  //1发布需求信息
            	   //发布之前打印所有的地区信息
            	   companyController.searchAllAreas();
            	
            	   int q=user.getUser_id();
            	   //得到当前用户的username
            		companyController.add(i,q); 
               }
               else if(rst == 2) {
            		  //2打印自己发布内容
            	   System.out.println("打印自己发布内容");
            	   companyController.printself(i);
               }
                 
               else if(rst == 0) {
            	    	   System.exit(0);
            	     }
                      break;
                	
                	

                case VOLUNTEER://志愿者
                	
            	VolunterrController volunterrController = new VolunterrController(user.getUser_id());
            	int m=user.getUser_id();
                	rst=vm.VMenu();
                	 if(rst == 1) {
                		//1.查看所有的服务，相当于listall,然后选择自己要报名的sv_id，进行报名即可
               	   System.out.println(m);
	               	volunterrController.getlistservice();
	               	volunterrController.req(m);
                  }
                  else if(rst == 2) {
               		  //2打印自己报名的信息
                	   volunterrController.check(m);
                  }
                  else if(rst == 0) {
               	    	   System.exit(0);
               	     }
                      break;
                	
                	

                case EXIT: 
                    System.out.println("您已退出系统，欢迎下次登录！");
                    System.exit(0);
            }

        }while(true);
    }

    private int getUserRole(User user) {
        return userService.getUserRoleS(user);
    }
    private int dist(String name) {
    	return userService.getdist(name);
    }
    private void addPrincipal() {
    	 System.out.print("请输入用户名：");
         String principalUsername = sc.next();
         if( dist(principalUsername)==0) {
        	System.out.println("该用户名已存在，换一个吧！");
         }
         else {
        	 
             System.out.print("请输入密码：");
             String principalPassword = sc.next();
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
     
    }
    private void addUser() {
    	
        //用户输入志愿者信息
        System.out.print("\n===== 您正在添加志愿者 ====\n");
    	 System.out.print("请输入用户名：");
         String userUsername = sc.next();
     
         if( dist(userUsername)==0) {
         	System.out.println("该用户名已存在，换一个吧！");
          }
         else {
        	    System.out.print("请输入密码：");
                String userPassword = sc.next();
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
   
    }
    
}
