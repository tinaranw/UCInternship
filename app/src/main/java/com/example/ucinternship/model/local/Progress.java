package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Progress implements Parcelable {

    @SerializedName("id")
    private String progress_id;
    @SerializedName("description")
    private String progress_description;
    @SerializedName("time_start")
    private String progress_start;
    @SerializedName("time_end")
    private String progress_end;
    @SerializedName("isApproved")
    private String progress_approved;
    @SerializedName("comment")
    private String progress_comment;
    @SerializedName("task_id")
    private String progress_task;

    public Progress(){}

    public String getProgress_id() {
        return progress_id;
    }

    public void setProgress_id(String progress_id) {
        this.progress_id = progress_id;
    }

    public String getProgress_description() {
        return progress_description;
    }

    public void setProgress_description(String progress_description) {
        this.progress_description = progress_description;
    }

    public String getProgress_start() {
        return progress_start;
    }

    public void setProgress_start(String progress_start) {
        this.progress_start = progress_start;
    }

    public String getProgress_end() {
        return progress_end;
    }

    public void setProgress_end(String progress_end) {
        this.progress_end = progress_end;
    }

    public String getProgress_approved() {
        return progress_approved;
    }

    public void setProgress_approved(String progress_approved) {
        this.progress_approved = progress_approved;
    }

    public String getProgress_comment() {
        return progress_comment;
    }

    public void setProgress_comment(String progress_comment) {
        this.progress_comment = progress_comment;
    }

    public String getProgress_task() {
        return progress_task;
    }

    public void setProgress_task(String progress_task) {
        this.progress_task = progress_task;
    }


    public Progress(String progress_id, String progress_description, String progress_start, String progress_end, String progress_approved, String progress_comment, String progress_task) {
        this.progress_id = progress_id;
        this.progress_description = progress_description;
        this.progress_start = progress_start;
        this.progress_end = progress_end;
        this.progress_approved = progress_approved;
        this.progress_comment = progress_comment;
        this.progress_task = progress_task;
    }

    protected Progress(Parcel in) {
        progress_id = in.readString();
        progress_description = in.readString();
        progress_start = in.readString();
        progress_end = in.readString();
        progress_approved = in.readString();
        progress_comment = in.readString();
        progress_task = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(progress_id);
        dest.writeString(progress_description);
        dest.writeString(progress_start);
        dest.writeString(progress_end);
        dest.writeString(progress_approved);
        dest.writeString(progress_comment);
        dest.writeString(progress_task);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Progress> CREATOR = new Creator<Progress>() {
        @Override
        public Progress createFromParcel(Parcel in) {
            return new Progress(in);
        }

        @Override
        public Progress[] newArray(int size) {
            return new Progress[size];
        }
    };
}
