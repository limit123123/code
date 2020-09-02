package edu.neusoft.service;

import edu.neusoft.dao.AreaDao;
import edu.neusoft.model.Area;

import java.util.List;

public class AreaService {
    AreaDao areaDao = new AreaDao();

    //��ѯ��������
    public List<Area> searchAllAreaS(){
        return areaDao.searchAllArea();
    }

    //��ѯ��������
    public List<Area> searchAreaByName(String areaName){
        return areaDao.searchAreaByName(areaName);
    }

    //�������
    public int insertArea(Area area) {
        return areaDao.insertArea(area);
    }

    //ɾ������
    public int delAreaById(int areaID) {
        return areaDao.delAreaByID(areaID);
    }

    //��������
    public int updateArea(Area area) {
        return areaDao.updateArea(area);
    }
}
