package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.response.AcceptResponse;
import com.example.ucinternship.model.response.PendingResponse;
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

public class ProjectRepository {

    private static ProjectRepository projectRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProjectRepository";

    private ProjectRepository(String token) {
        Log.d(TAG, "ProjectRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProjectRepository getInstance(String token) {
        if (projectRepository == null) {
            projectRepository = new ProjectRepository(token);
        }
        return projectRepository;
    }

    public synchronized void resetInstance(){
        if (projectRepository != null) {
            projectRepository = null;
        }
    }

    public MutableLiveData<List<Project>> getProjects(){
        MutableLiveData<List<Project>> listProjects = new MutableLiveData<>();
        apiService.getProjects().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponse: "+ response.body().getResults().size());
                        listProjects.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }
            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
        return listProjects;
    }

    public MutableLiveData<List<Project>> getProjectOffers(){
        MutableLiveData<List<Project>> listProjects = new MutableLiveData<>();

        apiService.getProjectOffers().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponse: "+ response.body().getResults().size());
                        listProjects.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
        return listProjects;
    }

    public MutableLiveData<List<Project>> getPending(){
        MutableLiveData<List<Project>> listPending = new MutableLiveData<>();

        apiService.getPending().enqueue(new Callback<PendingResponse>() {
            @Override
            public void onResponse(Call<PendingResponse> call, Response<PendingResponse> response) {
                Log.d(TAG, "onPendingResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onPendingResponse: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onPendingResponse: "+ response.body().getResults().size());
                        listPending.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<PendingResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
        return listPending;
    }

    public MutableLiveData<List<Project>> getAccept(){
        MutableLiveData<List<Project>> listAccept = new MutableLiveData<>();

        apiService.getAccept().enqueue(new Callback<AcceptResponse>() {
            @Override
            public void onResponse(Call<AcceptResponse> call, Response<AcceptResponse> response) {
                Log.d(TAG, "onResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponse: "+ response.body().getResults().size());
                        listAccept.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<AcceptResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
        return listAccept;
    }

}
