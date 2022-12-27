package com.audiosharing.demo.models.entities;

import java.io.Serializable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "STATION_TB")
@DynamicUpdate
@DynamicInsert
public class Station implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long stationId;

	// 스테이션 이름
	@Column(nullable = false, length = 45)
	private String stationName;
	
	// 스테이션 QR코드
	@Column(nullable = false, length = 200)
	private String stationQr;

	// 구글맵 위도
	@Column(nullable = false, length = 10)
	private String stationLatitude;

	// 구글맵 경도
	@Column(nullable = false, length = 10)
	private String stationLongitude;

	// 스테이션 주소 시 도
	@Column(nullable = false, length = 10)
	private String stationSido;

	// 스테이션 시 군 구
	@Column(nullable = false, length = 10)
	private String stationSigungu;

	// 스테이션 읍 면 동
	@Column(nullable = false, length = 10)
	private String stationEubmyendong;

	// 스테이션 지번
	@Column(nullable = false, length = 10)
	private String stationAdressNum;

	// 스테이션 도로명 주소
	@Column(nullable = false, length = 10)
	private String stationAdressLaod;

	// 이미지 파일 이름
	@Column(nullable = false, length = 70)
	private String stationImageName;

	// 이미지 파일 원본 이름
	@Column(nullable = false, length = 70)
	private String stationImageRealname;

	// 이미지 파일 경로
	@Column(nullable = false, length = 100)
	private String stationImagePath;

	// 스테이션 개설일
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date stationCreateDate;

	@PrePersist
	protected void onCreate() {
		stationCreateDate = Timestamp.valueOf(LocalDateTime.now());
	}

	@Builder
	public Station(String stationName, String stationQr, String stationLatitude, String stationLongitude, 
			String stationSido, String stationSigungu,
			String stationEubmyendong, String stationAdressNum, 
			String stationAdressLaod, String stationImageName,
			String stationImageRealname, String stationImagePath) {
		this.stationName = stationName;
		this.stationLatitude = stationLatitude;
		this.stationLongitude = stationLongitude;
		this.stationSido = stationSido;
		this.stationSigungu = stationSigungu;
		this.stationEubmyendong = stationEubmyendong;
		this.stationAdressNum = stationAdressNum;
		this.stationAdressLaod = stationAdressLaod;
		this.stationImageName = stationImageName;
		this.stationImageRealname = stationImageRealname;
		this.stationImagePath = stationImagePath;		
	}
}
