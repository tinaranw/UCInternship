package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Info implements Parcelable {

    @SerializedName("id")
    private String info_id;
    @SerializedName("time_remaining")
    private String info_time;
    @SerializedName("gpa")
    private String info_gpa;
    @SerializedName("cv")
    private String info_cv;
    @SerializedName("scholarship_id")
    private String info_scholarship;

    public Info(){}


    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
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

    public String getInfo_cv() {
        return info_cv;
    }

    public void setInfo_cv(String info_cv) {
        this.info_cv = info_cv;
    }

    public String getInfo_scholarship() {
        return info_scholarship;
    }

    public void setInfo_scholarship(String info_scholarship) {
        this.info_scholarship = info_scholarship;
    }


    public Info(String info_id, String info_time, String info_gpa, String info_cv, String info_scholarship) {
        this.info_id = info_id;
        this.info_time = info_time;
        this.info_gpa = info_gpa;
        this.info_cv = info_cv;
        this.info_scholarship = info_scholarship;
    }


    protected Info(Parcel in) {
        info_id = in.readString();
        info_time = in.readString();
        info_gpa = in.readString();
        info_cv = in.readString();
        info_scholarship = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(info_id);
        dest.writeString(info_time);
        dest.writeString(info_gpa);
        dest.writeString(info_cv);
        dest.writeString(info_scholarship);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };
}
