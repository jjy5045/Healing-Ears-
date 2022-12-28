package com.audiosharing.demo.models.values;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StationListValue {
	private String stnName;
	private String stnLatitude;
	private String stnLongitude;
	private String stnSido;
	private String stnSigungu;
	private String stnEubmyendong;
	private String stnAdressNum;
	private String stnAdressLaod;
	private String stnImageName;
	private String stnImageRealname;
	private String stnImagePath;
}
