package com.travel.mvp.presenters;

import android.util.Log;

import com.travel.mvp.constants.Constants;
import com.travel.mvp.models.TravelModel;
import com.travel.mvp.utils.SharedPrefs;
import com.travel.mvp.views.ITravelBookView;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class TravelBookPresenter implements ITravelBookPresenter, IGetDataPresenter.OnFinishedListener {

    private static final String TAG = "TravelBookPresenter";

    private ITravelBookView travelBookView;
    private IGetDataPresenter getDataPresenter;

    public TravelBookPresenter(ITravelBookView travelBookView, IGetDataPresenter getDataPresenter) {
        this.travelBookView = travelBookView;
        this.getDataPresenter = getDataPresenter;
    }

    @Override
    public void onFinished(TravelModel travelModel) {
        if (travelBookView != null) {
            travelBookView.setBindDataToRecycleView(travelModel);
            travelBookView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (travelBookView != null) {
            travelBookView.onResponseFailure(t);
            travelBookView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        this.travelBookView = null;
    }

    @Override
    public void onRefresh(String scope) {
        if ((travelBookView != null) && (scope.equals(Constants.FRIENDS_SCOPE))) {
            travelBookView.showProgress();

        } else if ((travelBookView != null) && (scope.equals(Constants.COMMUNITY_SCOPE))) {
            travelBookView.showProgress();
        }
        getDataPresenter.getTravelDataList(this, scope);
    }

    @Override
    public void requestData(String scope) {
        getDataPresenter.getTravelDataList(this, scope);
    }

    @Override
    public String loadAppSettings() {
        String temp = SharedPrefs.getInstance().get(Constants.REFERENCE_KEY, String.class);
        if (temp.equals("")) {
            SharedPrefs.getInstance().put(Constants.REFERENCE_KEY, Constants.FRIENDS_SCOPE);
            temp = SharedPrefs.getInstance().get(Constants.REFERENCE_KEY, String.class);
        }
        Log.i(TAG, "loadAppSettings: " + temp);
        if (temp.equals(Constants.FRIENDS_SCOPE)) {
            travelBookView.initUI(Constants.Color.FRIENDS_HIGHLIGHT);
        } else if (temp.equals(Constants.COMMUNITY_SCOPE)) {
            travelBookView.initUI(Constants.Color.COMMUNITY_HIGHLIGHT);
        }
        return temp;
    }

    @Override
    public void storeAppSettings(String scope) {
        SharedPrefs.getInstance().put(Constants.REFERENCE_KEY, scope);
    }
}
