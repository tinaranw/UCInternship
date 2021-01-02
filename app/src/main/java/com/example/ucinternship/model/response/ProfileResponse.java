package com.example.ucinternship.model.response;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse {

    @SerializedName("nim")
    String nim;

    @SerializedName("name")
    String name;

    @SerializedName("department")
    String department;

    @SerializedName("email")
    String email;

    @SerializedName("address")
    String address;


}
