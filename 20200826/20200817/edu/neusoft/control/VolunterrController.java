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
 
	



	//1.�鿴���еķ����൱��listall,Ȼ��ѡ���Լ�Ҫ������sv_id�����б�������
	public void getlistservice() {
		List<Service> list=serviceService.getallservice();
	      
        System.out.println("-------------------------------------");
        System.out.println("������\t �������� \t ������������\t ���������\t ��������\t ��ʼʱ��\t ����ʱ��\t ��������˵��\t �������󷢲�");
        System.out.println("-------------------------------------");

        for (Service service : list) {
            System.out.println(service.getSv_id() + " \t " + service.getSv_name()+ " \t " + service.getSv_company()+ " \t " + service.getSv_area_id()+ " \t " + service.getSv_number()+ " \t " + service.getSv_start_time()+ " \t " + service.getSv_end_time()+ " \t " + service.getSv_info()+ " \t " + service.getSv_head_id());
        }
	}
	
	
        public void req(int  vid) {
        	  System.out.print("\n===== ־Ը����ã�������������� ====\n");
              System.out.print("������Ҫ����ķ���id��");
              int id = sc.nextInt();
              Request request = new Request();
              int x=vid;
              request.setSr_volunteer_id(x);
              request.setSr_sv_id(id);
              Date date = new Date();  
              		//�ѵ�ǰʱ��ת��Ϊsql�����ʱ��
              request.setSt_time(new java.sql.Date(date.getTime()));
 
              if (rs.insertRequest(request)>0)
         	        System.out.println("����ɹ���");
         	    else
         	        System.out.println("����ʧ�ܣ�");

        }
		
	//2.�鿴�Լ�������״̬,��ѯrequest��
        public void check(int id) {
        	List<Request> list=rs.getRequestbyvtid(id);
  	      
            System.out.println("-------------------------------------");
            System.out.println("������\t ־Ը��id \t ����id\t ����ʱ��\t ״̬\t ����Ա���ʱ��\t ����Ա������");
            System.out.println("-------------------------------------");

            for (Request request : list) {
                System.out.println(request.getSr_id() + " \t " + request.getSr_volunteer_id()+ " \t " + request.getSr_sv_id()+ " \t " + request.getSt_time()+ " \t " + request.getSr_status()+ " \t " + request.getSr_audio_time()+ " \t " + request.getSr_audio_info());
            }
        }
	
	//3.�˳�ϵͳ
}
