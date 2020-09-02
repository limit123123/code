package edu.neusoft.view;

import edu.neusoft.model.User;
import edu.neusoft.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private UserService userService = new UserService();
    public int startMenu(){
        System.out.println("============================");
        System.out.println("|   欢迎使用抗疫志愿者服务平台  |");
        System.out.println("============================");
        System.out.println("|   1.登录抗疫志愿者服务平台   |");
        System.out.println("|   2.注册抗疫志愿者服务平台   |");
        System.out.println("|   3.退出抗疫志愿者服务平台   |");
        System.out.println("***** copyright by SHK *****");
        System.out.print("请在上列选项中选择您要使用的功能：");
        return sc.nextInt();
    }

    public User loginMenu(){
        User user = new User();
        System.out.print("请输入用户名：");
        String userName = sc.next();
        System.out.print("请输入密码：");
        String userPassword = sc.next();
        user.setUser_username(userName);
        user.setUser_password(userPassword);
        return user;
    }
    
    public int RegistMenu(){
    	 //用户输入志愿者信息
        System.out.println("|   1.===== 您正在添加志愿者 ====|");
        System.out.println("|   2.===== 您正在添加负责人 ====|");
        System.out.print("请在上列选项中选择您要注册的类型：");
        return sc.nextInt();
    
    	
    }
}
