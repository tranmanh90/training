package com.training.loadmore.views;

import com.training.loadmore.models.MovieModel;

import java.util.List;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface IMovieView {
    void bindDataToRecyclerView(List<MovieModel> listMovies);

    void onResponseFailure(Throwable throwable);
}
