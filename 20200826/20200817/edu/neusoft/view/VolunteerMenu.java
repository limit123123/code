package edu.neusoft.view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import edu.neusoft.service.UserService;

public class VolunteerMenu {
	  private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    private UserService userService = new UserService();
	    private Scanner sc = new Scanner(System.in);
	    public int VMenu(){
	        System.out.println("============================");
	        System.out.println("|     *   ƽ̨־Ը�߲˵�  *  |");
	        System.out.println("============================");
	        System.out.println("|   *    1.�������      *  |");
	        System.out.println("|   *    2.�鿴�Ѿ������ķ���       *   |");
	        System.out.println("|   *    0.�˳�ϵͳ       *   |");
	        System.out.println("***** copyright by SHK *****");
	        System.out.print("��������ѡ����ѡ����Ҫʹ�õĹ��ܣ�");
	        return sc.nextInt();
	    }
	
	
	
	
}
