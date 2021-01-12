package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectUser implements Parcelable {

    @SerializedName("id")
    private String pu_id;
    @SerializedName("user")
    private User user;
    @SerializedName("status")
    private String pu_status;
    @SerializedName("uci_project_id")
    private String pu_project;
    @SerializedName("uci_user_id")
    private String pu_user;
    @SerializedName("status")
    private String status;
    @SerializedName("tasks")
    private List<Task> tasks;

    public ProjectUser() {

    }

    public ProjectUser(String pu_id, User user, String pu_status, String pu_project, String pu_user, String status, List<Task> tasks) {
        this.pu_id = pu_id;
        this.user = user;
        this.pu_status = pu_status;
        this.pu_project = pu_project;
        this.pu_user = pu_user;
        this.status = status;
        this.tasks = tasks;
    }

    protected ProjectUser(Parcel in) {
        pu_id = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        pu_status = in.readString();
        pu_project = in.readString();
        pu_user = in.readString();
        status = in.readString();
        tasks = in.createTypedArrayList(Task.CREATOR);
    }

    public static final Creator<ProjectUser> CREATOR = new Creator<ProjectUser>() {
        @Override
        public ProjectUser createFromParcel(Parcel in) {
            return new ProjectUser(in);
        }

        @Override
        public ProjectUser[] newArray(int size) {
            return new ProjectUser[size];
        }
    };

    public String getPu_id() {
        return pu_id;
    }

    public void setPu_id(String pu_id) {
        this.pu_id = pu_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPu_status() {
        return pu_status;
    }

    public void setPu_status(String pu_status) {
        this.pu_status = pu_status;
    }

    public String getPu_project() {
        return pu_project;
    }

    public void setPu_project(String pu_project) {
        this.pu_project = pu_project;
    }

    public String getPu_user() {
        return pu_user;
    }

    public void setPu_user(String pu_user) {
        this.pu_user = pu_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pu_id);
        dest.writeParcelable(user, flags);
        dest.writeString(pu_status);
        dest.writeString(pu_project);
        dest.writeString(pu_user);
        dest.writeString(status);
        dest.writeTypedList(tasks);
    }
}
