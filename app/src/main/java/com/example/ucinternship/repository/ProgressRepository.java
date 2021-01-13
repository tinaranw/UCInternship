package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.response.ProgressResponse;
import com.example.ucinternship.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgressRepository {
    private static ProgressRepository progressRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProgressRepository";

    private ProgressRepository(String token) {
        Log.d(TAG, "ProgressRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProgressRepository getInstance(String token) {
        if (progressRepository == null) {
            progressRepository = new ProgressRepository(token);
        }
        return progressRepository;
    }

    public synchronized void resetInstance(){
        if (progressRepository != null) {
            progressRepository = null;
        }
    }

    public MutableLiveData<List<Progress>> getProgresses(){
        MutableLiveData<List<Progress>> listProgress = new MutableLiveData<>();
        apiService.getProgresses().enqueue(new Callback<ProgressResponse>() {
            @Override
            public void onResponse(Call<ProgressResponse> call, Response<ProgressResponse> response) {
                Log.d(TAG, "onResponseProgressResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponseProgressSuccessful: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponseProgressList: "+ response.body().getResults().size());
                        listProgress.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProgressResponse> call, Throwable t) {

            }
        });
        return listProgress;
    }
}
