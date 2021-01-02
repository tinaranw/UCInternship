package com.example.ucinternship.repository;

import com.example.ucinternship.network.RetrofitService;

public class ProfileRepository {

    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository() {
        apiService = RetrofitService.getInstance("");
    }

}
