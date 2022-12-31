package com.audiosharing.demo.models.values;

import com.audiosharing.demo.models.entities.Product;
import com.audiosharing.demo.models.entities.Station;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StationDockValue {
	private Long stationDockNoPk;
	private String stationDockName;
	private String stationDockQr;
	private Station station;
	private Product product;
}
