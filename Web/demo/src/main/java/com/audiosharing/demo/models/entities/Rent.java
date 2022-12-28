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
@Table(name = "RENT_TB")
@DynamicUpdate
@DynamicInsert
public class Rent implements Serializable {
	// 대여 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long rentNoPk;

	// 대여 시작 시간
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rentStartDate;
	
	// 대여 종료 시간
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date rentEndDate;

	// 대여 결제 금액
	@Column(nullable = true, length = 10)
	private String rentPrice;
	
	// 대여 결제 금액 납부 여부
	@Column(nullable = false, length = 10)
	private String rentDidPay;
	
	// 유저 번호
	@ManyToOne
	@JoinColumn(name = "userNoPk")
	private User user;

	// 제품 개별 번호
	@ManyToOne
	@JoinColumn(name = "productNoPk")
	private Product product;
	
	// 리뷰
	@OneToOne
	@JoinColumn(name="reviewNoPk")
	private Review review;
	

	
	@PrePersist
	protected void onCreate() {
		rentStartDate = Timestamp.valueOf(LocalDateTime.now());
	}


	@Builder
	public Rent(Date rentEndDate, String rentPrice, String rentDidPay, User user,
			Product product, Review review) {
		this.rentEndDate = rentEndDate;
		this.rentPrice = rentPrice;
		this.rentDidPay = rentDidPay;
		this.user = user;
		this.product = product;
		this.review = review;
	}


}
