package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectUser implements Parcelable {

    @SerializedName("id")
    private int pu_id;
    @SerializedName("user")
    private User user;
    @SerializedName("project_id")
    private int project_id;
    @SerializedName("status")
    private String status;
    @SerializedName("tasks")
    private List<Task> tasks;

    public ProjectUser() {

    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public ProjectUser(int pu_id, User user, int project_id, String status, List<Task> tasks) {
        this.pu_id = pu_id;
        this.user = user;
        this.project_id = project_id;
        this.status = status;
        this.tasks = tasks;
    }

    protected ProjectUser(Parcel in) {
        pu_id = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        project_id = in.readInt();
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

    public int getPu_id() {
        return pu_id;
    }

    public void setPu_id(int pu_id) {
        this.pu_id = pu_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        dest.writeInt(pu_id);
        dest.writeParcelable(user, flags);
        dest.writeInt(project_id);
        dest.writeString(status);
        dest.writeTypedList(tasks);
    }
}
