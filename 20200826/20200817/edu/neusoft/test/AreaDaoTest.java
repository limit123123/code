package edu.neusoft.test;

import edu.neusoft.dao.AreaDao;
import edu.neusoft.model.Area;

import java.util.List;
import java.util.Scanner;

public class AreaDaoTest {
    public static void main(String[] args) {
        //��ѯ������Ϣ����
//        AreaDao areaDao = new AreaDao();
//        List<Area> list = areaDao.searchAllArea();
//        for (Area area:list){
//            System.out.println(area.getAreaID() + " "+area.getAreaName() + " " + area.getAreaInfo());
//        }

        //ɾ���������
        AreaDao areaDao = new AreaDao();
        areaDao.delAreaByID(5);

        //�������
        Area area = new Area();
        area.setAreaName("���԰");
        area.setAreaInfo("����㳡����");
        if (areaDao.insertArea(area) > 0)
            System.out.println("��ӳɹ���");
    }
}
