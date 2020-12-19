package com.example.ucinternship.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceHelper {
    private static final String PREFS = "pref";
    public static final String LOGIN = "Login";
    private static SharedPreferenceHelper instance;
    private SharedPreferences prefs;
    private SharedPreferences.Editor spEditor;


    //fungsi sharedpref ini seperti cookies, dia akan nyimpan informasi user yang login di aplikasi,
    //dia tidak ada hubungannya dengan DB
    public SharedPreferenceHelper(Context context){
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        spEditor = prefs.edit();
    }

    public static SharedPreferenceHelper getInstance(Context context){
        if(instance ==null){
            instance = new SharedPreferenceHelper(context);
        }
        return instance;
    }

    public void saveAccessToken (String token){
        spEditor.putString(PREFS,token).apply();
    }

    public void saveRefreshToken (String token){
        spEditor.putString(PREFS,token).apply();
    }

    public String getAccessToken(){
        return prefs.getString(PREFS, "");
    }

    public void clearPref(){
        spEditor.clear().apply();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public Boolean getLogin(){
        return prefs.getBoolean(LOGIN, false);
    }
}
