package com.travel.mvp.network;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tran Manh on 8/27/2018.
 */
public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String TAG = "RetrofitInstance";
    private static final String BASE_URL = "https://staging.travelbook.com/api/v1/";

    // Create an instance of Retrofit object
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        Log.i(TAG, "getRetrofitInstance: " + retrofit);
        return retrofit;
    }
}
