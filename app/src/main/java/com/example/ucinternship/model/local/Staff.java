package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Staff implements Parcelable{

    @SerializedName("id")
    private String staff_id;
    @SerializedName("nip")
    private String staff_nip;
    @SerializedName("name")
    private String staff_name;
    @SerializedName("email")
    private String staff_email;
    @SerializedName("description")
    private String staff_desc;
    @SerializedName("photo")
    private String staff_photo;
    @SerializedName("gender")
    private String staff_gender;
    @SerializedName("phone")
    private String staff_phone;
    @SerializedName("line_account")
    private String staff_line;
    @SerializedName("departement_id")
    private String staff_departement;
    @SerializedName("title_id")
    private String staff_title;

    public Staff(){}

    public Staff(String staff_id, String staff_nip, String staff_name, String staff_email, String staff_desc, String staff_photo, String staff_gender, String staff_phone, String staff_line, String staff_departement, String staff_title) {
        this.staff_id = staff_id;
        this.staff_nip = staff_nip;
        this.staff_name = staff_name;
        this.staff_email = staff_email;
        this.staff_desc = staff_desc;
        this.staff_photo = staff_photo;
        this.staff_gender = staff_gender;
        this.staff_phone = staff_phone;
        this.staff_line = staff_line;
        this.staff_departement = staff_departement;
        this.staff_title = staff_title;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_nip() {
        return staff_nip;
    }

    public void setStaff_nip(String staff_nip) {
        this.staff_nip = staff_nip;
    }

    public String getStaff_name() {
        return staff_nip;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getStaff_desc() {
        return staff_desc;
    }

    public void setStaff_desc(String staff_desc) {
        this.staff_desc = staff_desc;
    }

    public String getStaff_photo() {
        return staff_photo;
    }

    public void setStaff_photo(String staff_photo) {
        this.staff_photo = staff_photo;
    }

    public String getStaff_gender() {
        return staff_gender;
    }

    public void setStaff_gender(String staff_gender) {
        this.staff_gender = staff_gender;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_line() {
        return staff_line;
    }

    public void setStaff_line(String staff_line) {
        this.staff_line = staff_line;
    }

    public String getStaff_departement() {
        return staff_departement;
    }

    public void setStaff_departement(String staff_departement) {
        this.staff_departement = staff_departement;
    }

    public String getStaff_title() {
        return staff_title;
    }

    public void setStaff_title(String staff_title) {
        this.staff_title = staff_title;
    }

    protected Staff(Parcel in) {
        staff_id = in.readString();
        staff_nip = in.readString();
        staff_name = in.readString();
        staff_email = in.readString();
        staff_desc = in.readString();
        staff_photo = in.readString();
        staff_gender = in.readString();
        staff_phone = in.readString();
        staff_line = in.readString();
        staff_departement = in.readString();
        staff_title = in.readString();
    }

    public static final Creator<Staff> CREATOR = new Creator<Staff>() {
        @Override
        public Staff createFromParcel(Parcel in) {
            return new Staff(in);
        }

        @Override
        public Staff[] newArray(int size) {
            return new Staff[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(staff_id);
        dest.writeString(staff_nip);
        dest.writeString(staff_name);
        dest.writeString(staff_email);
        dest.writeString(staff_desc);
        dest.writeString(staff_photo);
        dest.writeString(staff_gender);
        dest.writeString(staff_phone);
        dest.writeString(staff_line);
        dest.writeString(staff_departement);
        dest.writeString(staff_title);
    }
}
