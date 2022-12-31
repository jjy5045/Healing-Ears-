package com.project.healingEars.api;

import android.app.Activity;
import android.content.Context;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.healingEars.global;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {
    // 가상머신에서는 개인 서버에 접속할 때 ip주소를 10.0.2.2로 설정

    private static retrofitClient instance = null;
    private Retrofit retrofit;


    /*
    private static class SessionCookieJar implements CookieJar {

        private List<Cookie> cookies;

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            if (url.encodedPath().endsWith("login")) {
                this.cookies = new ArrayList<>(cookies);
            }
        }


        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            if (!url.encodedPath().endsWith("login") && cookies != null) {
                return cookies;
            }
            return Collections.emptyList();
        }
    }
     */

    private retrofitClient() {
        //CookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor());

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();

        /*
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new SessionCookieJar())
                .build();

         */

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(global.baseURL);
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.client(okHttpClient);

        retrofit = builder.build();
    }

    public static retrofitClient getInstance() {
        if(instance == null) {
            instance = new retrofitClient();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}