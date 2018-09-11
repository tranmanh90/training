package com.travel.mvp.presenters;

import com.travel.mvp.models.TravelModel;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface IGetDataPresenter {

    interface OnFinishedListener {
        void onFinished(TravelModel travelModel);

        void onFailure(Throwable t);
    }

    void getTravelDataList(OnFinishedListener onFinishedListener, String scope);
}
