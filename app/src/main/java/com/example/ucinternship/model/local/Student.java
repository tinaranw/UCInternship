package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Student implements Parcelable {

    @SerializedName("id")
    private String student_id;
    @SerializedName("nim")
    private String student_nim;
    @SerializedName("name")
    private String student_name;
    @SerializedName("email")
    private String student_email;
    @SerializedName("batch")
    private String batch;
    @SerializedName("description")
    private String student_desc;
    @SerializedName("photo")
    private String student_photo;
    @SerializedName("gender")
    private String student_gender;
    @SerializedName("phone")
    private String student_phone;
    @SerializedName("line_account")
    private String student_line;
    @SerializedName("departement_id")
    private String student_departement;

    public Student(){}

    public Student(String student_id, String student_nim, String student_name, String student_email, String batch, String student_desc, String student_photo, String student_gender, String student_phone, String student_line, String student_departement) {
        this.student_id = student_id;
        this.student_nim = student_nim;
        this.student_name = student_name;
        this.student_email = student_email;
        this.batch = batch;
        this.student_desc = student_desc;
        this.student_photo = student_photo;
        this.student_gender = student_gender;
        this.student_phone = student_phone;
        this.student_line = student_line;
        this.student_departement = student_departement;
    }

    protected Student(Parcel in) {
        student_id = in.readString();
        student_nim = in.readString();
        student_name = in.readString();
        student_email = in.readString();
        batch = in.readString();
        student_desc = in.readString();
        student_photo = in.readString();
        student_gender = in.readString();
        student_phone = in.readString();
        student_line = in.readString();
        student_departement = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_nim() {
        return student_nim;
    }

    public void setStudent_nim(String student_nim) {
        this.student_nim = student_nim;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStudent_desc() {
        return student_desc;
    }

    public void setStudent_desc(String student_desc) {
        this.student_desc = student_desc;
    }

    public String getStudent_photo() {
        return student_photo;
    }

    public void setStudent_photo(String student_photo) {
        this.student_photo = student_photo;
    }

    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_line() {
        return student_line;
    }

    public void setStudent_line(String student_line) {
        this.student_line = student_line;
    }

    public String getstudent_departement() {
        return student_departement;
    }

    public void setstudent_departement(String student_departement) {
        this.student_departement = student_departement;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(student_id);
        dest.writeString(student_nim);
        dest.writeString(student_name);
        dest.writeString(student_email);
        dest.writeString(batch);
        dest.writeString(student_desc);
        dest.writeString(student_photo);
        dest.writeString(student_gender);
        dest.writeString(student_phone);
        dest.writeString(student_line);
        dest.writeString(student_departement);
    }
}
