package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Project;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProgressResponse {
    @SerializedName("data")
    private Progress results;

    public Progress getResults(){
        return results;
    }
}
