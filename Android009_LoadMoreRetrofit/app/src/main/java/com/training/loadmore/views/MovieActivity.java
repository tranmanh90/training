package com.training.loadmore.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.training.loadmore.R;
import com.training.loadmore.models.MovieModel;

import java.util.List;

public class MovieActivity extends AppCompatActivity implements IMovieView {
    @Override
    public void bindDataToRecyclerView(List<MovieModel> listMovies) {

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
