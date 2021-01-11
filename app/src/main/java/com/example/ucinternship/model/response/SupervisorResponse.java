package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Supervisor;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SupervisorResponse {
    @SerializedName("data")
    private List<Supervisor> supervisor_data;

    public SupervisorResponse() {
    }

    public SupervisorResponse(List<Supervisor> supervisor_data) {
        this.supervisor_data = supervisor_data;
    }

    public List<Supervisor> getSupervisor_data() {
        return supervisor_data;
    }

    public void setSupervisor_data(List<Supervisor> supervisor_data) {
        this.supervisor_data = supervisor_data;
    }
}
