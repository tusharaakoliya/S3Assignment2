package com.example.s3assignment2.ApiUtility;

import com.example.s3assignment2.model.ApiResponse;
import com.example.s3assignment2.model.FdaFoodRecall;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {
    /**
     * This methos wil cann the OMDb api with the specified search term
     */

    public static ApiResponse getRecallDetailsFromFDA(String searchLimit) throws IOException, InterruptedException {

        String uri = "https://api.fda.gov/food/enforcement.json?limit="+searchLimit;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();


        // this sends the result from API to a file
//
//        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
//                                                    .BodyHandlers
//                                                    .ofFile(Paths.get("jsonData.json")));
        //return getMovieJsonFile();

        // this approch stores theAPi response to a string and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();

        Gson gson = new Gson();
        ApiResponse response1 = null;

        try{
            response1 = gson.fromJson(jsonString, ApiResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response1;
    }

    public static FdaFoodRecall getRecallDetailsByRecallNumber(String recallNumber) throws IOException, InterruptedException {
    //    recallNumber = recallNumber.trim().replace(" ", "%20");
        String uri = "https://api.fda.gov/food/enforcement.json?search=recall_number:" + recallNumber;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this approach stores the API response to a String and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      //  System.out.println(response.body());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), FdaFoodRecall.class);
    }
}
