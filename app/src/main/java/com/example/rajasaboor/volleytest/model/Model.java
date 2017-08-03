package com.example.rajasaboor.volleytest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rajaSaboor on 8/3/2017.
 */

public class Model {
    private static final String TAG = Model.class.getSimpleName();

    @SerializedName("label")
    private String name;
    private String image;
    private String summary;
    private String price;

    public Model() {
    }

    public Model(String name, String image, String summary, String price) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
