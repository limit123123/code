package edu.neusoft.service;

import edu.neusoft.dao.AreaDao;
import edu.neusoft.model.Area;

import java.util.List;

public class AreaService {
    AreaDao areaDao = new AreaDao();

    //查询所有区域
    public List<Area> searchAllAreaS(){
        return areaDao.searchAllArea();
    }

    //查询所有区域
    public List<Area> searchAreaByName(String areaName){
        return areaDao.searchAreaByName(areaName);
    }

    //添加区域
    public int insertArea(Area area) {
        return areaDao.insertArea(area);
    }

    //删除区域
    public int delAreaById(int areaID) {
        return areaDao.delAreaByID(areaID);
    }

    //更新区域
    public int updateArea(Area area) {
        return areaDao.updateArea(area);
    }
}
