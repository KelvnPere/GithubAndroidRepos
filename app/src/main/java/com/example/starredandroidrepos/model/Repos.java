package com.example.starredandroidrepos.model;

import com.google.gson.annotations.SerializedName;

public class Repos {

    private String name;
    @SerializedName("image")
    private String gravatar;
    private String url;
    private String language;
    private int stars;

    public Repos(String name, String gravatar, String url, String language, int stars) {
        this.name = name;
        this.gravatar = gravatar;
        this.url = url;
        this.language = language;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGravatar() {
        return gravatar;
    }

    public void setGravatar(String gravatar) {
        this.gravatar = gravatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
