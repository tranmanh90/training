package com.training.retrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tran Manh on 8/24/2018.
 * Woori Bank Vietnam
 * Email: manh.tranvan@woori.com.vn
 */
public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.myjson.com/";

    // Create an instance of Retrofit object
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
