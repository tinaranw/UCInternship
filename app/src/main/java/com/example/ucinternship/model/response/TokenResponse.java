package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TokenResponse {

    @SerializedName("token_type")
    String tokenType;

    @SerializedName("expires_in")
    String expiresIn;

    @SerializedName("access_token")
    String accessToken;

    @SerializedName("refresh_token")
    String refreshToken;

    @SerializedName("user_id")
    int user_id;

    @SerializedName("role")
    String role;


    public String getTokenType() {
        return tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getRole() {
        return role;
    }

    public String getAuthorization(){
        return this.tokenType + " " + this.accessToken;
    }

}
