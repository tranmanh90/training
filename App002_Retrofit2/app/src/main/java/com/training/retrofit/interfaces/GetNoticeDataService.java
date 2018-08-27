package com.training.retrofit.interfaces;

import com.training.retrofit.models.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tran Manh on 8/24/2018.
 * Woori Bank Vietnam
 * Email: manh.tranvan@woori.com.vn
 */
public interface GetNoticeDataService {
    @GET("/bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
}
