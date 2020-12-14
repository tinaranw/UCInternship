package com.example.ucinternship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Lecturer implements Parcelable {

    @SerializedName("id")
    private String lect_id;
    @SerializedName("nip")
    private String lect_nip;
    @SerializedName("nidn")
    private String lect_nidn;
    @SerializedName("name")
    private String lect_name;
    @SerializedName("email")
    private String lect_email;
    @SerializedName("description")
    private String lect_desc;
    @SerializedName("photo")
    private String lect_photo;
    @SerializedName("gender")
    private String lect_gender;
    @SerializedName("phone")
    private String lect_phone;
    @SerializedName("line_account")
    private String lect_line;
    @SerializedName("departement_id")
    private String lect_departement;
    @SerializedName("title_id")
    private String lect_title;
    @SerializedName("jaka_id")
    private String lect_jaka;

    public Lecturer(){}

    public Lecturer(String lect_id, String lect_nip, String lect_nidn, String lect_name, String lect_email, String lect_desc, String lect_photo, String lect_gender, String lect_phone, String lect_line, String lect_departement, String lect_title, String lect_jaka) {
        this.lect_id = lect_id;
        this.lect_nip = lect_nip;
        this.lect_nidn = lect_nidn;
        this.lect_name = lect_name;
        this.lect_email = lect_email;
        this.lect_desc = lect_desc;
        this.lect_photo = lect_photo;
        this.lect_gender = lect_gender;
        this.lect_phone = lect_phone;
        this.lect_line = lect_line;
        this.lect_departement = lect_departement;
        this.lect_title = lect_title;
        this.lect_jaka = lect_jaka;
    }


    public String getLect_id() {
        return lect_id;
    }

    public void setLect_id(String lect_id) {
        this.lect_id = lect_id;
    }

    public String getLect_nip() {
        return lect_nip;
    }

    public void setLect_nip(String lect_nip) {
        this.lect_nip = lect_nip;
    }

    public String getLect_nidn() {
        return lect_nidn;
    }

    public void setLect_nidn(String lect_nidn) {
        this.lect_nidn = lect_nidn;
    }

    public String getLect_name() {
        return lect_name;
    }

    public void setLect_name(String lect_name) {
        this.lect_name = lect_name;
    }

    public String getLect_email() {
        return lect_email;
    }

    public void setLect_email(String lect_email) {
        this.lect_email = lect_email;
    }

    public String getLect_desc() {
        return lect_desc;
    }

    public void setLect_desc(String lect_desc) {
        this.lect_desc = lect_desc;
    }

    public String getLect_photo() {
        return lect_photo;
    }

    public void setLect_photo(String lect_photo) {
        this.lect_photo = lect_photo;
    }

    public String getLect_gender() {
        return lect_gender;
    }

    public void setLect_gender(String lect_gender) {
        this.lect_gender = lect_gender;
    }

    public String getLect_phone() {
        return lect_phone;
    }

    public void setLect_phone(String lect_phone) {
        this.lect_phone = lect_phone;
    }

    public String getLect_line() {
        return lect_line;
    }

    public void setLect_line(String lect_line) {
        this.lect_line = lect_line;
    }

    public String getLect_departement() {
        return lect_departement;
    }

    public void setLect_departement(String lect_departement) {
        this.lect_departement = lect_departement;
    }

    public String getLect_title() {
        return lect_title;
    }

    public void setLect_title(String lect_title) {
        this.lect_title = lect_title;
    }

    public String getLect_jaka() {
        return lect_jaka;
    }

    public void setLect_jaka(String lect_jaka) {
        this.lect_jaka = lect_jaka;
    }

    protected Lecturer(Parcel in) {
        lect_id = in.readString();
        lect_nip = in.readString();
        lect_nidn = in.readString();
        lect_name = in.readString();
        lect_email = in.readString();
        lect_desc = in.readString();
        lect_photo = in.readString();
        lect_gender = in.readString();
        lect_phone = in.readString();
        lect_line = in.readString();
        lect_departement = in.readString();
        lect_title = in.readString();
        lect_jaka = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lect_id);
        dest.writeString(lect_nip);
        dest.writeString(lect_nidn);
        dest.writeString(lect_name);
        dest.writeString(lect_email);
        dest.writeString(lect_desc);
        dest.writeString(lect_photo);
        dest.writeString(lect_gender);
        dest.writeString(lect_phone);
        dest.writeString(lect_line);
        dest.writeString(lect_departement);
        dest.writeString(lect_title);
        dest.writeString(lect_jaka);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Lecturer> CREATOR = new Creator<Lecturer>() {
        @Override
        public Lecturer createFromParcel(Parcel in) {
            return new Lecturer(in);
        }

        @Override
        public Lecturer[] newArray(int size) {
            return new Lecturer[size];
        }
    };
}
