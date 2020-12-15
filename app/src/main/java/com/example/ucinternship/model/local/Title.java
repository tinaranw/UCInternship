package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Title implements Parcelable {

    @SerializedName("id")
    private String title_id;
    @SerializedName("name")
    private String title_name;

    public Title(){}


    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public Title(String title_id, String title_name) {
        this.title_id = title_id;
        this.title_name = title_name;
    }


    protected Title(Parcel in) {
        title_id = in.readString();
        title_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title_id);
        dest.writeString(title_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Title> CREATOR = new Creator<Title>() {
        @Override
        public Title createFromParcel(Parcel in) {
            return new Title(in);
        }

        @Override
        public Title[] newArray(int size) {
            return new Title[size];
        }
    };
}
