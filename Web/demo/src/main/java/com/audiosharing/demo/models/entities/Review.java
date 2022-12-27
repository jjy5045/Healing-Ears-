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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
@Table(name = "Review")
@DynamicUpdate
@DynamicInsert
public class Review implements Serializable {
	// 리뷰 아이디
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long reviewId;
	
	// 리뷰 사운드
	@Column(nullable = false, columnDefinition = "TINYINT(1)", length = 1)
	private Integer reviewSound;
	
	// 리뷰 디자인
	@Column(nullable = false, columnDefinition = "TINYINT(1)", length = 1)
	private Integer reviewFit;
	
	// 리뷰 디자인
	@Column(nullable = false, columnDefinition = "TINYINT(1)", length = 1)
	private Integer reviewDesign;
	
	// 리뷰 상세
	@Column(nullable = false, length = 200)
	private String reviewText;
	
	// 리뷰 작성 날짜
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date reviewCreateTimestmap;
	
	@PrePersist
	protected void onCreate() {
		reviewCreateTimestmap = Timestamp.valueOf(LocalDateTime.now());
	}
}
