package com.project.healingEars.http.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserVO {
    public int userId;
    public String userType;
    public String userEmail;
    public String userPassword;
    public String userName;
    public String userSex;
    public String userBirth;
    public String userTel;
    public boolean userDel;
    public Date userCreateTimestamp;
    public Date userUpdateTimestamp;

    public UserVO(String userName) {
        this.userName = userName;
    }

    public UserVO(String userEmail, String userPassword) {
        System.out.println("UserVO 생성자 호출");
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public UserVO(String param, String param1, String param2, String param3, String param4, String param5) {
        this.userType = "1";
        this.userName = param;
        this.userSex = param1;
        this.userEmail = param2;
        this.userTel = param3;
        this.userPassword = param4;
        this.userBirth = param5;
    }
}