package com.example.s3assignment2.model;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("meta")
    private Meta meta;

    @SerializedName("results")
    private FdaFoodRecall[] results;

    public FdaFoodRecall[] getResults() {
        return results;
    }

    public void setResults(FdaFoodRecall[] results) {
        this.results = results;
    }

    public Meta getMeta() {

        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
