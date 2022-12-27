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
@Table(name = "product_list")
@DynamicUpdate
@DynamicInsert
public class ProductList implements Serializable {
	//제품 목록 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long proListId;
	
	// 제품 이름
	@Column(nullable = false, length = 30)
	private String proListName;
	
	// 제품 카테고리
	@Column(nullable = false, length = 10)
	private String proListCategory;
	
	// 제품 유무선
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private Boolean proListLine;

	// 제품 타입
	@Column(nullable = false, length = 5)
	private String proListType;
	
	// 제품 착용방식
	@Column(nullable = false, length = 5)
	private String proListWearingType;
	
	//제품 회사
	@Column(nullable = false, length = 20)
	private String proListCompany;
	
	//제품 설명
	@Column(nullable = false, length = 200)
	private String proListText;
	
	//제품 가격
	@Column(nullable = false, length = 10)
	private String proListPrice;
	
	//제품 이용 가격
	@Column(nullable = false, length = 10)
	private String proListRentPrice;
	
	//제품 개별 등록 날짜
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date proListDate;
	
	@PrePersist
	protected void onCreate() {
		proListDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	
	
	@Builder
	public ProductList(String proListName, String proListCategory, Boolean proListLine, 
			String proListType, String proListWearingType, String proListCompany, 
			String proListText, String proListPrice, String proListRentPrice) {
		this.proListName = proListName;
		this.proListCategory = proListCategory;
		this.proListLine = proListLine;
		this.proListType = proListType;
		this.proListWearingType = proListWearingType;
		this.proListCompany = proListCompany;
		this.proListText = proListText;
		this.proListPrice = proListPrice;
		this.proListRentPrice = proListRentPrice;
		//this.productDetails = productDetails;
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
