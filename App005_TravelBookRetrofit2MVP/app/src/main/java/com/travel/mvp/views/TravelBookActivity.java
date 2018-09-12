package com.travel.mvp.views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.travel.mvp.ExpandableLayout;
import com.travel.mvp.R;
import com.travel.mvp.adapters.TravelBookAdapter;
import com.travel.mvp.models.TravelModel;
import com.travel.mvp.presenters.GetDataPresenter;
import com.travel.mvp.presenters.ITravelBookPresenter;
import com.travel.mvp.presenters.TravelBookPresenter;

public class TravelBookActivity extends AppCompatActivity implements ITravelBookView {


    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private ITravelBookPresenter mTravelBookPresenter;
    private ExpandableLayout expandableLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Button friend;
    private Button community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_book_main);

        initProgressBar();
        initFriendsButton();
        initCommunityButton();

        configExpandableLayout();
        initSwipeRefreshLayout();
        initRecycleView();

        mTravelBookPresenter = new TravelBookPresenter(this, new GetDataPresenter());
        mTravelBookPresenter.requestData(mTravelBookPresenter.loadAppSettings());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTravelBookPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setBindDataToRecycleView(TravelModel travelModel) {
        TravelBookAdapter adapter = new TravelBookAdapter(getApplicationContext(), travelModel);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(TravelBookActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    private void initRecycleView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TravelBookActivity.this);
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

    private void configExpandableLayout() {
        View switcher = findViewById(R.id.switcher);
        expandableLayout = findViewById(R.id.expandable_layout);
        expandableLayout.setSwitcher(switcher);
        expandableLayout.setExpandInterpolator(new AccelerateDecelerateInterpolator());
        expandableLayout.setCollapseInterpolator(new AccelerateDecelerateInterpolator());
        expandableLayout.setExpandDuration(250);
        expandableLayout.setCollapseDuration(400);
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        swipeRefreshLayout.setColorSchemeColors(Color.argb(255, 236, 81, 105));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTravelBookPresenter.requestData(mTravelBookPresenter.loadAppSettings());
            }
        });
    }

    protected void onExpandable(View view) {
        expandableLayout.toggle();
    }

    private void initFriendsButton() {
        friend = findViewById(R.id.friends_button);
        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                community.setTextColor(Color.argb(255, 0, 0, 0));
                friend.setTextColor(Color.argb(255, 236, 81, 105));
                mTravelBookPresenter.onRefresh(getApplicationContext().getString(R.string.friends_scope));
                mTravelBookPresenter.storeAppSettings(getApplicationContext().getString(R.string.friends_scope));
                expandableLayout.toggle();
            }
        });
    }

    private void initCommunityButton() {
        community = findViewById(R.id.community_button);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friend.setTextColor(Color.argb(255, 0, 0, 0));
                community.setTextColor(Color.argb(255, 236, 81, 105));
                mTravelBookPresenter.onRefresh(getApplicationContext().getString(R.string.community_scope));
                mTravelBookPresenter.storeAppSettings(getApplicationContext().getString(R.string.community_scope));
                expandableLayout.toggle();
            }
        });
    }

    @Override
    public void initUI(Integer... params) {
        friend.setTextColor(Color.argb(params[0], params[1], params[2], params[3]));
        community.setTextColor(Color.argb(params[4], params[5], params[6], params[7]));
    }
}
