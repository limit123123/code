package edu.neusoft.view;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import edu.neusoft.model.User;
//������
public class PrincipalMenu {
	
    private Scanner sc = new Scanner(System.in);

    //������һ��Ŀ¼ �����˸�Ŀ¼
    public int principalRootMenu(){
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨�����˿�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.��������       *");
        System.out.println("    *    2.�������       *");
        System.out.println("    *    3.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //�����˶���Ŀ¼ 1.��������
    public int principalAreaManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨�����˹�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.�鿴����       *");
        System.out.println("    *    2.�޸�����       *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }


    //�����˶���Ŀ¼ 2.�������
    public int adminPrincipalManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨�����˹�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.����־Ը       *");
        System.out.println("    *    2.�鿴�Լ�������־Ը       *");
//        System.out.println("    *    2.�޸�־Ը       *");
//        System.out.println("    *    3.־Ը״̬       *");
//        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }
    
}
 

