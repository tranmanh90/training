package com.training.loadmore.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class ServiceGenerator {
    public static <S> S createService(Class<S> serviceClass) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.sab99r.com/demos/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        return retrofit.create(serviceClass);
    }
}
