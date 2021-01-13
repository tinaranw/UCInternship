package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.repository.ProjectRepository;
import com.example.ucinternship.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends ViewModel {
    private TaskRepository repository;

    public TaskViewModel() {

    }

    public void init(String token) {
        repository = TaskRepository.getInstance(token);
    }

    public LiveData<List<Task>> getTasks() {
        return repository.getTasks();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
