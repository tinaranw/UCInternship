package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.ucinternship.repository.ProfileRepository;
import com.example.ucinternship.repository.ProjectRepository;

public class ProjectDetailViewModel extends ViewModel {
    private ProjectRepository projectRepository;

    public ProjectDetailViewModel() {

    }

    public void init(String token) {
        projectRepository = ProjectRepository.getInstance(token);
    }
}
