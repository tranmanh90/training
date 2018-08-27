package com.training.retrofit.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.training.retrofit.R;
import com.training.retrofit.adapters.NoticeAdapter;
import com.training.retrofit.interfaces.GetNoticeDataService;
import com.training.retrofit.models.Notice;
import com.training.retrofit.models.NoticeList;
import com.training.retrofit.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // Create handle for RetrofitInstance interface
        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        // Call the method with parameter in the interface to get the notice data
        Call<NoticeList> call = service.getNoticeData();

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                generateNoticeList(response.body().getListNotice());
                Log.i("VVVVVVVVVVVV", response.body().toString());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Method to generate List of notice using RecyclerView with custom adapter
    private void generateNoticeList(ArrayList<Notice> list) {
        NoticeAdapter mNoticeAdapter;
        RecyclerView mRecyclerView;
        mRecyclerView = findViewById(R.id.recycle_view);
        mNoticeAdapter = new NoticeAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RetrofitActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mNoticeAdapter);
    }
}
