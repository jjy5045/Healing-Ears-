package com.audiosharing.demo.models.values;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReviewValue {
	private Long reviewNoPk;
	private String reviewPurpose;
	private Integer reviewSound;	
	private Integer reviewFit;
	private Integer reviewDesign;	
	private Integer reviewIsolating;
	private String reviewDetail;
	private Date reviewCreateDate;
}
