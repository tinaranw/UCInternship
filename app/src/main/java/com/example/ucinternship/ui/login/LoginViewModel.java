package com.example.ucinternship.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.repository.AuthRepository;

public class LoginViewModel extends ViewModel {
    private AuthRepository repository;

    public LoginViewModel() {
        repository = AuthRepository.getInstance();
    }

    public MutableLiveData<TokenResponse> login(String email, String password) {
        return repository.login(email, password);
    }
}
