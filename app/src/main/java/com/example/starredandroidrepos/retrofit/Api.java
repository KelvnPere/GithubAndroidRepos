package com.example.starredandroidrepos.retrofit;

import com.example.starredandroidrepos.model.RepositoryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of EmployeeList
    */
    @GET("/search/repositories?q=android+language:kotlin&sort=stars&order=desc")
    Call<RepositoryList> getMyJSON();
}