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
@Table(name = "station_list")
@DynamicUpdate
@DynamicInsert
public class StationList implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long stnId;

	@Column(nullable = false, length = 45)
	private String stnName;

	// 구글맵 위도
	@Column(nullable = false, length = 10)
	private String stnLatitude;

	// 구글맵 경도
	@Column(nullable = false, length = 10)
	private String stnLongitude;

	// 스테이션 주소 시 도
	@Column(nullable = false, length = 10)
	private String stnSido;

	// 스테이션 시 군 구
	@Column(nullable = false, length = 10)
	private String stnSigungu;

	// 스테이션 읍 면 동
	@Column(nullable = false, length = 10)
	private String stnEubmyendong;

	// 스테이션 지번
	@Column(nullable = false, length = 10)
	private String stnAdressNum;

	// 스테이션 도로명 주소
	@Column(nullable = false, length = 10)
	private String stnAdressLaod;

	// 이미지 파일 이름
	@Column(nullable = false, length = 70)
	private String stnImageName;

	// 이미지 파일 원본 이름
	@Column(nullable = false, length = 70)
	private String stnImageRealname;

	// 이미지 파일 경로
	@Column(nullable = false, length = 100)
	private String stnImagePath;

	// 스테이션 개설일
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date stnCreateTimestamp;

	@PrePersist
	protected void onCreate() {
		stnCreateTimestamp = Timestamp.valueOf(LocalDateTime.now());
	}

	@Builder
	public StationList(String stnName, String stnLatitude, String stnLongitude, 
			String stnSido, String stnSigungu,
			String stnEubmyendong, String stnAdressNum, 
			String stnAdressLaod, String stnImageName,
			String stnImageRealname, String stnImagePath) {
		this.stnName = stnName;
		this.stnLatitude = stnLatitude;
		this.stnLongitude = stnLongitude;
		this.stnSido = stnSido;
		this.stnSigungu = stnSigungu;
		this.stnEubmyendong = stnEubmyendong;
		this.stnAdressNum = stnAdressNum;
		this.stnAdressLaod = stnAdressLaod;
		this.stnImageName = stnImageName;
		this.stnImageRealname = stnImageRealname;
		this.stnImagePath = stnImagePath;		
	}
}
