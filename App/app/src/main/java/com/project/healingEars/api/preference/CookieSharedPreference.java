package com.project.healingEars.api.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class CookieSharedPreference {
    public static final String PREF_NAME = "com.project.closet.pref";
    public static final String KEY_USER_ID = "userID";

    // 싱글톤 모델로 객체 초기화
    private static CookieSharedPreference CookieSharedPreference = null;


    public static CookieSharedPreference getInstanceOf(Context c){
        if(CookieSharedPreference == null){
            CookieSharedPreference = new CookieSharedPreference(c);
        }
        return CookieSharedPreference;
    }

    private SharedPreferences pref;

    public CookieSharedPreference(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }

    public void setUserID(String userID){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_USER_ID, userID);
        editor.commit();
    }

    public String getUserID(){
        return pref.getString(KEY_USER_ID,"");
    }


    public void putString(String key, String value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public String getString(String key, String default_value){
        try {
            return pref.getString(key, default_value);
        } catch (Exception e) {
            return default_value;
        }
    }
}
