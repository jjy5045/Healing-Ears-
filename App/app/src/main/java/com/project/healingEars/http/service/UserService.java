package com.project.healingEars.http.service;

import android.os.AsyncTask;

import com.project.healingEars.api.APIAdapter;
import com.project.healingEars.http.dto.SessionDTO;
import com.project.healingEars.http.dto.SignUpDTO;
import com.project.healingEars.http.dto.UserDTO;
import com.project.healingEars.http.repository.UserRepository;
import com.project.healingEars.http.vo.UserVO;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;


public class UserService extends APIAdapter {

    static UserRepository.UserAPI retrofit2 = UserRepository.getRetrofit();


    public static class LoginTask extends AsyncTask<String, Void, Response<UserDTO>> {

        @Override // 작업전 실행되는 메서드
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Response<UserDTO> doInBackground(String... params) {
            UserVO userVO = new UserVO(params[0], params[1]);//email, pwd
            //UserVO userVO = new UserVO("jjy0943@naver.com", "111111");
            //Object contex
            //Call<String> jsonCall = UserRepository.getRcoetrofit(params[2]).loginString(userVO);
            Call<UserDTO> result = retrofit2.loginString(userVO);


            try {
                Response<UserDTO> response = result.execute();
                return response;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override //백그라운드 작업이 종료되고 받은 결과값으로 할 작업 입력
        protected void onPostExecute(Response<UserDTO> s) {
            super.onPostExecute(s);
        }
    }

    public static class Logout extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            Call<String> result = retrofit2.logout();
            try {
                return result.execute().body().toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public static class SessionInfo extends AsyncTask<String, Void, Response<SessionDTO>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Response<SessionDTO> doInBackground(String... params) {
            Call<SessionDTO> result = retrofit2.sessionInfo();
            try {
                return result.execute();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Response<SessionDTO> s) {
            super.onPostExecute(s);
        }
    }

    public static class SignUp extends AsyncTask<String, Void, Response<SignUpDTO>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Response<SignUpDTO> doInBackground(String... params) {
            UserVO userVO = new UserVO(params[0], params[1], params[2], params[3], params[4], params[5]);

            Call<SignUpDTO> response = retrofit2.signUp(userVO);
            try {
                Response<SignUpDTO> result = response.execute();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Response<SignUpDTO> s) {
            super.onPostExecute(s);
        }
    }


}
