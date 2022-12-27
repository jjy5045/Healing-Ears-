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
@Table(name = "product_detail")
@DynamicUpdate
@DynamicInsert
public class ProductDetail implements Serializable {
	//제품 개별 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long proDetailId;
	
	//제품 개별 일련 번호
	@Column(nullable = false, length = 50)
	private String proDetailNumber;
	
	//제품 개별 QR 코드
	@Column(nullable = false, length = 100)
	private String proDetailQR;
	
	//제품 개별 등록 날짜
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date proDetailDate;
	
	//제품 예약 확인
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean proDetailRentCheck;
	
	//제품 목록 번호
	@ManyToOne
	@JoinColumn(name="proListId")
    private ProductList productList;
	
	//스테이션 번호
	@OneToOne
	@JoinColumn(name="stnId")
	private StationList stationList;
	
	@PrePersist
	protected void onCreate() {
		proDetailDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@Builder
	public ProductDetail(String proDetailNumber, String proDetailQR, ProductList productList,
			StationList stationList) {
		this.proDetailNumber = proDetailNumber;
		this.proDetailQR = proDetailQR;
		this.productList = productList;
		this.stationList = stationList;
	}

}