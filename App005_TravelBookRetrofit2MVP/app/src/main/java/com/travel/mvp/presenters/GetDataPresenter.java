package com.travel.mvp.presenters;

import com.travel.mvp.interfaces.GetDataService;
import com.travel.mvp.models.TravelModel;
import com.travel.mvp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class GetDataPresenter implements IGetDataPresenter {

    private static final String ACCESS_TOKEN = "a294edf361ccdf3e62d167af3b68e9234461825fac70db173a421c08d2f80aaf";

    @Override
    public void getTravelDataList(final OnFinishedListener onFinishedListener, String scope) {
        /** Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<TravelModel> call = service.getUserData(ACCESS_TOKEN, scope, 1);

        call.enqueue(new Callback<TravelModel>() {
            @Override
            public void onResponse(Call<TravelModel> call, Response<TravelModel> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<TravelModel> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
