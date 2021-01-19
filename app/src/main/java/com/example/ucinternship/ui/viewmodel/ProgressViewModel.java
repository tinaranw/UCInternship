package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.response.ProgressResponse;
import com.example.ucinternship.model.response.StudentResponse;
import com.example.ucinternship.model.response.SupervisorResponse;
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
    public LiveData<List<Progress>> getProgressLists(int task_id) {
        return repository.getProgressLists(task_id);
    }

    public LiveData<List<Progress>> getSpvProgresses() {
        return repository.getSpvProgresses();
    }
    public MutableLiveData<ProgressResponse> approveProgress(int progress_id, String comment) {
        return repository.approveProgress(progress_id, comment);
    }
    public MutableLiveData<ProgressResponse> declineProgress(int progress_id, String comment) {
        return repository.declineProgress(progress_id, comment);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
