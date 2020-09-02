package edu.neusoft.model;

public class Area {
    /*对应数据库中Area表*/
    private int areaID;
    private String areaName;
    private String areaInfo;

    public Area() {
        super();
    }

    public Area(int areaID, String areaName, String areaInfo) {
        super();
        this.areaID = areaID;
        this.areaName = areaName;
        this.areaInfo = areaInfo;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaID=" + areaID +
                ", areaName='" + areaName + '\'' +
                ", areaInfo='" + areaInfo + '\'' +
                '}';
    }
}
