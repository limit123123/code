package edu.neusoft.test;

import edu.neusoft.dao.AreaDao;
import edu.neusoft.model.Area;

import java.util.List;
import java.util.Scanner;

public class AreaDaoTest {
    public static void main(String[] args) {
        //查询所有信息测试
//        AreaDao areaDao = new AreaDao();
//        List<Area> list = areaDao.searchAllArea();
//        for (Area area:list){
//            System.out.println(area.getAreaID() + " "+area.getAreaName() + " " + area.getAreaInfo());
//        }

        //删除区域测试
        AreaDao areaDao = new AreaDao();
        areaDao.delAreaByID(5);

        //测试添加
        Area area = new Area();
        area.setAreaName("软件园");
        area.setAreaInfo("数码广场附近");
        if (areaDao.insertArea(area) > 0)
            System.out.println("添加成功！");
    }
}
