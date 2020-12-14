package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Roles implements Parcelable {

    @SerializedName("id")
    private String role_id;
    @SerializedName("name")
    private String role_name;

    public Roles(){}

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }


    public Roles(String role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    protected Roles(Parcel in) {
        role_id = in.readString();
        role_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(role_id);
        dest.writeString(role_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Roles> CREATOR = new Creator<Roles>() {
        @Override
        public Roles createFromParcel(Parcel in) {
            return new Roles(in);
        }

        @Override
        public Roles[] newArray(int size) {
            return new Roles[size];
        }
    };
}
