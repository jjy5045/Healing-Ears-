package com.audiosharing.demo.models.values;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRentValue {
	private Long rentId;
	private String rentTime;
	private String rentPayment;
	private String rentAdditionalPayment;
	private String rentReviewSound;
	private String rentReviewDesign;
	private String rentReviewFit;
	private String rentReviewBody;
	private User user;
	private ProductDetail productDetail;

}
