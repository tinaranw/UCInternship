package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.model.response.StudentResponse;
import com.example.ucinternship.model.response.SupervisorResponse;
import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository(String token) {
        Log.d(TAG, "ProfileRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProfileRepository getInstance(String token) {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository(token);
        }
        return profileRepository;
    }

    public synchronized void resetInstance() {
        if (profileRepository != null) {
            profileRepository = null;
        }
    }

    public MutableLiveData<Student> getStudentDetails(int id) {
        MutableLiveData<Student> listStudents = new MutableLiveData<>();
        apiService.getStudentDetails(id).enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                Log.d(TAG, "onResponse1: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse2: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse3: " + response.body().getStudent_data());
                        listStudents.postValue(response.body().getStudent_data());
                        resetInstance();
                    }
                }
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listStudents;
    }

    public MutableLiveData<Supervisor> getSupervisorDetails(int id) {
        MutableLiveData<Supervisor> listSupervisors = new MutableLiveData<>();
        apiService.getSupervisorDetails(id).enqueue(new Callback<SupervisorResponse>() {
            @Override
            public void onResponse(Call<SupervisorResponse> call, Response<SupervisorResponse> response) {
                Log.d(TAG, "onResponse1: " + response.code());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse2: " + response.code());
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse3: " + response.body().getSupervisor_data());
                        listSupervisors.postValue(response.body().getSupervisor_data());
                        resetInstance();
                    }
                }
            }

            @Override
            public void onFailure(Call<SupervisorResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listSupervisors;
    }

    public MutableLiveData<StudentResponse> updateStudent(int id, String phone, String line_account) {
        MutableLiveData<StudentResponse> studentResponse = new MutableLiveData<>();
        apiService.updateStudent(id, phone, line_account).enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            studentResponse.postValue(response.body());
                            Log.d(TAG, "onResponsea: " + response.code() + response.message() + response.body() + response.errorBody() + response.headers());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return studentResponse;
    }

    public MutableLiveData<SupervisorResponse> updateSupervisor(int id, String phone, String line_account) {
        MutableLiveData<SupervisorResponse> supervisorResponse = new MutableLiveData<>();
        apiService.updateSupervisor(id, phone, line_account).enqueue(new Callback<SupervisorResponse>() {
            @Override
            public void onResponse(Call<SupervisorResponse> call, Response<SupervisorResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponseb: " + response.code() + " asd " + response.message() + " asd " + response.body() + " asd " + response.errorBody() + " asd " + response.headers());
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            supervisorResponse.postValue(response.body());
                        }
                    }
                } else {
                    Log.d(TAG, "onResponsea: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<SupervisorResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return supervisorResponse;
    }


}
