package com.project.healingEars.http.service;

import android.os.AsyncTask;

import com.project.healingEars.http.dto.ProductDetailDTO;
import com.project.healingEars.http.dto.ProductRentDTO;
import com.project.healingEars.http.dto.StationDTO;
import com.project.healingEars.http.repository.ProductDetailRepository;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Call;


public class ProductDetailService {

    static ProductDetailRepository.ProductDetailAPI retrofit2 = ProductDetailRepository.getRetrofit();


    public  static class getProDetailByStn extends AsyncTask<Integer, Void, Response<ProductDetailDTO>> {
        @Override
        protected void onPreExecute() { super.onPreExecute(); }

        @Override
        protected Response<ProductDetailDTO> doInBackground(Integer... params) {

            Call<ProductDetailDTO> result = retrofit2.getProDetailByStn(params[0]);
            try {
                Response<ProductDetailDTO> response = result.execute();
                return response;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Response<ProductDetailDTO> s) {
            super.onPostExecute(s);
        }
    }
}


