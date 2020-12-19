package com.example.ucinternship.ui.logout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.repository.AuthRepository;

public class LogoutViewModel  extends ViewModel {
    private AuthRepository repository;

    public LogoutViewModel() {
        repository = AuthRepository.getInstance();
    }

    public MutableLiveData<String> logout() {
        return repository.logout();
    }
}
