package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Task implements Parcelable {

    @SerializedName("id")
    private String task_id;
    @SerializedName("name")
    private String task_name;
    @SerializedName("description")
    private String task_description;
    @SerializedName("deadline")
    private String task_deadline;
    @SerializedName("duration")
    private String task_duration;
    @SerializedName("is_approved")
    private String task_approved;
    @SerializedName("pu_id")
    private String task_pu;

    public Task(){}

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_deadline() {
        return task_deadline;
    }

    public void setTask_deadline(String task_deadline) {
        this.task_deadline = task_deadline;
    }

    public String getTask_duration() {
        return task_duration;
    }

    public void setTask_duration(String task_duration) {
        this.task_duration = task_duration;
    }

    public String getTask_approved() {
        return task_approved;
    }

    public void setTask_approved(String task_approved) {
        this.task_approved = task_approved;
    }

    public String getTask_pu() {
        return task_pu;
    }

    public void setTask_pu(String task_pu) {
        this.task_pu = task_pu;
    }

    public Task(String task_id, String task_name, String task_description, String task_deadline, String task_duration, String task_approved, String task_pu) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_deadline = task_deadline;
        this.task_duration = task_duration;
        this.task_approved = task_approved;
        this.task_pu = task_pu;
    }

    protected Task(Parcel in) {
        task_id = in.readString();
        task_name = in.readString();
        task_description = in.readString();
        task_deadline = in.readString();
        task_duration = in.readString();
        task_approved = in.readString();
        task_pu = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(task_id);
        dest.writeString(task_name);
        dest.writeString(task_description);
        dest.writeString(task_deadline);
        dest.writeString(task_duration);
        dest.writeString(task_approved);
        dest.writeString(task_pu);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
