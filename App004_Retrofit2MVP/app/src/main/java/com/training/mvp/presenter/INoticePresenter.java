package com.training.mvp.presenter;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface INoticePresenter {
    void onDestroy();

    void onRefresh();

    void requestData();
}
