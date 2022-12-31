package com.project.healingEars.http.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;


public class ProDetailTestVO {

    public String result;
    //public ArrayList<ProductDetail> productDetail;

    public ArrayList<ProductDetailVO> productDetail;


    /*
    public static class ProductDetail {
        public int proDetailId;
        public String proDetailNumber;
        public String proDetailQR;
        public Date proDetailDate;
        public boolean proDetailRentCheck;
        public Object productList;
        public Object stationList;

    }
     */



}
