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
        System.out.println("|   ��ӭʹ�ÿ���־Ը�߷���ƽ̨  |");
        System.out.println("============================");
        System.out.println("|   1.��¼����־Ը�߷���ƽ̨   |");
        System.out.println("|   2.ע�Ό��־Ը�߷���ƽ̨   |");
        System.out.println("|   3.�˳�����־Ը�߷���ƽ̨   |");
        System.out.println("***** copyright by SHK *****");
        System.out.print("��������ѡ����ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    public User loginMenu(){
        User user = new User();
        System.out.print("�������û�����");
        String userName = sc.next();
        System.out.print("���������룺");
        String userPassword = sc.next();
        user.setUser_username(userName);
        user.setUser_password(userPassword);
        return user;
    }
    
    public int RegistMenu(){
    	 //�û�����־Ը����Ϣ
        System.out.println("|   1.===== ���������־Ը�� ====|");
        System.out.println("|   2.===== ��������Ӹ����� ====|");
        System.out.print("��������ѡ����ѡ����Ҫע������ͣ�");
        return sc.nextInt();
    
    	
    }
}
