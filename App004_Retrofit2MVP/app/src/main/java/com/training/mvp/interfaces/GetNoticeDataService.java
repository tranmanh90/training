package com.training.mvp.interfaces;

import com.training.mvp.model.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tran Manh on 8/24/2018.
 */
public interface GetNoticeDataService {
    @GET("/bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
}
