package com.training.loadmore.pserenters;

import com.training.loadmore.models.MovieModel;

import java.util.List;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface IGetDataPresenter {
    interface OnFinishedListener {
        void onFinished(List<MovieModel> listMovies);

        void onFailure(Throwable throwable);
    }

    void getListMovies(OnFinishedListener listener, int index);
}
