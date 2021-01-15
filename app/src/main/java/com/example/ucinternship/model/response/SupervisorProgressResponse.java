package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Progress;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SupervisorProgressResponse {

    @SerializedName("data")
    private List<Progress> results;
    public List<Progress> getResults(){
        return results;
    }
}
