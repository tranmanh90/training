package com.training.retrofit.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.training.expandable.ExpandableLayout;
import com.training.retrofit.R;
import com.training.retrofit.adapters.TravelBookAdapter;
import com.training.retrofit.interfaces.GetDataService;
import com.training.retrofit.model.TravelModel;
import com.training.retrofit.network.RetrofitInstance;
import com.training.retrofit.receivers.ConnectivityReceiver;
import com.training.retrofit.receivers.TravelBookApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelBookActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    private static final String TAG = "Travel Book";
    private static final String ACCESS_TOKEN = "a294edf361ccdf3e62d167af3b68e9234461825fac70db173a421c08d2f80aaf";
//    private static final String ACCESS_TOKEN = "67561edf2ef10382826457f0d56e851644058b6a10769bbc15915b1017feb716";

    private ExpandableLayout expandableLayout;
    private TravelBookAdapter travelBookAdapter;
    private RecyclerView recyclerView;
    private Button friend;
    private Button community;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String scopes;
    private SharedPreferences sharedPreferences;
    private CoordinatorLayout viewCoordinatorLayout;
    private boolean isFirstTime;
    private ProgressBar progressBar;
    // Redundant for load more
    private Integer pageNumber = 1;
    private TextView aboveTxt, belowTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.snack_layout);

        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        friend = findViewById(R.id.friends);
        progressBar = findViewById(R.id.pBar);

        viewCoordinatorLayout = findViewById(R.id.coordinatorLayout);
        community = findViewById(R.id.community);

        View switcher = findViewById(R.id.switcher);
        expandableLayout = findViewById(R.id.expandableLayout);
        expandableLayout.setSwitcher(switcher);
        expandableLayout.setExpandInterpolator(new AccelerateDecelerateInterpolator());
        expandableLayout.setCollapseInterpolator(new AccelerateDecelerateInterpolator());
        expandableLayout.setExpandDuration(250);
        expandableLayout.setCollapseDuration(400);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        isFirstTime = true;
        aboveTxt = findViewById(R.id.above);
        belowTxt = findViewById(R.id.below);

        loadingAppSetting();
        loadingData(ACCESS_TOKEN, scopes, pageNumber);
        refresh();

        findViewById(R.id.btnTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableLayout.toggle();
            }
        });

        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                scopes = "friends";
                expandableLayout.toggle();
                friend.setTextColor(Color.argb(255, 236, 81, 105));
                community.setTextColor(Color.argb(255, 0, 0, 0));
                loadingData(ACCESS_TOKEN, scopes, pageNumber);
                doSave();
                Log.i(TAG, "onClick Friends : " + scopes);
            }
        });

        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                scopes = "community";
                expandableLayout.toggle();
                friend.setTextColor(Color.argb(255, 0, 0, 0));
                community.setTextColor(Color.argb(255, 236, 81, 105));
                loadingData(ACCESS_TOKEN, scopes, pageNumber);
                doSave();
                Log.i(TAG, "onClick Community : " + scopes);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        TravelBookApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
        isFirstTime = false;
    }

    private void loadingData(String accessToken, String params, Integer page) {

        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<TravelModel> travelModelCall = service.getUserData(accessToken, params, page);
        Log.i(TAG, "loadingData: " + travelModelCall.toString());

        travelModelCall.enqueue(new Callback<TravelModel>() {
            @Override
            public void onResponse(Call<TravelModel> call, Response<TravelModel> response) {
                Log.i(TAG, "onResponse: " + response.code());
                belowTxt.setVisibility(View.VISIBLE);
                aboveTxt.setVisibility(View.GONE);
                travelBookAdapter = new TravelBookAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(travelBookAdapter);
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<TravelModel> call, Throwable t) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        belowTxt.setVisibility(View.VISIBLE);
                        aboveTxt.setVisibility(View.GONE);
                    }
                }, 100);
                Log.i(TAG, "onFailure: " + t);
            }
        });
    }

    private void refresh() {
        swipeRefreshLayout.setColorSchemeColors(Color.argb(255, 236, 81, 105));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (scopes.equals("friends")) {
                    loadingData(ACCESS_TOKEN, scopes, pageNumber);
                    Log.i(TAG, "onRefresh: " + scopes);
                } else if (scopes.equals("community")) {
                    loadingData(ACCESS_TOKEN, scopes, pageNumber);
                    Log.i(TAG, "onRefresh: " + scopes);
                }
            }
        });
    }

    private void loadingAppSetting() {
        sharedPreferences = this.getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            scopes = sharedPreferences.getString("scopes", "");
            if (scopes.equals("friends")) {
                friend.setTextColor(Color.argb(255, 236, 81, 105));
                community.setTextColor(Color.argb(255, 0, 0, 0));
            } else if (scopes.equals("community")) {
                community.setTextColor(Color.argb(255, 236, 81, 105));
                friend.setTextColor(Color.argb(255, 0, 0, 0));
            }
        }
    }

    private void doSave() {
        sharedPreferences = this.getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("scopes", scopes);
        editor.apply();
    }

    private void showSnack(boolean isConnected) {
        Snackbar snackbar;
        String message;
        int color;
        if (isConnected) {
            message = "Connected to Internet";
            color = Color.WHITE;
            if (!isFirstTime) {
                snackbar = Snackbar.make(viewCoordinatorLayout, message, Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(color);
                snackbar.show();
            }

            isFirstTime = false;
            loadingData(ACCESS_TOKEN, scopes, pageNumber);
            swipeRefreshLayout.setRefreshing(false);
        } else {
            message = "Not connected to internet";
            color = Color.RED;
            snackbar = Snackbar.make(viewCoordinatorLayout, message, Snackbar.LENGTH_INDEFINITE);
            View sbView = snackbar.getView();
            TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(color);
            snackbar.show();
        }
    }
}