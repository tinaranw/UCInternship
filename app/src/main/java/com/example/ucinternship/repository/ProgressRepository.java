package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.response.ProgressResponse;
import com.example.ucinternship.model.response.ProgressResponse;
import com.example.ucinternship.model.response.StudentProgressResponse;
import com.example.ucinternship.model.response.SupervisorProgressResponse;
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
        apiService.getProgresses().enqueue(new Callback<StudentProgressResponse>() {
            @Override
            public void onResponse(Call<StudentProgressResponse> call, Response<StudentProgressResponse> response) {
                Log.d(TAG, "onResponseStudentProgressResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponseStudentProgressSuccessful: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponseStudentProgressList: "+ response.body().getResults().size());
                        listProgress.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }
            @Override
            public void onFailure(Call<StudentProgressResponse> call, Throwable t) {
            }
        });
        return listProgress;
    }

    public MutableLiveData<List<Progress>> getSpvProgresses(){
        MutableLiveData<List<Progress>> listSpvProgress = new MutableLiveData<>();
        apiService.getSpvProgresses().enqueue(new Callback<SupervisorProgressResponse>() {
            @Override
            public void onResponse(Call<SupervisorProgressResponse> call, Response<SupervisorProgressResponse> response) {
                Log.d(TAG, "onResponseSpvProgressResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponseSpvProgressSuccessful: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponseSpvProgressList: "+ response.body().getResults().size());
                        listSpvProgress.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }

            @Override
            public void onFailure(Call<SupervisorProgressResponse> call, Throwable t) {

            }
        });
        return listSpvProgress;
    }
    public MutableLiveData<ProgressResponse> approveProgress(int progress_id, String comment) {
        MutableLiveData<ProgressResponse> progressResponse = new MutableLiveData<>();
        apiService.approveProgress(progress_id, comment).enqueue(new Callback<ProgressResponse>() {
            @Override
            public void onResponse(Call<ProgressResponse> call, Response<ProgressResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            progressResponse.postValue(response.body());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProgressResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return progressResponse;
    }
    public MutableLiveData<ProgressResponse> declineProgress(int progress_id, String comment) {
        MutableLiveData<ProgressResponse> progressResponse = new MutableLiveData<>();
        apiService.declineProgress(progress_id, comment).enqueue(new Callback<ProgressResponse>() {
            @Override
            public void onResponse(Call<ProgressResponse> call, Response<ProgressResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            progressResponse.postValue(response.body());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProgressResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return progressResponse;
    }
    public MutableLiveData<List<Progress>> getProgressLists(int task_id){
        MutableLiveData<List<Progress>> listProgress = new MutableLiveData<>();
        apiService.getProgressLists(task_id).enqueue(new Callback<StudentProgressResponse>() {
            @Override
            public void onResponse(Call<StudentProgressResponse> call, Response<StudentProgressResponse> response) {
                Log.d(TAG, "onResponseStudentProgressResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponseStudentProgressSuccessful: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponseStudentProgressList: "+ response.body().getResults().size());
                        listProgress.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }
            @Override
            public void onFailure(Call<StudentProgressResponse> call, Throwable t) {
            }
        });
        return listProgress;
    }

}
