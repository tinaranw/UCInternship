package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Department implements Parcelable {

    @SerializedName("id")
    private String department_id;
    @SerializedName("initial")
    private String department_initial;
    @SerializedName("name")
    private String department_name;

    public Department(){}

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_initial() {
        return department_initial;
    }

    public void setDepartment_initial(String department_initial) {
        this.department_initial = department_initial;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Department(String department_id, String department_initial, String department_name) {
        this.department_id = department_id;
        this.department_initial = department_initial;
        this.department_name = department_name;
    }


    protected Department(Parcel in) {
        department_id = in.readString();
        department_initial = in.readString();
        department_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(department_id);
        dest.writeString(department_initial);
        dest.writeString(department_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Department> CREATOR = new Creator<Department>() {
        @Override
        public Department createFromParcel(Parcel in) {
            return new Department(in);
        }

        @Override
        public Department[] newArray(int size) {
            return new Department[size];
        }
    };
}
