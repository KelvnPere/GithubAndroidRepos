package com.example.starredandroidrepos.retrofit;

import com.example.starredandroidrepos.model.Repos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL =  "https://api.github.com";

    @GET("/search/repositories?q=android+language:kotlin&sort=stars&order=desc")
    Call<List<Repos>> getRepos();
}
