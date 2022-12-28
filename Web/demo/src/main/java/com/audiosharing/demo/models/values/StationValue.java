package com.audiosharing.demo.models.values;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StationValue {
	private Long stationNoPk;
	private String stationQr;
	private String stationName;
	private String stationLatitude;
	private String stationLongitude;
	private String stationSido;
	private String stationSigungu;
	private String stationEubmyendong;
	private String stationAdressNum;
	private String stationAdressLaod;
	
	private String stationServerIp;
	private String stationCreateDate;
	
	private String stationImageName;
	private String stationImageRealname;
	private String stationImagePath;
}
