package com.example.ucinternship.model.response;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("nim")
    String nim;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("batch")
    String batch;
    @SerializedName("description")
    String description;
    @SerializedName("photo")
    String photo;
    @SerializedName("gender")
    String gender;
    @SerializedName("phone")
    String phone;
    @SerializedName("line_account")
    String line;



}
