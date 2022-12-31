package com.project.healingEars.http.repository;

import com.project.healingEars.api.retrofitClient;
import com.project.healingEars.http.dto.ProductDetailDTO;
import com.project.healingEars.http.dto.StationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ProductDetailRepository {

    public  static ProductDetailAPI getRetrofit() {
        return retrofitClient.getInstance().getRetrofit().create(ProductDetailRepository.ProductDetailAPI.class);
    }

    public interface ProductDetailAPI {
        @GET("productDetail/station/{StnId}")
        Call<ProductDetailDTO> getProDetailByStn(@Path("StnId") Integer StnId);
    }
}
