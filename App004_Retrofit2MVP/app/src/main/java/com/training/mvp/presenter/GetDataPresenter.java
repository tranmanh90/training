package com.training.mvp.presenter;

import android.util.Log;

import com.training.mvp.interfaces.GetNoticeDataService;
import com.training.mvp.model.NoticeList;
import com.training.mvp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class GetDataPresenter implements IGetDataPresenter {
    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {
        /** Create handle for the RetrofitInstance interface*/
        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NoticeList> call = service.getNoticeData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getListNotice());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }
}
