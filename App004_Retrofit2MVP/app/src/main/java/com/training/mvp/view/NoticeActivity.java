package com.training.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
import com.training.mvp.R;
import com.training.mvp.adapter.NoticeAdapter;
import com.training.mvp.model.Notice;
import com.training.mvp.presenter.GetDataPresenter;
import com.training.mvp.presenter.INoticePresenter;
import com.training.mvp.presenter.NoticePresenter;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity implements INoticeView {

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private INoticePresenter mNoticePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
        initProgressBar();
        mNoticePresenter = new NoticePresenter(this, new GetDataPresenter());
        mNoticePresenter.requestData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNoticePresenter.onDestroy();
    }

    private void initRecycleView() {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NoticeActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initProgressBar() {
        mProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        mProgressBar.setIndeterminate(true);


        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(mProgressBar);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mProgressBar.setVisibility(View.INVISIBLE);
        this.addContentView(relativeLayout, params);

    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setBindDataToRecycleView(ArrayList<Notice> noticeArrayList) {
        NoticeAdapter adapter = new NoticeAdapter(noticeArrayList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(NoticeActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
