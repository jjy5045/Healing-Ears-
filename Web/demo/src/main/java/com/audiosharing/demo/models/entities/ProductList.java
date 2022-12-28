package com.audiosharing.demo.models.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
@Table(name = "PRODUCT_LIST_TB")
@DynamicUpdate
@DynamicInsert
public class ProductList implements Serializable {
	//제품 목록 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long productListNoPk;
	
	// 제품 이름
	@Column(nullable = false, length = 30)
	private String productListName;
	
	// 제품 카테고리
	@Column(nullable = false, length = 20)
	private String productListCategory;
	
	// 제품 유무선
	@Column(nullable = false, length = 5)
	private String productListLine;

	// 제품 타입
	@Column(nullable = false, length = 5)
	private String productListType;
	
	// 제품 착용방식
	@Column(nullable = false, length = 5)
	private String productListWearingType;
	
	//제품 회사
	@Column(nullable = false, length = 20)
	private String productListCompany;
	
	//제품 설명
	@Column(nullable = false, length = 200)
	private String productListInfoBody;
	
	//제품 가격
	@Column(nullable = false, length = 10)
	private String productListPrice;
	
	//제품 이용 가격
	@Column(nullable = false, length = 10)
	private String productListRentPrice;
	
	//제품 개별 등록 날짜
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date productListDate;
	
	@PrePersist
	protected void onCreate() {
		productListDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	
	
	@Builder
	public ProductList(String productListName, String productListCategory, String productListLine, 
			String productListType, String productListWearingType, String productListCompany, 
			String productListInfoBody, String productListPrice, String productListRentPrice) {
		this.productListName = productListName;
		this.productListCategory = productListCategory;
		this.productListLine = productListLine;
		this.productListType = productListType;
		this.productListWearingType = productListWearingType;
		this.productListCompany = productListCompany;
		this.productListInfoBody= productListInfoBody;
		this.productListPrice = productListPrice;
		this.productListRentPrice = productListRentPrice;
	}
	/*
	@OneToMany(mappedBy = "productList")
	private List<ProductDetail> productDetails = new ArrayList<>();
	*/
	
	/*
	private void addProductDetails(ProductDetail productDetail) {
		this.productDetails.add(productDetail);
	}
	*/
	
}
