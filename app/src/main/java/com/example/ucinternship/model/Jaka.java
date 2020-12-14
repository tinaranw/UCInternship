package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Jaka implements Parcelable {

    @SerializedName("id")
    private String jaka_id;
    @SerializedName("name")
    private String jaka_name;

    public Jaka(){}

    public Jaka(String jaka_id, String jaka_name) {
        this.jaka_id = jaka_id;
        this.jaka_name = jaka_name;
    }

    public String getJaka_id() {
        return jaka_id;
    }

    public void setJaka_id(String jaka_id) {
        this.jaka_id = jaka_id;
    }

    public String getJaka_name() {
        return jaka_name;
    }

    public void setJaka_name(String jaka_name) {
        this.jaka_name = jaka_name;
    }

    protected Jaka(Parcel in) {
        jaka_id = in.readString();
        jaka_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(jaka_id);
        dest.writeString(jaka_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Jaka> CREATOR = new Creator<Jaka>() {
        @Override
        public Jaka createFromParcel(Parcel in) {
            return new Jaka(in);
        }

        @Override
        public Jaka[] newArray(int size) {
            return new Jaka[size];
        }
    };
}
