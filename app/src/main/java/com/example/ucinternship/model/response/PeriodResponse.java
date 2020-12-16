package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Period;
import com.example.ucinternship.model.local.Project;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeriodResponse {
    @SerializedName("data")
    private List<Period> results;

    public List<Period> getResults(){
        return results;
    }
}
