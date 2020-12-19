package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.network.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutRepository {

    private static LogoutRepository logoutRepository;
    private RetrofitService apiService;
    private static final String TAG = "LogoutRepository";

    private LogoutRepository(String token) {
        Log.d(TAG, "LogoutRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static LogoutRepository getInstance(String token) {
        if (logoutRepository == null) {
            logoutRepository = new LogoutRepository(token);
        }
        return logoutRepository;
    }

    //mencegah bug yang terjadi saat logout sehingga kita bisa logout berulang kali tanpa kecantol
    //kita harus membuat null isi logoutrepo
    public synchronized void resetInstance(){
        if (logoutRepository != null) {
            logoutRepository = null;
        }
    }
    public LiveData<String> logout(){
        MutableLiveData<String> message = new MutableLiveData<>();
        //tiap kali req
        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //masuk kesini
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success - : " + response.code());
                    if (response.body() != null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: Success - : " + msg);
                            message.postValue(msg);
                            Log.d(TAG, "messagelogout" + message);
                            resetInstance();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Log.d(TAG, "onResponse: Failed - " + response.code());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

        return message;
    }

}
