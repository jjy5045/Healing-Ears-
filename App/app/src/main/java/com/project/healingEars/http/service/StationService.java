package com.project.healingEars.http.service;

import android.os.AsyncTask;

import com.project.healingEars.http.dto.StationDTO;
import com.project.healingEars.http.repository.StationRepository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class StationService {

    static StationRepository.StationAPI retrofit2 = StationRepository.getRetrofit();
    

    public static class getAllStation extends AsyncTask<String, Void, Response<StationDTO>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Response<StationDTO> doInBackground(String... params) {
            Call<StationDTO> result = retrofit2.getAllStation();
            try {
                Response<StationDTO> response = result.execute();
                return response;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Response<StationDTO> s) {
            super.onPostExecute(s);
        }
    }
}
