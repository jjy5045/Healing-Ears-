package com.project.healingEars.http.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.healingEars.http.vo.UserVO;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    public String result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public UserVO user;
}
