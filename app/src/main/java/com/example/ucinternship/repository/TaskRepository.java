package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.model.response.TaskResponse;
import com.example.ucinternship.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository {
    private static TaskRepository taskRepository;
    private RetrofitService apiService;
    private static final String TAG = "TaskRepository";

    private TaskRepository(String token) {
        Log.d(TAG, "TaskRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static TaskRepository getInstance(String token) {
        if (taskRepository == null) {
            taskRepository = new TaskRepository(token);
        }
        return taskRepository;
    }

    public synchronized void resetInstance(){
        if (taskRepository != null) {
            taskRepository = null;
        }
    }

    public MutableLiveData<List<Task>> getTasks(){
        MutableLiveData<List<Task>> listTasks = new MutableLiveData<>();
        apiService.getTasks().enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                Log.d(TAG, "onResponseTaskResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponseTaskSuccessful: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponseonResponseTaskList: "+ response.body().getResults().size());
                        listTasks.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }
            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
        return listTasks;
    }
    public MutableLiveData<List<Task>> getTaskLists(int project_id) {
        MutableLiveData<List<Task>> listTasks = new MutableLiveData<>();
        apiService.getTaskLists(project_id).enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                Log.d(TAG, "onResponseTaskResponse: "+ response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponseb: " + response.code() + " asd " + response.message() + " asd " + response.body() + " asd " + response.errorBody() + " asd " + response.headers());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            listTasks.postValue(response.body().getResults());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponsea: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listTasks;
    }

}
