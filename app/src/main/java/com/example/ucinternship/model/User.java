package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("id")
    private String user_id;
    @SerializedName("name")
    private String user_name;
    @SerializedName("email")
    private String user_email;
    @SerializedName("password")
    private String user_password;
    @SerializedName("detailable_id")
    private String user_detailable;
    @SerializedName("detailable_type")
    private String user_type;
    @SerializedName("info_id")
    private String user_info;

    public User(){}

    public User(String user_id, String user_name, String user_email, String user_password, String user_detailable, String user_type, String user_info) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_detailable = user_detailable;
        this.user_type = user_type;
        this.user_info = user_info;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_detailable() {
        return user_detailable;
    }

    public void setUser_detailable(String user_detailable) {
        this.user_detailable = user_detailable;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }


    protected User(Parcel in) {
        user_id = in.readString();
        user_name = in.readString();
        user_email = in.readString();
        user_password = in.readString();
        user_detailable = in.readString();
        user_type = in.readString();
        user_info = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeString(user_name);
        dest.writeString(user_email);
        dest.writeString(user_password);
        dest.writeString(user_detailable);
        dest.writeString(user_type);
        dest.writeString(user_info);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
