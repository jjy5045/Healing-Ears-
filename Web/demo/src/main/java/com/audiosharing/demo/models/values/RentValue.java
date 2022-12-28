package com.audiosharing.demo.models.values;

import com.audiosharing.demo.models.entities.Product;
import com.audiosharing.demo.models.entities.Review;
import com.audiosharing.demo.models.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RentValue {
	private Long rentNoPk;
	private String rentStartDate;
	private String rentEndDate;
	private String rentPrice;
	private String rentDidPay;
	
	private Product product;
	private User user;
	private Review review;

}
