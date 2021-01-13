package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.ucinternship.repository.ProjectRepository;
import com.example.ucinternship.repository.TaskRepository;

public class TaskDetailViewModel extends ViewModel {
    private TaskRepository taskRepository;

    public TaskDetailViewModel() {

    }

    public void init(String token) {
        taskRepository = TaskRepository.getInstance(token);
    }
}
