package com.audiosharing.demo.models.values;

import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.entities.Station;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductValue {
	private Long productNoPk;
	private String productserialNumber;
	private String productCreateDate;
	private String productColor;
	private String productState;
	private ProductList productList;
	//private Station station;
	
	//private long proListId;
}
