package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.response.ProjectResponse;
import com.example.ucinternship.network.RetrofitService;
import com.example.ucinternship.model.response.TokenResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static AuthRepository authRepository;
    private RetrofitService apiService;
    private static final String TAG = "AuthRepository";

    private AuthRepository() {
        apiService = RetrofitService.getInstance("");
    }

    public static AuthRepository getInstance() {
        if (authRepository == null) {
            authRepository = new AuthRepository();
        }
        return authRepository;
    }

    public MutableLiveData<TokenResponse> login(String email, String password) {
        MutableLiveData<TokenResponse> tokenResponse = new MutableLiveData<>();

        apiService.login(email, password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if(response.code() == 200){
                        if (response.body() != null) {
                            Log.d(TAG, "onResponse: " + response.body().getAccessToken());
                            tokenResponse.postValue(response.body());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return tokenResponse;
    }



}
