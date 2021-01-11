package com.example.ucinternship.network;

import com.example.ucinternship.model.response.ProjectResponse;
import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.model.response.UserResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Endpoints {

    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @GET("projects")
    Call<ProjectResponse> getProjects();

    @POST("user")
    Call<UserResponse> user();

    //    @Headers({})
    @POST("api-logout")
    Call<JsonObject> logout();
}
