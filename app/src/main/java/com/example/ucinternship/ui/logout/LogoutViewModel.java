package com.example.ucinternship.ui.logout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.repository.AuthRepository;

public class LogoutViewModel  extends ViewModel {
    private AuthRepository repository;

    public LogoutViewModel() {
<<<<<<< Updated upstream
        repository = AuthRepository.getInstance();
    }

    public MutableLiveData<String> logout() {
=======

    }

    //ambil token
    public void init(String token){
        repository = LogoutRepository.getInstance(token);
    }

    //manggil function yang ada di repo
    public LiveData<String> logout() {
>>>>>>> Stashed changes
        return repository.logout();
    }
}
