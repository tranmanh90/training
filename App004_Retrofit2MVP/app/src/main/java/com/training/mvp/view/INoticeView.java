package com.training.mvp.view;

import com.training.mvp.model.Notice;

import java.util.ArrayList;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface INoticeView {
    void showProgress();

    void hideProgress();

    void setBindDataToRecycleView(ArrayList<Notice> noticeArrayList);

    void onResponseFailure(Throwable throwable);
}
