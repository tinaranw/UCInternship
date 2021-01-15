package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project implements Parcelable {

    @SerializedName("id")
    private String project_id;
    @SerializedName("name")
    private String project_name;
    @SerializedName("description")
    private String project_description;
    @SerializedName("deadline")
    private String project_deadline;
    @SerializedName("status")
    private String project_status;
    @SerializedName("category")
    private String project_category;
    @SerializedName("period")
    private Period project_period;
    @SerializedName("supervisor")
    private Supervisor project_spv;
    @SerializedName("applicants")
    private List<ProjectUser> applicants;

    public Project(){}

    public Project(String project_id, String project_name, String project_description, String project_deadline, String project_status, String project_category, Period project_period, Supervisor project_spv, List<ProjectUser> applicants) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_deadline = project_deadline;
        this.project_status = project_status;
        this.project_category = project_category;
        this.project_period = project_period;
        this.project_spv = project_spv;
        this.applicants = applicants;
    }

    protected Project(Parcel in) {
        project_id = in.readString();
        project_name = in.readString();
        project_description = in.readString();
        project_deadline = in.readString();
        project_status = in.readString();
        project_category = in.readString();
        project_period = in.readParcelable(Period.class.getClassLoader());
        project_spv = in.readParcelable(Supervisor.class.getClassLoader());
        applicants = in.createTypedArrayList(ProjectUser.CREATOR);
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_deadline() {
        return project_deadline;
    }

    public void setProject_deadline(String project_deadline) {
        this.project_deadline = project_deadline;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public String getProject_category() {
        return project_category;
    }

    public void setProject_category(String project_category) {
        this.project_category = project_category;
    }

    public Period getProject_period() {
        return project_period;
    }

    public void setProject_period(Period project_period) {
        this.project_period = project_period;
    }

    public Supervisor getProject_spv() {
        return project_spv;
    }

    public void setProject_spv(Supervisor project_spv) {
        this.project_spv = project_spv;
    }

    public List<ProjectUser> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<ProjectUser> applicants) {
        this.applicants = applicants;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(project_id);
        dest.writeString(project_name);
        dest.writeString(project_description);
        dest.writeString(project_deadline);
        dest.writeString(project_status);
        dest.writeString(project_category);
        dest.writeParcelable(project_period, flags);
        dest.writeParcelable(project_spv, flags);
        dest.writeTypedList(applicants);
    }
}
