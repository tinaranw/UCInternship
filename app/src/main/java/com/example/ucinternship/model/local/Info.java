package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info {

    @SerializedName("time_remaining")
    private String info_time;
    @SerializedName("gpa")
    private String info_gpa;
    @SerializedName("scholarship")
    private List<Scholarship> info_scholarship;

    public Info(){}

    public Info(String info_time, String info_gpa, List<Scholarship> info_scholarship) {
        this.info_time = info_time;
        this.info_gpa = info_gpa;
        this.info_scholarship = info_scholarship;
    }

    public String getInfo_time() {
        return info_time;
    }

    public void setInfo_time(String info_time) {
        this.info_time = info_time;
    }

    public String getInfo_gpa() {
        return info_gpa;
    }

    public void setInfo_gpa(String info_gpa) {
        this.info_gpa = info_gpa;
    }

    public List<Scholarship> getInfo_scholarship() {
        return info_scholarship;
    }

    public void setInfo_scholarship(List<Scholarship> info_scholarship) {
        this.info_scholarship = info_scholarship;
    }
}
