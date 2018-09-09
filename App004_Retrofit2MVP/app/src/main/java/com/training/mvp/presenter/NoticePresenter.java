package com.training.mvp.presenter;

import com.training.mvp.model.Notice;
import com.training.mvp.view.INoticeView;

import java.util.ArrayList;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class NoticePresenter implements INoticePresenter, IGetDataPresenter.OnFinishedListener {

    private INoticeView mNoticeView;
    private IGetDataPresenter mGetDataPresenter;

    public NoticePresenter(INoticeView mNoticeView, IGetDataPresenter mGetDataPresenter) {
        this.mNoticeView = mNoticeView;
        this.mGetDataPresenter = mGetDataPresenter;
    }

    @Override
    public void onDestroy() {
        mNoticeView = null;
    }

    @Override
    public void onRefresh() {
        if (mNoticeView != null) {
            mNoticeView.showProgress();
        }
        mGetDataPresenter.getNoticeArrayList(this);
    }

    @Override
    public void requestData() {
        mGetDataPresenter.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {
        if (mNoticeView != null) {
            mNoticeView.setBindDataToRecycleView(noticeArrayList);
            mNoticeView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mNoticeView != null) {
            mNoticeView.onResponseFailure(t);
            mNoticeView.hideProgress();
        }
    }
}
