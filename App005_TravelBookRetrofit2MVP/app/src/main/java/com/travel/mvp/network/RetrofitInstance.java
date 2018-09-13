package com.travel.mvp.network;

import android.util.Log;

import com.travel.mvp.constants.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
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
//            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            TokenAuthenticator tokenAuthenticator = new TokenAuthenticator();
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequests(1);

            OkHttpClient okClient = new OkHttpClient.Builder()
                            .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .authenticator(tokenAuthenticator)
                            .dispatcher(dispatcher)
                            .build();
            Log.i(TAG, "getRetrofitInstance: " + okClient.toString());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okClient)
                    .build();
        }
        Log.i(TAG, "getRetrofitInstance: " + retrofit.toString());
        return retrofit;
    }
}
