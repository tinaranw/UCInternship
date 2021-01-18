package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.response.AcceptResponse;
import com.example.ucinternship.model.response.PendingResponse;
import com.example.ucinternship.model.response.ProjectUserResponse;
import com.example.ucinternship.model.response.TaskResponse;
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

    public synchronized void resetInstance() {
        if (projectRepository != null) {
            projectRepository = null;
        }
    }

    public MutableLiveData<List<Project>> getProjects() {
        MutableLiveData<List<Project>> listProjects = new MutableLiveData<>();
        apiService.getProjects().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listProjects.postValue(response.body().getResults());
                        resetInstance();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listProjects;
    }

    public MutableLiveData<List<Project>> getProjectOffers() {
        MutableLiveData<List<Project>> listProjects = new MutableLiveData<>();

        apiService.getProjectOffers().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listProjects.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listProjects;
    }

    public MutableLiveData<List<Project>> getPending() {
        MutableLiveData<List<Project>> listPending = new MutableLiveData<>();

        apiService.getPending().enqueue(new Callback<PendingResponse>() {
            @Override
            public void onResponse(Call<PendingResponse> call, Response<PendingResponse> response) {
                Log.d(TAG, "onPendingResponse1: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onPendingResponse2: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onPendingResponse3: " + response.body().getResults().size());
                        listPending.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<PendingResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listPending;
    }

    public MutableLiveData<List<Project>> getAccept() {
        MutableLiveData<List<Project>> listAccept = new MutableLiveData<>();
        apiService.getAccept().enqueue(new Callback<AcceptResponse>() {
            @Override
            public void onResponse(Call<AcceptResponse> call, Response<AcceptResponse> response) {
                Log.d(TAG, "onResponseAccept1: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponseAccept2: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponseAccept3: " + response.body().getResults().size());
                        listAccept.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<AcceptResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listAccept;
    }

    public MutableLiveData<List<Project>> getEvent() {
        MutableLiveData<List<Project>> listEvent = new MutableLiveData<>();

        apiService.getEvent().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listEvent.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listEvent;
    }

    public MutableLiveData<List<Project>> getEducation() {
        MutableLiveData<List<Project>> listEducation = new MutableLiveData<>();

        apiService.getEducation().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listEducation.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listEducation;
    }

    public MutableLiveData<List<Project>> getOther() {
        MutableLiveData<List<Project>> listOther = new MutableLiveData<>();

        apiService.getOther().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listOther.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listOther;
    }

    public MutableLiveData<List<Project>> getEventOffer() {
        MutableLiveData<List<Project>> listEventOffer = new MutableLiveData<>();

        apiService.getEventOffer().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listEventOffer.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listEventOffer;
    }

    public MutableLiveData<List<Project>> getEducationOffer() {
        MutableLiveData<List<Project>> listEducationOffer = new MutableLiveData<>();

        apiService.getEducationOffer().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listEducationOffer.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listEducationOffer;
    }

    public MutableLiveData<List<Project>> getOtherOffer() {
        MutableLiveData<List<Project>> listOtherOffer = new MutableLiveData<>();

        apiService.getOtherOffer().enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listOtherOffer.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listOtherOffer;
    }


    public MutableLiveData<ProjectUserResponse> acceptStudent(int user_id, int project_id) {
        MutableLiveData<ProjectUserResponse> supervisorResponse = new MutableLiveData<>();
        apiService.acceptStudent(user_id, project_id).enqueue(new Callback<ProjectUserResponse>() {
            @Override
            public void onResponse(Call<ProjectUserResponse> call, Response<ProjectUserResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponseb: " + response.code());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            supervisorResponse.postValue(response.body());
                        }
                    }
                } else {
//                    Log.d(TAG, "onResponsea: " + response.code() + " asd " + response.message() + " asd " + response.body() + " asd " + response.errorBody() + " asd " + response.headers());
                    Log.d(TAG, "onResponsea: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<ProjectUserResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return supervisorResponse;
    }

    public MutableLiveData<ProjectUserResponse> declineStudent(int user_id, int project_id) {
        MutableLiveData<ProjectUserResponse> supervisorResponse = new MutableLiveData<>();
        apiService.declineStudent(user_id, project_id).enqueue(new Callback<ProjectUserResponse>() {
            @Override
            public void onResponse(Call<ProjectUserResponse> call, Response<ProjectUserResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            supervisorResponse.postValue(response.body());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProjectUserResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return supervisorResponse;
    }
}
