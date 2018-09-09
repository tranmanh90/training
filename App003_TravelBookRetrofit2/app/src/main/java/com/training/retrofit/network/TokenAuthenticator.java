package com.training.retrofit.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.training.retrofit.model.RefreshToken;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by Tran Manh on 9/4/2018.
 */
public class TokenAuthenticator implements Authenticator {

    private static final String TAG = "TokenAuthenticator";

    /**
     * curl https://staging.travelbook.com/api/v1/token --data "client_id=3bb0640f3232379a9e07c0c44f9ef5e764eefb9ba0e1d31168a90ecebe2bc67d&client_secret=073177b5f4f3489d46921c62629a42aa7b2bbdf57fc578bf2c61917957d037cc&grant_type=password&email=olivier@nimbl3.com&password=12345678"
     */

    private static final String BASE_URL = "https://staging.travelbook.com/api/v1/";
    private static final String CLIENT_ID = "3bb0640f3232379a9e07c0c44f9ef5e764eefb9ba0e1d31168a90ecebe2bc67d";
    private static final String CLIENT_SECRET = "073177b5f4f3489d46921c62629a42aa7b2bbdf57fc578bf2c61917957d037cc";
    private static final String GRANT_TYPE = "password";
    private static final String EMAIL = "olivier@nimbl3.com";
    private static final String PASSWORD = "12345678";
    private static String REFRESH_TOKEN = "8a08df12d0165d872995cf231bd21e1907c76593dd3d332ace0eae5c61218828";
    private static String NEW_ACCESS_TOKEN = "";
    private RefreshToken refreshToken;
    private SharedPreferences sharedPreferences;
    private Context context;


    @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        boolean refreshResult = refreshToken(BASE_URL, CLIENT_ID, CLIENT_SECRET, GRANT_TYPE, EMAIL, PASSWORD);
        if (refreshResult) {
            // thuc hien request hien tai khi da lay duoc token moi
            Log.i(TAG, "getAccessToken===>: " + refreshToken.getAccessToken());
            return response.request().newBuilder().header("Authorization", refreshToken.getAccessToken()).build();
        } else {
            //Khi refresh token failed ban co the thuc hien action refresh lan tiep theo
            return null;
        }
    }

    private boolean refreshToken(String baseUrl, String clientId, String clientSecret, String grantType, String email, String password)
            throws IOException {
        URL refreshUrl = new URL(baseUrl + "token");
        HttpURLConnection urlConnection = (HttpURLConnection) refreshUrl.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConnection.setUseCaches(false);
        String urlParameters = "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=" + grantType +
                "&email=" + email +
                "&password=" + password;

        urlConnection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = urlConnection.getResponseCode();
        Log.i(TAG, "refreshToken: " + responseCode);

        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Log.i(TAG, "refreshToken: " + response.toString());
            // this gson part is optional , you can read response directly from Json too
            Gson gson = new Gson();
            refreshToken = gson.fromJson(response.toString(), RefreshToken.class);
            Log.i(TAG, "refreshToken Object: " + refreshToken.toString());

            // handle new token ...
            // save it to the sharedpreferences, storage bla bla ...
            sharedPreferences = context.getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE);
//            sharedPreferences.Editor editor = sharedPreferences.edit();
            return true;
        } else {
            //cannot refresh
            return false;
        }
    }
}
