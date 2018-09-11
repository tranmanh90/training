package com.travel.mvp.presenters;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface ITravelBookPresenter {
    void onDestroy();

    void onRefresh(String scope);

    void requestData(String scope);

    String loadAppSettings();

    void storeAppSettings(String scope);
}
