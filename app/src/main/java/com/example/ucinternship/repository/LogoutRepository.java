package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.network.RetrofitService;
import com.example.ucinternship.model.response.ProjectResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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

    public synchronized void resetInstance(){
        if (logoutRepository != null) {
            logoutRepository = null;
        }
    }

    public MutableLiveData<String> logout(){
        MutableLiveData<String> message = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    if(response.isSuccessful()){
                        Log.d(TAG, "onResponse: "+ response.code());
                        if(response.body() != null){
                            try {
                                JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                                String msg = object.getString("message");
                                Log.d(TAG, "onResponse: " + msg);
                                message.postValue(msg);
                            }  catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });

        return message;
    }
}
