package com.training.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Event");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: Event");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: Event");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: Event");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: Event");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: Event");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: Event");
    }
}
