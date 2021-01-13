package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.ucinternship.repository.ProgressRepository;
import com.example.ucinternship.repository.TaskRepository;

public class ProgressDetailViewModel extends ViewModel {
    private ProgressRepository progressRepository;

    public ProgressDetailViewModel() {

    }

    public void init(String token) {
        progressRepository = ProgressRepository.getInstance(token);
    }
}
