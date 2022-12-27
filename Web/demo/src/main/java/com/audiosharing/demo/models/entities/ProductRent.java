package com.audiosharing.demo.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "product_rent")
@DynamicUpdate
@DynamicInsert
public class ProductRent implements Serializable {
	// 대여 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long rentId;

	// 대여 시작 시간
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rentStartTime;
	
	// 대여 종료 시간
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date rentEndTime;

	// 대여 결제 금액
	@Column(nullable = false, length = 10)
	private String rentPrice;
	
	// 추가 결제 금액
	@Column(nullable = false, length = 10)
	private String rentExtraPrice;
	
	// 유저 번호
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	// 제품 개별 번호
	@ManyToOne
	@JoinColumn(name = "proDetailId")
	private ProductDetail productDetail;
	
	// 리뷰
	@OneToOne
	@JoinColumn(name="reviewId")
	private Review review;
	
	

	
	/*
	@PrePersist
	protected void onCreate() {
		rentStartTime = Timestamp.valueOf(LocalDateTime.now());
	}
	*/



	@Builder
	public ProductRent(String rentStartTime, String rentPayment, String rentAdditionalPayment, 
			User user, ProductDetail productDetail) {

		this.user = user;
		this.productDetail = productDetail;
	}

}
