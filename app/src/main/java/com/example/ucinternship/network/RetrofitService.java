package com.example.ucinternship.network;

import com.example.ucinternship.model.response.StudentProgressResponse;
import com.example.ucinternship.model.response.ProjectResponse;
import com.example.ucinternship.model.response.StudentResponse;
import com.example.ucinternship.model.response.SupervisorResponse;
import com.example.ucinternship.model.response.TaskResponse;
import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.utils.Constants;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private final Endpoints api;
    private static RetrofitService service;
    private static final String TAG="RetrofitService";

    //fungsi retrofit service itu nyambungin apps dengan DB (request)

    private RetrofitService(String token) {
        OkHttpClient.Builder client =  new OkHttpClient.Builder();

        if(token.equals("")){
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            });
        } else {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", token)
                        .build();
                return chain.proceed(request);
            });
        }

        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create(Endpoints.class);
    }

    public static com.example.ucinternship.network.RetrofitService getInstance(String token) {
        if (service == null) {
            service = new com.example.ucinternship.network.RetrofitService(token);
        } else if(!token.equals("")){
            service = new com.example.ucinternship.network.RetrofitService(token);
        }
        return service;
    }

    public Call<TokenResponse> login(String email, String password){
        return api.login(email, password);
    }

    public Call<ProjectResponse> getProjects(){
        return api.getProjects();
    }
    public Call<ProjectResponse> getProjectOffers(){
        return api.getProjectOffers();
    }
    public Call<StudentResponse> getStudentDetails(int id){
        return api.getStudentDetails(id);
    }
    public Call<SupervisorResponse> getSupervisorDetails(int id){
        return api.getSupervisorDetails(id);
    }
    public Call<TaskResponse> getTasks(){
        return api.getTasks();
    }
    public Call<StudentProgressResponse> getProgresses(){
        return api.getProgresses();
    }



    public Call<JsonObject> logout(){
        return api.logout();
    }
}
