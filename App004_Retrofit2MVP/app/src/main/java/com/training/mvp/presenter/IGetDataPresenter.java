package com.training.mvp.presenter;

import com.training.mvp.model.Notice;

import java.util.ArrayList;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface IGetDataPresenter {
    interface OnFinishedListener {
        void onFinished(ArrayList<Notice> noticeArrayList);

        void onFailure(Throwable t);
    }

    void getNoticeArrayList(OnFinishedListener onFinishedListener);
}
