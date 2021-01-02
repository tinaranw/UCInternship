package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.repository.AuthRepository;

public class LoginViewModel extends ViewModel {
    private AuthRepository repository;

    public LoginViewModel() {
        repository = AuthRepository.getInstance();
    }

    //kenapa di sini ga perlu init? krn disini blm save token kek logout

    //disini kita pass email dan pass nya sehingga kita masukkan disini
    public MutableLiveData<TokenResponse> login(String email, String password) {
        return repository.login(email, password);
    }
}
