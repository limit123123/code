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
		   System.out.print("\n===== ��������ã������ڷ����������� ====\n");
//   	    System.out.print("��������������ţ�");
//   	    int  sv_id=sc.nextInt() ;
   	    System.out.print("����������������ƣ�");
   	    String sv_name=sc.next();
   	    //��Ϊ������username
   	//   System.out.print("�������������λ��");
   	    String sv_company=i;
   	    System.out.print("������������������ţ�");
   	    int sv_area_id=sc.nextInt() ;
   	    System.out.print("�������������������");
   	    int sv_number=sc.nextInt();
   	    System.out.print("�������������ʼʱ�䣺");
   	    String sv_start_time = sc.next();
   	    System.out.print("����������������ʱ�䣺");
   	    String sv_end_time = sc.next();
   	    
   	    Date date = null;
   	    try {
   	        date = (Date) format.parse(sv_start_time);
   	        date = (Date) format.parse(sv_end_time);
   	        
   	        
   	    } catch (ParseException e) {
   	        e.printStackTrace();
   	    }
   	    System.out.print("�������������˵����");
   	    String sv_info=sc.next();
   	  //  System.out.print("������������󷢲���");
   	    int sv_head_id=q;
   	    
   	    Service service = new Service();
   	//    service.setSv_id(sv_id);
   	    service.setSv_area_id(sv_area_id);
   	    service.setSv_company(sv_company);
   	    //�������ʱ��
   	    service.setSv_end_time(new java.sql.Date(date.getTime()));
   	    service.setSv_head_id(sv_head_id);
   	    service.setSv_info(sv_info);
   	    service.setSv_name(sv_name);
   	    service.setSv_number(sv_number);
   	    service.setSv_start_time(new java.sql.Date(date.getTime()));
   	    
//   	    //����service������־Ը�߷���
   	    if (serviceService.insertService(service)>0)
   	        System.out.println("��������ӳɹ���");
   	    else
   	        System.out.println("���������ʧ�ܣ�");

   
   }


//�ú��������û�����Լ��û���������
	public void printself(String i) {
		List<Service> list=serviceService.printmyself(i);
		      
		        System.out.println("-------------------------------------");
		        System.out.println("������\t �������� \t ������������\t ���������\t ��������\t ��ʼʱ��\t ����ʱ��\t ��������˵��\t �������󷢲�");
		        System.out.println("-------------------------------------");

		        for (Service service : list) {
		            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
		        }
		    
		
		
	}



	public void searchAllAreas() {
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
	
}
