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
                    else System.out.println("�������ݴ������������룡");
                    break;
                case VOLUNTEER_MANGE:
                    rst = adminMenu.adminUserManageMenu();
                    if (rst == 1) addUser();
                    else if (rst == 2) delUser();
                    else if (rst == 3) editUser();
                    else if (rst == 4) searchUser();
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("�������ݴ������������룡");
                    break;
                case COMPANY_MANGE:
                    rst = adminMenu.adminPrincipalManageMenu();
                    if (rst == 1) addPrincipal();
                    else if (rst == 2) delPrincipal();
                    else if (rst == 3) editPrincipal();
                    else if (rst == 4) searchPrincipal();
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("�������ݴ������������룡");
                case AREA_MANAGE:
                    rst = adminMenu.adminAreaManageMenu();
                    if (rst == 1) addArea();
                    else if (rst == 2) delArea();
                    else if (rst == 3) editArea();
                    else if (rst == 4) searchArea();
                    else if (rst == 5) adminMenuStatus = AdminMenuStatus.ROOT_MENU;
                    else if (rst == 0) adminMenuStatus = AdminMenuStatus.EXIT;
                    else System.out.println("�������ݴ������������룡");
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
                      else System.out.println("�������ݴ������������룡");
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
		System.out.println("��������Ҫȫ����ѯ��1������ͨ��id��ѯ��2����");
		int rst=sc.nextInt();
        if (rst == 1) searchAllRequest();
            else if(rst == 2)  searchRequestByrID();
    
        else System.out.println("�������ݴ������������룡");
		
	}

	private void searchRequestByrID() {
		  System.out.print("������Ҫ��ѯ�������ţ�id����");
		  int x=sc.nextInt();
		List<Request> list=rs.searchRequestByrID(x);
	      
        System.out.println("-------------------------------------");
        System.out.println("������\t ־Ը��id \t ����id\t ����ʱ��\t ״̬\t ����Ա���ʱ��\t ����Ա������");
        System.out.println("-------------------------------------");

        for (Request request : list) {
            System.out.println(request.getSr_id() + " \t " + request.getSr_volunteer_id()+ " \t " + request.getSr_sv_id()+ " \t " + request.getSt_time()+ " \t " + request.getSr_status()+ " \t " + request.getSr_audio_time()+ " \t " + request.getSr_audio_info());
        }
		
	}
	private void delRequest() {
		 //��ʾ���е����򣬹��û�ѡ��
		searchAllRequest();
	        System.out.print("��ѡ��Ҫɾ�������ID��");
	        //����idɾ������
	        int RequestID = sc.nextInt();
	        if (rs.delServiceById(RequestID) > 0)
	            System.out.println("ɾ���ɹ���");
	        else
	            System.out.println("ɾ��ʧ��");
	    }
		


	private void editRequest() {
		  //��ʾ�������񣬹�����Աѡ��
			searchAllRequest();
		        System.out.print("��ѡ��Ҫ���������ID��");
		        //������Ҫ�޸ĵ���Ϣ
		        int RequestID = sc.nextInt();
		        System.out.print("��������º������״̬(����������0)��");
		        int status=sc.nextInt();
		        System.out.print("��������º��������Ϣ(�����������)��");
		        String Info = sc.next();
		        Request request = new Request();
		        request.setSr_id(RequestID);
		      	
		        if (status!=0)
		        	request.setSr_status(status);
		        if (!"��".equals(Info))
					request.setSr_audio_info(Info);
		        //���ø��µ�����
		        if (rs.updateRequest(request) > 0)
		            System.out.println("���³ɹ���");
		        else
		            System.out.println("����ʧ��");
		
	}

	private void searchAllRequest() {
		List<Request> list=rs.getAllRequest();
	      
        System.out.println("-------------------------------------");
        System.out.println("������\t ־Ը��id \t ����id\t ����ʱ��\t ״̬\t ����Ա���ʱ��\t ����Ա������");
        System.out.println("-------------------------------------");

        for (Request request : list) {
            System.out.println(request.getSr_id() + " \t " + request.getSr_volunteer_id()+ " \t " + request.getSr_sv_id()+ " \t " + request.getSt_time()+ " \t " + request.getSr_status()+ " \t " + request.getSr_audio_time()+ " \t " + request.getSr_audio_info());
        }
    }
		
	
	
	private void editService() {
		  //��ʾ���з��񣬹�����Աѡ��
		searchAllService();
        System.out.print("��ѡ��Ҫ���·����ID��");
        //������Ҫ�޸ĵ���Ϣ
        int serviceID = sc.nextInt();
        System.out.print("��������º����������(�����������)��");
        String serviceName = sc.next();
        System.out.print("��������º��������Ϣ(�����������)��");
        String Info = sc.next();
      Service service = new  Service();
      	service.setSv_id(serviceID);
      	
        if (!"��".equals(serviceName))
        	service.setSv_name(serviceName);
        
        if (!"��".equals(Info))
			service.setSv_info(Info);

        //���ø�������ķ���
        if (s.updateService(service) > 0)
            System.out.println("���³ɹ���");
        else
            System.out.println("����ʧ��");
    }
		
	
	

	private void searchService() {
		System.out.println("��������Ҫȫ����ѯ��1������ͨ��name��ѯ��2����");
		int rst=sc.nextInt();
        if (rst == 1) searchAllService();
            else if(rst == 2)  searchServiceByName();
    
        else System.out.println("�������ݴ������������룡");
    }



	private void searchServiceByName() {
		  System.out.print("������������ƣ�");
	      String ServiceName = sc.next();
	        List<Service> list = s.searchServiceByServiceName(ServiceName);
        System.out.println("-------------------------------------");
        System.out.println("������\t �������� \t ������������\t ���������\t ��������\t ��ʼʱ��\t ����ʱ��\t ��������˵��\t �������󷢲�");
        System.out.println("-------------------------------------");

        for (Service service : list) {
            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
        }
		
	}

	private void searchAllService() {
		List<Service> list=s.getallservice();
	  
        System.out.println("-------------------------------------");
        System.out.println("������\t �������� \t ������������\t ���������\t ��������\t ��ʼʱ��\t ����ʱ��\t ��������˵��\t �������󷢲�");
        System.out.println("-------------------------------------");

        for (Service service : list) {
            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
        }
		
	}

	private void delService() {
		 //��ʾ���е����򣬹��û�ѡ��
		searchAllService();
        System.out.print("��ѡ��Ҫɾ�������ID��");
        //����idɾ������
        int serviceID = sc.nextInt();
        if (s.delServiceById(serviceID) > 0)
            System.out.println("ɾ���ɹ���");
        else
            System.out.println("ɾ��ʧ��");
    }
	

	private void searchArea() {
        int rst = adminMenu.searchAreaView();
        if (rst == 1) searchAllAreas();
            else if(rst == 2)  searchAreaByName();
            //else if(rst == 3)  searchAreaByID();
        else System.out.println("�������ݴ������������룡");
    }

    private void searchAllAreas() {
        //����service��Ĳ�ѯ��������ķ���
        List<Area> list = areaService.searchAllAreaS();
        //list����ӡ������е�������Ϣ
        System.out.println("-------------------------------------");
        System.out.println("������\t �������� \t ������Ϣ");
        System.out.println("-------------------------------------");

        for (Area area : list) {
            System.out.println(area.getAreaID() + " \t " + area.getAreaName() + " \t " + area.getAreaInfo());
        }
    }

    private void searchAreaByName() {
        System.out.print("�������������ƣ�");
        String areaName = sc.next();
        List<Area> list = areaService.searchAreaByName(areaName);
        //list����ӡ������е�������Ϣ
        System.out.println("-------------------------------------");
        System.out.println("������\t �������� \t ������Ϣ");
        System.out.println("-------------------------------------");

        for (Area area : list) {
            System.out.println(area.getAreaID() + " \t " + area.getAreaName() + " \t " + area.getAreaInfo());
        }
    }

    private void addArea() {
        //�û�����������Ϣ
        System.out.print("�������������ƣ�");
        String areaName = sc.next();
        System.out.print("������������Ϣ��");
        String areaInfo = sc.next();
        Area area = new Area();
        area.setAreaName(areaName);
        area.setAreaInfo(areaInfo);
        //����service���������򷽷�
        if (areaService.insertArea(area) > 0)
            System.out.println("������ӳɹ���");
        else
            System.out.println("�������ʧ�ܣ�");
    }

    private void delArea() {
        //��ʾ���е����򣬹��û�ѡ��
        searchAllAreas();
        System.out.print("��ѡ��Ҫɾ�������ID��");
        //����idɾ������
        int areaID = sc.nextInt();
        if (areaService.delAreaById(areaID) > 0)
            System.out.println("ɾ���ɹ���");
        else
            System.out.println("ɾ��ʧ��");
    }

    private void editArea() {
        //��ʾ�������򣬹��û�ѡ��
        searchAllAreas();
        System.out.print("��ѡ��Ҫ���������ID��");
        //������Ҫ�޸ĵ���Ϣ
        int areaID = sc.nextInt();
        System.out.print("��������º����������(�����������)��");
        String areaName = sc.next();
        System.out.print("��������º��������Ϣ(�����������)��");
        String areaInfo = sc.next();

        Area area = new Area();
        area.setAreaID(areaID);
        if (!"��".equals(areaName))
            area.setAreaName(areaName);
        if (!"��".equals(areaInfo))
            area.setAreaInfo(areaInfo);

        //���ø�������ķ���

        if (areaService.updateArea(area) > 0)
            System.out.println("���³ɹ���");
        else
            System.out.println("����ʧ��");
    }

    private void addUser() {
        //�û�����־Ը����Ϣ
        System.out.print("\n===== ���������־Ը�� ====\n");
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
        System.out.print("�������û�����");
        String userUsername = sc.next();
        System.out.print("���������룺");
        String userPassword = sc.next();
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

    private void addPrincipal() {
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
        System.out.print("�������û�����");
        String principalUsername = sc.next();
        System.out.print("���������룺");
        String principalPassword = sc.next();
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

    private void searchUser() {
        int rst = adminMenu.searchUserView();
        if (rst == 1) searchAllUser();
        else System.out.println("�������ݴ������������룡");
    }

    private void searchPrincipal() {
        int rst = adminMenu.searchPrincipalView();
        if (rst == 1) searchAllUser();
        else System.out.println("�������ݴ������������룡");
    }

    private void searchAllUser() {
        //����service��Ĳ�ѯ����־Ը��
        List<User> list = userService.searchAllUser();
        //list����ӡ������е�������Ϣ
        System.out.println("----------------------------------------------------------------");
        System.out.println("���\t����\t\t�Ա�\t\t����\t\t����\t\t\t\t\t��¼��\t\t����");
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
        //��ʾ���е����򣬹��û�ѡ��
        searchAllUser();
        System.out.print("��ѡ��Ҫɾ����־Ը��ID��");
        //����idɾ������
        int userID = sc.nextInt();
        if (userService.delUserById(userID) > 0)
            System.out.println("ɾ���ɹ���");
        else
            System.out.println("ɾ��ʧ��");
    }

    private void delPrincipal() {
        //��ʾ���е����򣬹��û�ѡ��
        searchAllUser();
        System.out.print("��ѡ��Ҫɾ���ĸ�����ID��");
        //����idɾ������
        int userID = sc.nextInt();
        if (userService.delUserById(userID) > 0)
            System.out.println("ɾ���ɹ���");
        else
            System.out.println("ɾ��ʧ��");
    }

    private void editUser() {
        //��ʾ����־Ը�ߣ�������Աѡ��
        searchAllUser();
        System.out.print("��ѡ��Ҫ������Ϣ��־Ը��ID��");
        //������Ҫ�޸ĵ���Ϣ
        int userID = sc.nextInt();
        System.out.print("��������º��־Ը������(�����������)��");
        String userEmail = sc.next();
        System.out.print("��������º��־Ը������(�����������)��");
        String userPassword = sc.next();
        User user = new User();
        user.setUser_id(userID);
        if (!"��".equals(userEmail))
            user.setUser_email(userEmail);
        if (!"��".equals(userPassword))
            user.setUser_password(userPassword);
        //���ø�������ķ���
        if (userService.updateUser(user) > 0)
            System.out.println("���³ɹ���");
        else
            System.out.println("����ʧ��");
    }

    private void editPrincipal() {
        //��ʾ����־Ը�ߣ�������Աѡ��
        searchAllUser();
        System.out.print("��ѡ��Ҫ������Ϣ�ĸ�����ID��");
        //������Ҫ�޸ĵ���Ϣ
        int userID = sc.nextInt();
        System.out.print("��������º�ĸ���������(�����������)��");
        String userEmail = sc.next();
        System.out.print("��������º�ĸ���������(�����������)��");
        String userPassword = sc.next();
        User user = new User();
        user.setUser_id(userID);
        if (!"��".equals(userEmail))
            user.setUser_email(userEmail);
        if (!"��".equals(userPassword))
            user.setUser_password(userPassword);
        //���ø�������ķ���
        if (userService.updateUser(user) > 0)
            System.out.println("���³ɹ���");
        else
            System.out.println("����ʧ��");
    }
}