package com.audiosharing.demo.models.values;

import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.entities.Station;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDetailValue {
	private String proDetailNumber;
	private String proDetailQR;
	private ProductList productList;
	private Station stationList;
	
	//private long proListId;
}
