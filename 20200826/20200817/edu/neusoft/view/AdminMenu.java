package edu.neusoft.view;

import java.util.Scanner;

public class AdminMenu {
    private Scanner sc = new Scanner(System.in);

    //管理员一级目录 管理员根目录
    public int adminRootMenu(){
        System.out.println("    ======================");
        System.out.println("    *   平台管理员控制中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.管理志愿者     *");
        System.out.println("    *    2.管理负责人     *");
        System.out.println("    *    3.管理区域       *");
        System.out.println("    *    4.管理服务       *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //管理员二级目录 1.管理志愿者
    public int adminUserManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   平台志愿者管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.添加志愿者     *");
        System.out.println("    *    2.删除志愿者     *");
        System.out.println("    *    3.修改志愿者     *");
        System.out.println("    *    4.查询志愿者     *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //管理员二级目录 2.管理负责人
    public int adminPrincipalManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   平台负责人管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.添加负责人     *");
        System.out.println("    *    2.删除负责人     *");
        System.out.println("    *    3.修改负责人     *");
        System.out.println("    *    4.查询负责人     *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //管理员二级目录 3.管理区域
    public int adminAreaManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   管理员区域管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.添加区域       *");
        System.out.println("    *    2.删除区域       *");
        System.out.println("    *    3.修改区域       *");
        System.out.println("    *    4.查询区域       *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }
    //管理员二级目录 4.管理服务和请求
    public int adminServiceManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   管理员服务管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.删除服务       *");
        System.out.println("    *    2.修改服务       *");
        System.out.println("    *    3.查询服务       *");
        System.out.println("    *    4.删除请求       *");
        System.out.println("    *    5.修改请求       *");
        System.out.println("    *    6.查询请求       *");
        System.out.println("    *    7.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //管理员三级目录 3.4区域查询
    public int searchAreaView() {
        System.out.println("    ======================");
        System.out.println("    *   管理员区域管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.查询所有区域    *");
        System.out.println("    *    2.社区名称查询    *");
        System.out.println("    *    3.社区别号查询    *");
        System.out.println("    *    4.查询区域       *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //管理员三级目录 1.4志愿者查询
    public int searchUserView() {
        System.out.println("    ======================");
        System.out.println("    *   平台志愿者管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.查询所有志愿者  *");
        System.out.println("    *    2.志愿者姓名查询  *");
        System.out.println("    *    3.志愿者编号查询  *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }

    //管理员三级目录 2.4志愿者查询
    public int searchPrincipalView() {
        System.out.println("    ======================");
        System.out.println("    *   平台负责人管理中心  *");
        System.out.println("    ======================");
        System.out.println("    *    1.查询所有负责人  *");
        System.out.println("    *    2.负责人姓名查询  *");
        System.out.println("    *    3.负责人编号查询  *");
        System.out.println("    *    5.返回上级       *");
        System.out.println("    *    0.退出系统       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    请选择您要使用的功能：");
        return sc.nextInt();
    }
}
