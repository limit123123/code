package edu.neusoft.view;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import edu.neusoft.model.User;
//负责人
public class PrincipalMenu {
	
    private Scanner sc = new Scanner(System.in);

    //负责人一级目录 负责人根目录
    public int principalRootMenu(){
        System.out.println("    ======================");
        System.out.println("    *   平台负责人控制中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.管理区域       *");
        System.out.println("    *    2.管理服务       *");
        System.out.println("    *    3.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //负责人二级目录 1.管理区域
    public int principalAreaManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   平台负责人管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.查看区域       *");
        System.out.println("    *    2.修改区域       *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }


    //负责人二级目录 2.管理服务
    public int adminPrincipalManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   平台负责人管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.发布志愿       *");
        System.out.println("    *    2.查看自己发布的志愿       *");
//        System.out.println("    *    2.修改志愿       *");
//        System.out.println("    *    3.志愿状态       *");
//        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }
    
}
 

