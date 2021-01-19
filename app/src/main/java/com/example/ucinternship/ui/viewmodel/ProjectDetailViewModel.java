package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.response.ProjectUserResponse;
import com.example.ucinternship.model.response.SupervisorResponse;
import com.example.ucinternship.repository.ProfileRepository;
import com.example.ucinternship.repository.ProjectRepository;

public class ProjectDetailViewModel extends ViewModel {
    private ProjectRepository projectRepository;

    public ProjectDetailViewModel() {

    }

    public void init(String token) {
        projectRepository = ProjectRepository.getInstance(token);
    }

    public MutableLiveData<ProjectUserResponse> acceptStudent(int user_id, int project_id) {
        return projectRepository.acceptStudent(user_id, project_id);
    }
    public MutableLiveData<ProjectUserResponse> declineStudent(int user_id, int project_id) {
        return projectRepository.declineStudent(user_id, project_id);
    }

    public MutableLiveData<ProjectUserResponse> applyToAProject(int user_id, int project_id) {
        return projectRepository.applyToAProject(user_id, project_id);
    }
}
