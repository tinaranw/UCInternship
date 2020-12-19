package com.example.ucinternship.model.response;

import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    //yang sesuai dengan yang ada di header (ex: postman)

    @SerializedName("token_type")
    String tokenType;

    @SerializedName("expires_in")
    String expiresIn;

    @SerializedName("access_token")
    String accessToken;

    @SerializedName("refresh_token")
    String refreshToken;

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

    //bentuk penulisannya
    //Bearer (tokenType) accesstoken
    //ini bisa dilihat di header authoriz
    public String getAuthorization(){
        return this.tokenType + " " + this.accessToken;
    }
}
