package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Project;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcceptResponse {


    @SerializedName("data")
    private List<Project> results;
    public List<Project> getResults(){
        return results;
    }

}
