package com.example.s3assignment2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiResponse {

    @SerializedName("meta")
    private Meta meta;

    @SerializedName("results")
    private ArrayList<FdaFoodRecall> results;


    public ArrayList<FdaFoodRecall> getResults() {
        return results;
    }

    public void setResults(ArrayList<FdaFoodRecall> results) {
        this.results = results;
    }

    public Meta getMeta() {

        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
