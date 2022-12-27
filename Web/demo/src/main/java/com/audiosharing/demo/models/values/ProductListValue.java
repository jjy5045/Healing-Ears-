package com.audiosharing.demo.models.values;
import java.util.Date;

import com.audiosharing.demo.models.entities.ProductList;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductListValue {
	private String proListType;
	private String proListName;
	private String proListCompany;
	private String proListText;
	private String proListPrice;
	private String proListRentPrice;
	private String proListCategory;
	private Boolean proListLine;
	private String proListWearingType;
}
