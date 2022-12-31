package com.project.healingEars.http.vo;

import java.util.Date;

public class StationListVO {
    public int stnId;
    public String stnName;
    public String stnLatitude;
    public String stnLongitude;
    public String stnSido;
    public String stnSigungu;
    public String stnEubmyendong;
    public String stnAdressNum;
    public String stnAdressLaod;
    public String stnImageName;
    public String stnImageRealname;
    public String stnImagePath;

    public StationListVO(String stnName) {
        this.stnName = stnName;
    }
}
