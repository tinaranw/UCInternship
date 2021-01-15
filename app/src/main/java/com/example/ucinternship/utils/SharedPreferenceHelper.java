package com.example.ucinternship.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.User;
import com.example.ucinternship.model.response.SupervisorResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedPreferenceHelper {
    private static final String PREFS = "pref";
    private static final String PREFSID = "prefID";
    private static final String PREFSROLE = "prefRole";
    public static final String LOGIN = "Login";
    private static SharedPreferenceHelper instance;
    private SharedPreferences prefs, prefsID, prefsRole;
    private SharedPreferences.Editor spEditor, spIDEditor, spRoleEditor;

    public SharedPreferenceHelper(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        spEditor = prefs.edit();
        prefsID = context.getSharedPreferences(PREFSID, Context.MODE_PRIVATE);
        spIDEditor = prefsID.edit();
        prefsRole = context.getSharedPreferences(PREFSROLE, Context.MODE_PRIVATE);
        spRoleEditor = prefsRole.edit();
    }

    //fungsi sharedpref ini seperti cookies, dia akan nyimpan informasi user yang login di aplikasi,
    //dia tidak ada hubungannya dengan DB
    public static SharedPreferenceHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferenceHelper(context);
        }
        return instance;
    }

    public void saveRefreshToken(String token) {
        spEditor.putString(PREFS, token).apply();
    }

    public void saveAccessToken(String token) {
        spEditor.putString(PREFS, token).apply();
    }

    public String getAccessToken() {
        return prefs.getString(PREFS, "");
    }

    public void saveUserID(int id) {
        spIDEditor.putInt(PREFSID, id).apply();
    }

    public int getUserID() {
        return prefsID.getInt(PREFSID, 0);
    }

    public void saveRole(String role) {
        spRoleEditor.putString(PREFSROLE, role).apply();
    }

    public String getRole() {
        return prefsRole.getString(PREFSROLE, "");
    }


    public void clearPref() {
        spEditor.clear().apply();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public Boolean getLogin() {
        return prefs.getBoolean(LOGIN, false);
    }

}
