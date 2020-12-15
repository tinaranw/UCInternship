package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Period implements Parcelable {

    @SerializedName("id")
    private String period_id;
    @SerializedName("term")
    private String period_term;
    @SerializedName("start")
    private String period_start;
    @SerializedName("end")
    private String period_end;

    public Period(){}


    public Period(String period_id, String period_term, String period_start, String period_end) {
        this.period_id = period_id;
        this.period_term = period_term;
        this.period_start = period_start;
        this.period_end = period_end;
    }

    public String getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(String period_id) {
        this.period_id = period_id;
    }

    public String getPeriod_term() {
        return period_term;
    }

    public void setPeriod_term(String period_term) {
        this.period_term = period_term;
    }

    public String getPeriod_start() {
        return period_start;
    }

    public void setPeriod_start(String period_start) {
        this.period_start = period_start;
    }

    public String getPeriod_end() {
        return period_end;
    }

    public void setPeriod_end(String period_end) {
        this.period_end = period_end;
    }

    protected Period(Parcel in) {
        period_id = in.readString();
        period_term = in.readString();
        period_start = in.readString();
        period_end = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(period_id);
        dest.writeString(period_term);
        dest.writeString(period_start);
        dest.writeString(period_end);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Period> CREATOR = new Creator<Period>() {
        @Override
        public Period createFromParcel(Parcel in) {
            return new Period(in);
        }

        @Override
        public Period[] newArray(int size) {
            return new Period[size];
        }
    };
}
