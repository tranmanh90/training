package com.training.retrofit.receivers;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

/**
 * Created by Tran Manh on 9/3/2018.
 */
public class TravelBookApplication extends Application {
    private static TravelBookApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new ConnectivityReceiver(), intentFilter);
    }

    public static synchronized TravelBookApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
