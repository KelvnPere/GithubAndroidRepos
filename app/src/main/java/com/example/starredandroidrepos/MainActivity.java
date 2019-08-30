package com.example.starredandroidrepos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.starredandroidrepos.adapter.RepositoryAdapter;
import com.example.starredandroidrepos.model.Repos;
import com.example.starredandroidrepos.model.RepositoryList;
import com.example.starredandroidrepos.retrofit.Api;
import com.example.starredandroidrepos.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Repos> repositorieList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private RepositoryAdapter repositoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Data is loading.. Please be patient...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        getApiInfo();


    }

    private void getApiInfo() {

        Api api = RetrofitClient.getApiService();
        Call<RepositoryList> call = api.getMyJSON();

        call.enqueue(new Callback<RepositoryList>() {
            @Override
            public void onResponse(Call<RepositoryList> call, Response<RepositoryList> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {

                    repositorieList = response.body().getRepositories();
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    repositoryAdapter = new RepositoryAdapter(repositorieList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(repositoryAdapter);
                }
            }

            @Override
            public void onFailure(Call<RepositoryList> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}
