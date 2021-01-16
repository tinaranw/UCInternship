package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.repository.ProjectRepository;

import java.util.List;

public class ProjectViewModel extends ViewModel {
    private ProjectRepository repository;

    public ProjectViewModel() {

    }

    public void init(String token) {
        repository = ProjectRepository.getInstance(token);
    }

    public LiveData<List<Project>> getProjects() {
        return repository.getProjects();
    }

    public LiveData<List<Project>> getProjectOffers() {
        return repository.getProjectOffers();
    }
    public LiveData<List<Project>> getPending() {
        return repository.getPending();
    }
    public LiveData<List<Project>> getAccept() {
        return repository.getAccept();
    }
    public LiveData<List<Project>> getEvent() {
        return repository.getEvent();
    }
    public LiveData<List<Project>> getEducation() {
        return repository.getEducation();
    }
    public LiveData<List<Project>> getOther() {
        return repository.getOther();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
