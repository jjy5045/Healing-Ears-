package com.project.healingEars.http.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionDTO {
    public String loginState;
    public String sessionGetID;
    public String auth;
    public int id;
}
