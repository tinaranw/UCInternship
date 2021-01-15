package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.repository.ProgressRepository;

import java.util.List;

public class ProgressViewModel  extends ViewModel {
    private ProgressRepository repository;

    public ProgressViewModel() {

    }

    public void init(String token) {
        repository = ProgressRepository.getInstance(token);
    }

    public LiveData<List<Progress>> getProgresses() {
        return repository.getProgresses();
    }

    public LiveData<List<Progress>> getSpvProgresses() {
        return repository.getSpvProgresses();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
