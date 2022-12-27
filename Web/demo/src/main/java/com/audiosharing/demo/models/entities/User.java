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
@Table(name = "user")
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long userId;

	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT '0'")
	private String userType;

	@Column(nullable = false, unique = true, length = 100)
	private String userEmail;

	@Column(nullable = false, length = 50)
	private String userName;

	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT '1'")
	private String userSex;

	@Column(nullable = false, length = 6)
	private String userBirth;

	@Column(nullable = false, length = 20)
	private String userTel;

	@Column(nullable = false, length = 150)
	private String userPassword;
	
	@Column(nullable = false, length = 10)
	private String userMusicGenre1;

	@Column(nullable = false, length = 10)
	private String userMusicGenre2;
	
	@Column(nullable = false, length = 10)
	private String userMusicGenre3;
	
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean userDel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date userCreateTimestamp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
	protected Date userUpdateTimestamp;

	@PrePersist
	protected void onCreate() {
		userCreateTimestamp = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	protected void onUpdate() {
		userUpdateTimestamp = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@Builder
	public User(String userType, String userName, String userEmail, String userSex,
			String userBirth, String userTel, String userPassword) {
		this.userType = userType;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userBirth = userBirth;
		this.userTel= userTel;
		this.userPassword = userPassword;
	}	
}
