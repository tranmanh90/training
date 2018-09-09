package com.training.retrofit.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.training.retrofit.model.RefreshToken;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tran Manh on 9/4/2018.
 */
public class TokenInterceptor implements Interceptor {

    private Context ctx;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefsEdit;
    private RefreshToken refreshToken;

    public TokenInterceptor() {
//        this.ctx = ctx;
//        this.mPrefs= PreferenceManager.getDefaultSharedPreferences(ctx);
//        mPrefsEdit=mPrefs.edit();
        refreshToken = new RefreshToken();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request();

        //when saving expire time :
        Integer expiresIn = refreshToken.getExpiresIn();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.SECOND, expiresIn);
        mPrefsEdit.putLong("expiretime", c1.getTimeInMillis());

        //get expire time from shared preferences
        long expireTime = mPrefs.getLong("expiretime", 0);
        Calendar c2 = Calendar.getInstance();
        Date nowDate = c2.getTime();
        c2.setTimeInMillis(expireTime);
        Date expireDate = c2.getTime();

        int result = nowDate.compareTo(expireDate);
        /**
         * when comparing dates -1 means date passed so we need to refresh token
         * see {@link Date#compareTo}
         */
        if (result == -1) {
            //refresh token here , and got new access token
            String newaccessToken = "newaccess";
            newRequest = chain.request().newBuilder()
                    .header("Authorization", newaccessToken)
                    .build();
        }
        return chain.proceed(newRequest);
    }
}
