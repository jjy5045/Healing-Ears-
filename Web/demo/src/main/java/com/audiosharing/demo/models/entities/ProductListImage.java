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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUCT_LIST_IMAGE_TB")
@DynamicUpdate
@DynamicInsert

public class ProductListImage implements Serializable {
	// 이미지 파일 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long productListImageNoPk;

	// 이미지 파일 이름
	@Column(nullable = false, length = 100)
	private String productListImageName;
	
	// 이미지 파일 원본 이름
	@Column(nullable = false, length = 100)
	private String productListImageRealName;

	// 이미지 파일 저장 경로
	@Column(nullable = false, length = 200)
	private String productListImagePath;

	// 제품 종류 번호
	@ManyToOne
	@JoinColumn(name="productListNoPk")
	private ProductList productList;

	public ProductListImage(String productListImageName, String productListImageRealName,
			String productListImagePath, ProductList productList) {
		this.productListImageName = productListImageName;
		this.productListImageRealName = productListImageRealName;
		this.productListImagePath = productListImagePath;
		this.productList = productList;
	}
	
	
}
