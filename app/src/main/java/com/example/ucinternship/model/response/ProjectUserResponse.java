package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.ProjectUser;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectUserResponse {
    @SerializedName("data")
    private List<ProjectUser> results;

    public List<ProjectUser> getResults(){
        return results;
    }
}
