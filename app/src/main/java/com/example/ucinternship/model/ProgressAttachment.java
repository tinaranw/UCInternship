package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProgressAttachment implements Parcelable {

    @SerializedName("id")
    private String progress_attch_id;
    @SerializedName("name")
    private String progress_attch_name;
    @SerializedName("progress_id")
    private String progress_attch_progress;

    public ProgressAttachment(){}


    public ProgressAttachment(String progress_attch_id, String progress_attch_name, String progress_attch_progress) {
        this.progress_attch_id = progress_attch_id;
        this.progress_attch_name = progress_attch_name;
        this.progress_attch_progress = progress_attch_progress;
    }

    public String getProgress_attch_id() {
        return progress_attch_id;
    }

    public void setProgress_attch_id(String progress_attch_id) {
        this.progress_attch_id = progress_attch_id;
    }

    public String getProgress_attch_name() {
        return progress_attch_name;
    }

    public void setProgress_attch_name(String progress_attch_name) {
        this.progress_attch_name = progress_attch_name;
    }

    public String getProgress_attch_progress() {
        return progress_attch_progress;
    }

    public void setProgress_attch_progress(String progress_attch_progress) {
        this.progress_attch_progress = progress_attch_progress;
    }


    protected ProgressAttachment(Parcel in) {
        progress_attch_id = in.readString();
        progress_attch_name = in.readString();
        progress_attch_progress = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(progress_attch_id);
        dest.writeString(progress_attch_name);
        dest.writeString(progress_attch_progress);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProgressAttachment> CREATOR = new Creator<ProgressAttachment>() {
        @Override
        public ProgressAttachment createFromParcel(Parcel in) {
            return new ProgressAttachment(in);
        }

        @Override
        public ProgressAttachment[] newArray(int size) {
            return new ProgressAttachment[size];
        }
    };
}
