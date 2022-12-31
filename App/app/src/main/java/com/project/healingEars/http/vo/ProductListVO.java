package com.project.healingEars.http.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductListVO {
    public int proListId;
    public String proListType;
    public String proListName;
    public String proListCompany;
    public String proListText;
    public String proListPrice;
    public String proListRentPrice;
}
