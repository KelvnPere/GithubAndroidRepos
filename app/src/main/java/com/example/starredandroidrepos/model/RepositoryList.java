package com.example.starredandroidrepos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RepositoryList {

    @SerializedName("items")
    @Expose
    private ArrayList<Repos> repositories = null;

    public ArrayList<Repos> getRepositories() {
        return repositories;
    }

    public void setRepositories(ArrayList<Repos> repositories) {
        this.repositories = repositories;
    }

}
