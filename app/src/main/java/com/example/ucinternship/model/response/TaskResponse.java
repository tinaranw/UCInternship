package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Task;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskResponse {
    @SerializedName("data")
    private List<Task> results;
    public List<Task> getResults(){
        return results;
    }
}
