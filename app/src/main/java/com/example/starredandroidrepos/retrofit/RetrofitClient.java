package com.example.starredandroidrepos.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.github.com/";


    //Get Retrofit Instance
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Get API Service and return API Service
    public static Api getApiService() {
        return getRetrofitInstance().create(Api.class);
    }
}
