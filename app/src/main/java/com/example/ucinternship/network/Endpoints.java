package com.example.ucinternship.network;

import com.example.ucinternship.model.response.AcceptResponse;
import com.example.ucinternship.model.response.PendingResponse;
import com.example.ucinternship.model.response.ProjectUserResponse;
import com.example.ucinternship.model.response.StudentProgressResponse;
import com.example.ucinternship.model.response.ProjectResponse;
import com.example.ucinternship.model.response.StudentResponse;
import com.example.ucinternship.model.response.SupervisorProgressResponse;
import com.example.ucinternship.model.response.SupervisorResponse;
import com.example.ucinternship.model.response.TaskResponse;
import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.model.response.UserResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Endpoints {

    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @GET("project")
    Call<ProjectResponse> getProjects();

    @GET("projects/event")
    Call<ProjectResponse> getEvent();

    @GET("projects/education")
    Call<ProjectResponse> getEducation();

    @GET("projects/other")
    Call<ProjectResponse> getOther();

    @POST("user")
    Call<UserResponse> user();

    //    @Headers({})
    @GET("offer")
    Call<ProjectResponse> getProjectOffers();

    @GET("offers/event")
    Call<ProjectResponse> getEventOffer();

    @GET("offers/education")
    Call<ProjectResponse> getEducationOffer();

    @GET("offers/other")
    Call<ProjectResponse> getOtherOffer();

    @GET("task")
    Call<TaskResponse> getTasks();

    @GET("student/progress")
    Call<StudentProgressResponse> getProgresses();

    @GET("supervisor/progress")
    Call<SupervisorProgressResponse> getSpvProgresses();

    @GET("pending")
    Call<PendingResponse> getPending();

    @GET("accept")
    Call<AcceptResponse> getAccept();

    @POST("api-logout")
    Call<JsonObject> logout();

    @GET("student/user/{id}")
    Call<StudentResponse> getStudentDetails(@Path("id") int id);

    @GET("supervisor/user/{id}")
    Call<SupervisorResponse> getSupervisorDetails(@Path("id") int id);

    @PUT("student/user/{id}")
    @FormUrlEncoded
    Call<StudentResponse> updateStudent(@Path("id") int id, @Field("phone") String phone, @Field("line_account") String line_account);

    @PUT("supervisor/user/{id}")
    @FormUrlEncoded
    Call<SupervisorResponse> updateSupervisor(@Path("id") int id, @Field("phone") String phone, @Field("line_account") String line_account);

    @POST("supervisor/applicant/accept")
    @FormUrlEncoded
    Call<ProjectUserResponse> acceptStudent(@Field("user_id") int user_id, @Field("project_id") int project_id);

    @POST("supervisor/applicant/decline")
    @FormUrlEncoded
    Call<ProjectUserResponse> declineStudent(@Field("user_id") int user_id, @Field("project_id") int project_id);

    @POST("project/tasks")
    @FormUrlEncoded
    Call<TaskResponse> getTaskLists(@Field("project_id") int project_id);
}
