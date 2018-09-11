package com.travel.mvp.interfaces;

import com.travel.mvp.models.TravelModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tran Manh on 8/27/2018.
 */
public interface GetDataService {
    @GET("feeds?")
    Call<TravelModel> getUserData(@Query("access_token") String accessToken, @Query("filter[scope]") String scope, @Query("page") Integer page);
}