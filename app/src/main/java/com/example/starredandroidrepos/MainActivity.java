package com.example.starredandroidrepos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.starredandroidrepos.model.Repos;
import com.example.starredandroidrepos.retrofit.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         Api api = retrofit.create(Api.class);

        Call<List<Repos>> call = api.getRepos();

        call.enqueue(new Callback<List<Repos>>() {

            // when the response is sucessfull
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
               List<Repos> repos = response.body();

               for (Repos r: repos){
                   Log.d("Repo Name", r.getName());
                   Log.d("Repo Language", r.getLanguage());
                   Log.d("Repo Url", r.getUrl());

               }
            }

            // when the response fails
            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
