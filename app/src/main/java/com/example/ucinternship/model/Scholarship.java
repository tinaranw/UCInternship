package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Scholarship implements Parcelable {

    @SerializedName("id")
    private String sch_id;
    @SerializedName("name")
    private String sch_name;
    @SerializedName("grade")
    private String sch_grade;
    @SerializedName("duration")
    private String sch_duration;
    @SerializedName("minimum_gpa")
    private String sch_min;
    @SerializedName("hps")
    private String sch_hps;

    public Scholarship(){}

    public String getSch_id() {
        return sch_id;
    }

    public void setSch_id(String sch_id) {
        this.sch_id = sch_id;
    }

    public String getSch_name() {
        return sch_name;
    }

    public void setSch_name(String sch_name) {
        this.sch_name = sch_name;
    }

    public String getSch_grade() {
        return sch_grade;
    }

    public void setSch_grade(String sch_grade) {
        this.sch_grade = sch_grade;
    }

    public String getSch_duration() {
        return sch_duration;
    }

    public void setSch_duration(String sch_duration) {
        this.sch_duration = sch_duration;
    }

    public String getSch_min() {
        return sch_min;
    }

    public void setSch_min(String sch_min) {
        this.sch_min = sch_min;
    }

    public String getSch_hps() {
        return sch_hps;
    }

    public void setSch_hps(String sch_hps) {
        this.sch_hps = sch_hps;
    }


    public Scholarship(String sch_id, String sch_name, String sch_grade, String sch_duration, String sch_min, String sch_hps) {
        this.sch_id = sch_id;
        this.sch_name = sch_name;
        this.sch_grade = sch_grade;
        this.sch_duration = sch_duration;
        this.sch_min = sch_min;
        this.sch_hps = sch_hps;
    }



    protected Scholarship(Parcel in) {
        sch_id = in.readString();
        sch_name = in.readString();
        sch_grade = in.readString();
        sch_duration = in.readString();
        sch_min = in.readString();
        sch_hps = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sch_id);
        dest.writeString(sch_name);
        dest.writeString(sch_grade);
        dest.writeString(sch_duration);
        dest.writeString(sch_min);
        dest.writeString(sch_hps);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Scholarship> CREATOR = new Creator<Scholarship>() {
        @Override
        public Scholarship createFromParcel(Parcel in) {
            return new Scholarship(in);
        }

        @Override
        public Scholarship[] newArray(int size) {
            return new Scholarship[size];
        }
    };
}
