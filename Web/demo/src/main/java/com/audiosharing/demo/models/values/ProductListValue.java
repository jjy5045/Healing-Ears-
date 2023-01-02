package com.audiosharing.demo.models.values;
import java.util.Date;

import com.audiosharing.demo.models.entities.ProductList;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductListValue {
	private Long productListNoPk;
	private String productListName;
	private String productListCategory;
	private String productListLine;
	private String productListType;
	private String productListWearingType;
	private String productListCompany;
	private String productListInfoBody;
	private String productListPrice;
	private String productListRentPrice;
	private String productListReleaseDate;
	private String productListNoiseCanselling;
}
