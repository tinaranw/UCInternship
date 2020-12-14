package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProjectAttachment implements Parcelable {

    @SerializedName("id")
    private String pro_attch_id;
    @SerializedName("name")
    private String pro_attch_name;
    @SerializedName("project_id")
    private String pro_attch_project;

    public ProjectAttachment(){}

    public ProjectAttachment(String pro_attch_id, String pro_attch_name, String pro_attch_project) {
        this.pro_attch_id = pro_attch_id;
        this.pro_attch_name = pro_attch_name;
        this.pro_attch_project = pro_attch_project;
    }

    public String getPro_attch_id() {
        return pro_attch_id;
    }

    public void setPro_attch_id(String pro_attch_id) {
        this.pro_attch_id = pro_attch_id;
    }

    public String getPro_attch_name() {
        return pro_attch_name;
    }

    public void setPro_attch_name(String pro_attch_name) {
        this.pro_attch_name = pro_attch_name;
    }

    public String getPro_attch_project() {
        return pro_attch_project;
    }

    public void setPro_attch_project(String pro_attch_project) {
        this.pro_attch_project = pro_attch_project;
    }



    protected ProjectAttachment(Parcel in) {
        pro_attch_id = in.readString();
        pro_attch_name = in.readString();
        pro_attch_project = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pro_attch_id);
        dest.writeString(pro_attch_name);
        dest.writeString(pro_attch_project);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProjectAttachment> CREATOR = new Creator<ProjectAttachment>() {
        @Override
        public ProjectAttachment createFromParcel(Parcel in) {
            return new ProjectAttachment(in);
        }

        @Override
        public ProjectAttachment[] newArray(int size) {
            return new ProjectAttachment[size];
        }
    };
}
