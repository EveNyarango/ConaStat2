package com.example.myconastat.network;

import com.example.myconastat.models.CovidCases;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidApi {
    @GET("cases")
    Call<CovidCases> getCases(
            @Query("country") String country1,
             @Query("continent") String continent1
    );

//    @GET("history")
//    Call<YelpBusinessesSearchResponse> getHistory(
//            @Query("country") String country2,
//            @Query("status") String status,
//            @Query("continent") String continent2
//    );


}
