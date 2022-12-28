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
@Getter @Setter
@Entity
@Table(name = "USER_TB")
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long userNoPk;

	@Column(nullable = false, length = 6)
	private String userBirth;

	@Column(nullable = false, length = 50)
	private String userMail;

	@Column(nullable = false, length = 15)
	private String userTel;

	@Column(nullable = false, length = 10)
	private String userName;

	@Column(nullable = false, length = 20)
	private String userPassword;

	@Column(nullable = false, length = 10)
	private String userSex;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
	private String userDel;
	
	@Column(nullable = false, length = 10, columnDefinition = "CHAR(10) DEFAULT 'USER'")
	private String userType;
	
	@Column(nullable = false, length = 10)
	private String userMusicGenre1;

	@Column(nullable = false, length = 10)
	private String userMusicGenre2;
	
	@Column(nullable = false, length = 10)
	private String userMusicGenre3;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date userCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
	protected Date userUpdateDate;

	@PrePersist
	protected void onCreate() {
		userCreateDate = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	protected void onUpdate() {
		userUpdateDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	// 생성자 단축키 alt + shift + s, o
	
	@Builder
	public User(String userBirth, String userMail, String userTel, String userName,
			String userPassword, String userSex, String userType, String userMusicGenre1,
			String userMusicGenre2, String userMusicGenre3) {
		this.userBirth = userBirth;
		this.userMail = userMail;
		this.userTel = userTel;
		this.userName = userSex;
		this.userPassword = userPassword;
		this.userSex= userSex;
		this.userMusicGenre1 = userMusicGenre1;
		this.userMusicGenre1 = userMusicGenre2;
		this.userMusicGenre1 = userMusicGenre3;
	}	
}
