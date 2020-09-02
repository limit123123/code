package edu.neusoft.view;

import java.util.Scanner;

public class AdminMenu {
    private Scanner sc = new Scanner(System.in);

    //����Աһ��Ŀ¼ ����Ա��Ŀ¼
    public int adminRootMenu(){
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨����Ա��������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.����־Ը��     *");
        System.out.println("    *    2.��������     *");
        System.out.println("    *    3.��������       *");
        System.out.println("    *    4.�������       *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //����Ա����Ŀ¼ 1.����־Ը��
    public int adminUserManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨־Ը�߹�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.���־Ը��     *");
        System.out.println("    *    2.ɾ��־Ը��     *");
        System.out.println("    *    3.�޸�־Ը��     *");
        System.out.println("    *    4.��ѯ־Ը��     *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //����Ա����Ŀ¼ 2.��������
    public int adminPrincipalManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨�����˹�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.��Ӹ�����     *");
        System.out.println("    *    2.ɾ��������     *");
        System.out.println("    *    3.�޸ĸ�����     *");
        System.out.println("    *    4.��ѯ������     *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //����Ա����Ŀ¼ 3.��������
    public int adminAreaManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   ����Ա�����������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.�������       *");
        System.out.println("    *    2.ɾ������       *");
        System.out.println("    *    3.�޸�����       *");
        System.out.println("    *    4.��ѯ����       *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }
    //����Ա����Ŀ¼ 4.������������
    public int adminServiceManageMenu() {
        System.out.println("    ======================");
        System.out.println("    *   ����Ա�����������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.ɾ������       *");
        System.out.println("    *    2.�޸ķ���       *");
        System.out.println("    *    3.��ѯ����       *");
        System.out.println("    *    4.ɾ������       *");
        System.out.println("    *    5.�޸�����       *");
        System.out.println("    *    6.��ѯ����       *");
        System.out.println("    *    7.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //����Ա����Ŀ¼ 3.4�����ѯ
    public int searchAreaView() {
        System.out.println("    ======================");
        System.out.println("    *   ����Ա�����������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.��ѯ��������    *");
        System.out.println("    *    2.�������Ʋ�ѯ    *");
        System.out.println("    *    3.������Ų�ѯ    *");
        System.out.println("    *    4.��ѯ����       *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //����Ա����Ŀ¼ 1.4־Ը�߲�ѯ
    public int searchUserView() {
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨־Ը�߹�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.��ѯ����־Ը��  *");
        System.out.println("    *    2.־Ը��������ѯ  *");
        System.out.println("    *    3.־Ը�߱�Ų�ѯ  *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }

    //����Ա����Ŀ¼ 2.4־Ը�߲�ѯ
    public int searchPrincipalView() {
        System.out.println("    ======================");
        System.out.println("    *   ƽ̨�����˹�������  *");
        System.out.println("    ======================");
        System.out.println("    *    1.��ѯ���и�����  *");
        System.out.println("    *    2.������������ѯ  *");
        System.out.println("    *    3.�����˱�Ų�ѯ  *");
        System.out.println("    *    5.�����ϼ�       *");
        System.out.println("    *    0.�˳�ϵͳ       *");
        System.out.println("    ** copyright by SHK **");
        System.out.print("    ��ѡ����Ҫʹ�õĹ��ܣ�");
        return sc.nextInt();
    }
}
