package com.travel.mvp.utils;

import android.app.Application;

/**
 * Created by Tran Manh on 9/11/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class App extends Application {
    private static App mSelf;

    public static App self() {
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
    }
}
