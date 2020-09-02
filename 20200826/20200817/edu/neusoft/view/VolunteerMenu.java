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
	        System.out.println("|     *   平台志愿者菜单  *  |");
	        System.out.println("============================");
	        System.out.println("|   *    1.申请服务      *  |");
	        System.out.println("|   *    2.查看已经报名的服务       *   |");
	        System.out.println("|   *    0.退出系统       *   |");
	        System.out.println("***** copyright by SHK *****");
	        System.out.print("请在上列选项中选择您要使用的功能：");
	        return sc.nextInt();
	    }
	
	
	
	
}
