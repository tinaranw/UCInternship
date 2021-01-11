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


}
