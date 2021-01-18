package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Task implements Parcelable {

    @SerializedName("id")
    private int task_id;
    @SerializedName("name")
    private String task_name;
    @SerializedName("description")
    private String task_description;
    @SerializedName("deadline")
    private String task_deadline;
    @SerializedName("duration")
    private float task_duration;
    @SerializedName("status")
    private String task_approved;
    @SerializedName("pu_id")
    private String task_pu;

    public Task(){}

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
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

    public float getTask_duration() {
        return task_duration;
    }

    public void setTask_duration(float task_duration) {
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

    public Task(int task_id, String task_name, String task_description, String task_deadline, float task_duration, String task_approved, String task_pu) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_deadline = task_deadline;
        this.task_duration = task_duration;
        this.task_approved = task_approved;
        this.task_pu = task_pu;
    }

    protected Task(Parcel in) {
        task_id = in.readInt();
        task_name = in.readString();
        task_description = in.readString();
        task_deadline = in.readString();
        task_duration = in.readFloat();
        task_approved = in.readString();
        task_pu = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(task_id);
        dest.writeString(task_name);
        dest.writeString(task_description);
        dest.writeString(task_deadline);
        dest.writeFloat(task_duration);
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
