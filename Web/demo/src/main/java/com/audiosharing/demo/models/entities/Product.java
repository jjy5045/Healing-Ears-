package com.audiosharing.demo.models.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
@Table(name = "PRODUCT_TB")
@DynamicUpdate
@DynamicInsert
public class Product implements Serializable {
	//제품 개별 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long productNoPk;
	
	//제품 개별 일련 번호
	@Column(nullable = false, length = 50)
	private String productSerialNumber;
	
	//제품 개별 등록 날짜
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date productCreateDate;
	
	//제품 개별 상태
	@Column(nullable = false, columnDefinition = "CHAR(10) DEFAULT 'available'")
	private String productState;
	
	//제품 목록 번호
	@ManyToOne
	@JoinColumn(name="productListNoPk")
    private ProductList productList;
	
	/*
	//스테이션 번호
	@OneToOne
	@JoinColumn(name="stnNoPk")
	private Station station;
	*/
	@PrePersist
	protected void onCreate() {
		productCreateDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@Builder
	public Product(String productSerialNumber, ProductList productList,
			Station station) {
		
		this.productSerialNumber = productSerialNumber;
		this.productList = productList;
		//this.station = station;
	}

}