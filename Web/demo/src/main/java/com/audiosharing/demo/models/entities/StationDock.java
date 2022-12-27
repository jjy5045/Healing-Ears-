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
@Table(name = "STATION_DOCK_TB")
@DynamicUpdate
@DynamicInsert
public class StationDock implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long stationDockNoPk;

	// 스테이션 이름
	@Column(nullable = false, length = 45)
	private String stationDockName;
	
	// 스테이션 QR코드
	@Column(nullable = false, length = 200)
	private String stationDockQr;
	//asdasd

	//스테이션 번호
	@ManyToOne
	@JoinColumn(name="stationNoPk")
    private Station station;
	
	//제품 번호
	@OneToOne
	@JoinColumn(name="productNoPk", unique=true)
	private Product product;
}
