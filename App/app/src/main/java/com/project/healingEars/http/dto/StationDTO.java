package com.project.healingEars.http.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.healingEars.http.vo.StationListVO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationDTO {
    public String result;

    public List<StationListVO> station;

}
