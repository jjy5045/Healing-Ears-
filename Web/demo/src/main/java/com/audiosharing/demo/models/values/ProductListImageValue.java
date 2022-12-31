package com.audiosharing.demo.models.values;


import com.audiosharing.demo.models.entities.ProductList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductListImageValue {
	private Long productListImageNoPk;
	private String productListImageName;
	private String productListImageRealName;
	private String productListImagePath;
	private ProductList productList;
}
