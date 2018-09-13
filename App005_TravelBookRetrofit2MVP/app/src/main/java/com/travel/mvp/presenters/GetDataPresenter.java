package com.travel.mvp.presenters;

import android.util.Log;

import com.travel.mvp.constants.Constants;
import com.travel.mvp.interfaces.GetDataService;
import com.travel.mvp.models.TravelModel;
import com.travel.mvp.network.RetrofitInstance;
import com.travel.mvp.utils.SharedPrefs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class GetDataPresenter implements IGetDataPresenter {

    private static final String TAG = "GetDataPresenter";

//    private static final String INIT_ACCESS_TOKEN = "a294edf361ccdf3e62d167af3b68e9234461825fac70db173a421c08d2f80aaf";
    private static final String INIT_ACCESS_TOKEN = "67561edf2ef10382826457f0d56e851644058b6a10769bbc15915b1017feb716";

    @Override
    public void getTravelDataList(final OnFinishedListener onFinishedListener, String scope) {
        String tempToken = SharedPrefs.getInstance().get(Constants.ACCESS_TOKEN_KEY, String.class);
        if (tempToken.equals("")) {
            SharedPrefs.getInstance().put(Constants.ACCESS_TOKEN_KEY, INIT_ACCESS_TOKEN);
            tempToken = SharedPrefs.getInstance().get(Constants.ACCESS_TOKEN_KEY, String.class);
        }
        Log.i(TAG, "getTravelDataList: " + tempToken);
        /** Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<TravelModel> call = service.getUserData(tempToken, scope, 1);

        call.enqueue(new Callback<TravelModel>() {
            @Override
            public void onResponse(Call<TravelModel> call, Response<TravelModel> response) {
                Log.i(TAG, "onResponse: ");
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<TravelModel> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
