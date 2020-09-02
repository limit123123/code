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
    public enum UserStatus{INIT,LOGIN,REGIST,ADMIN,VOLUNTEER,COMPANY,EXIT}; //�û�״̬

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


    //���췽��
    public MainController() {
        userStatus = UserStatus.INIT;
    }

    public void mainController() throws ParseException {
        User user = new User();
      
        
        int rst = 0;
        do {
            switch(userStatus) {
                case INIT:
                    rst = menu.startMenu();  //��ʾ��ӭ���棬�����û�ѡ��
                    if(rst == 1) userStatus = UserStatus.LOGIN;
                    else if(rst == 2) userStatus = UserStatus.REGIST;
                    else if(rst == 3) userStatus = UserStatus.EXIT;
                    else System.out.println("���ݲ��Ϸ������������룡");
                    break;
                case LOGIN:
                    user = menu.loginMenu(); //��ʾ��¼���棬��ȡ�û���Ϣ���û��������룩
                    int userRole = getUserRole(user);  //��ȡ�û���ɫ
                    if(userRole == 0)
                        userStatus = UserStatus.ADMIN;
                    else if(userRole == 1)
                        userStatus = UserStatus.COMPANY;
                    else if(userRole == 2)
                        userStatus = UserStatus.VOLUNTEER;
                    else
                        System.out.println("�û���������������������룡");
                    break;
                case REGIST:
                	  rst = menu.RegistMenu();  //��ʾע����棬�����û�ѡ��
                	  if(rst == 1) 
                		  	//1ע��־Ը��
                			
                  		  	addUser();
                		  
                		
                	 
                      else if(rst == 2) 
                    	  //2ע�Ḻ����
                  
                	  addPrincipal();
                	  break;

                case ADMIN:
                    adminController = new AdminController(user.getUser_username());
                    adminController.adminController();
              
                    break;
                case COMPANY://������
//                	1.��ȡ��ǰ�û�id
                	
               CompanyController companyController = new CompanyController(user.getUser_username());
               rst=pm.adminPrincipalManageMenu();
               String i=user.getUser_username();
              
               if(rst == 1) {
            		  //1����������Ϣ
            	   //����֮ǰ��ӡ���еĵ�����Ϣ
            	   companyController.searchAllAreas();
            	
            	   int q=user.getUser_id();
            	   //�õ���ǰ�û���username
            		companyController.add(i,q); 
               }
               else if(rst == 2) {
            		  //2��ӡ�Լ���������
            	   System.out.println("��ӡ�Լ���������");
            	   companyController.printself(i);
               }
                 
               else if(rst == 0) {
            	    	   System.exit(0);
            	     }
                      break;
                	
                	

                case VOLUNTEER://־Ը��
                	
            	VolunterrController volunterrController = new VolunterrController(user.getUser_id());
            	int m=user.getUser_id();
                	rst=vm.VMenu();
                	 if(rst == 1) {
                		//1.�鿴���еķ����൱��listall,Ȼ��ѡ���Լ�Ҫ������sv_id�����б�������
               	   System.out.println(m);
	               	volunterrController.getlistservice();
	               	volunterrController.req(m);
                  }
                  else if(rst == 2) {
               		  //2��ӡ�Լ���������Ϣ
                	   volunterrController.check(m);
                  }
                  else if(rst == 0) {
               	    	   System.exit(0);
               	     }
                      break;
                	
                	

                case EXIT: 
                    System.out.println("�����˳�ϵͳ����ӭ�´ε�¼��");
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
    	 System.out.print("�������û�����");
         String principalUsername = sc.next();
         if( dist(principalUsername)==0) {
        	System.out.println("���û����Ѵ��ڣ���һ���ɣ�");
         }
         else {
        	 
             System.out.print("���������룺");
             String principalPassword = sc.next();
            //�û����븺������Ϣ
            System.out.print("\n===== ��������Ӹ����� ====\n");
            System.out.print("�����븺����������");
            String principalName = sc.next();
            System.out.print("�����븺�����Ա�");
            String principalSex = sc.next();
            System.out.print("�����븺�������գ�");
            String principalBirthday = sc.next();
            Date date = null;
            try {
                date = (Date) format.parse(principalBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.print("�����븺�������䣺");
            String principalEmail = sc.next();
            User user = new User();
            user.setUser_name(principalName);
            user.setUser_sex(principalSex);
            user.setUser_birthday(new java.sql.Date(date.getTime()));
            user.setUser_email(principalEmail);
            user.setUser_username(principalUsername);
            user.setUser_password(principalPassword);
            user.setUser_role(1);
            //����service������־Ը�߷���
            if (userService.insertUser(user) > 0)
                System.out.println("��������ӳɹ���");
            else
                System.out.println("���������ʧ�ܣ�");
         }
     
    }
    private void addUser() {
    	
        //�û�����־Ը����Ϣ
        System.out.print("\n===== ���������־Ը�� ====\n");
    	 System.out.print("�������û�����");
         String userUsername = sc.next();
     
         if( dist(userUsername)==0) {
         	System.out.println("���û����Ѵ��ڣ���һ���ɣ�");
          }
         else {
        	    System.out.print("���������룺");
                String userPassword = sc.next();
             System.out.print("�������û�������");
             String userName = sc.next();
             System.out.print("�������û��Ա�");
             String userSex = sc.next();
             System.out.print("�������û����գ�");
             String userBirthday = sc.next();
             Date date = null;
             try {
                 date = (Date) format.parse(userBirthday);
             } catch (ParseException e) {
                 e.printStackTrace();
             }
             System.out.print("�������û����䣺");
             String userEmail = sc.next();
            
             User user = new User();
             user.setUser_name(userName);
             user.setUser_sex(userSex);
             user.setUser_birthday(new java.sql.Date(date.getTime()));
             user.setUser_email(userEmail);
             user.setUser_username(userUsername);
             user.setUser_password(userPassword);
             user.setUser_role(2);
             //����service������־Ը�߷���
             if (userService.insertUser(user) > 0)
                 System.out.println("־Ը����ӳɹ���");
             else
                 System.out.println("־Ը�����ʧ�ܣ�");
         }
   
    }
    
}
