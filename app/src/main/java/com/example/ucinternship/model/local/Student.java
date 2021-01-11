package com.example.ucinternship.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student implements Parcelable{

    @SerializedName("user_id")
    private int student_user_id;
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
    @SerializedName("department_name")
    private String student_department_name;
    @SerializedName("department_initial")
    private String student_department_initial;
    @SerializedName("info")
    private List<Info> student_info;

    public Student() {
    }

    public Student(int student_user_id, String student_nim, String student_name, String student_email, String batch, String student_desc, String student_photo, String student_gender, String student_phone, String student_line, String student_department_name, String student_department_initial, List<Info> student_info) {
        this.student_user_id = student_user_id;
        this.student_nim = student_nim;
        this.student_name = student_name;
        this.student_email = student_email;
        this.batch = batch;
        this.student_desc = student_desc;
        this.student_photo = student_photo;
        this.student_gender = student_gender;
        this.student_phone = student_phone;
        this.student_line = student_line;
        this.student_department_name = student_department_name;
        this.student_department_initial = student_department_initial;
        this.student_info = student_info;
    }

    protected Student(Parcel in) {
        student_user_id = in.readInt();
        student_nim = in.readString();
        student_name = in.readString();
        student_email = in.readString();
        batch = in.readString();
        student_desc = in.readString();
        student_photo = in.readString();
        student_gender = in.readString();
        student_phone = in.readString();
        student_line = in.readString();
        student_department_name = in.readString();
        student_department_initial = in.readString();
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

    public int getStudent_user_id() {
        return student_user_id;
    }

    public void setStudent_user_id(int student_user_id) {
        this.student_user_id = student_user_id;
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

    public String getStudent_department_name() {
        return student_department_name;
    }

    public void setStudent_department_name(String student_department_name) {
        this.student_department_name = student_department_name;
    }

    public String getStudent_department_initial() {
        return student_department_initial;
    }

    public void setStudent_department_initial(String student_department_initial) {
        this.student_department_initial = student_department_initial;
    }

    public List<Info> getStudent_info() {
        return student_info;
    }

    public void setStudent_info(List<Info> student_info) {
        this.student_info = student_info;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(student_user_id);
        parcel.writeString(student_nim);
        parcel.writeString(student_name);
        parcel.writeString(student_email);
        parcel.writeString(batch);
        parcel.writeString(student_desc);
        parcel.writeString(student_photo);
        parcel.writeString(student_gender);
        parcel.writeString(student_phone);
        parcel.writeString(student_line);
        parcel.writeString(student_department_name);
        parcel.writeString(student_department_initial);
    }
}
