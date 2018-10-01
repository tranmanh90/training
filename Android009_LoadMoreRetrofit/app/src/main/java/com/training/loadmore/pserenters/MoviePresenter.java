package com.training.loadmore.pserenters;

import com.training.loadmore.models.MovieModel;
import com.training.loadmore.views.IMovieView;

import java.util.List;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class MoviePresenter implements IMoviePresenter, IGetDataPresenter.OnFinishedListener {

    private IMovieView movieView;
    private IGetDataPresenter getDataPresenter;

    public MoviePresenter(IMovieView movieView, IGetDataPresenter getDataPresenter) {
        this.movieView = movieView;
        this.getDataPresenter = getDataPresenter;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void requestData(int index) {

    }

    @Override
    public void onFinished(List<MovieModel> listMovies) {

    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
