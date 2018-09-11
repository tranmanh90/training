package com.travel.mvp.views;

import com.travel.mvp.models.TravelModel;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface ITravelBookView {

    void initUI(Integer... params);

    void showProgress();

    void hideProgress();

    void setBindDataToRecycleView(TravelModel travelModel);

    void onResponseFailure(Throwable throwable);
}
