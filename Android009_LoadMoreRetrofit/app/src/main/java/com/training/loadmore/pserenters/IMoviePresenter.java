package com.training.loadmore.pserenters;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface IMoviePresenter {
    void onDestroy();

    void requestData(int index);
}
