package com.training.retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Tran Manh on 8/24/2018.
 * Woori Bank Vietnam
 * Email: manh.tranvan@woori.com.vn
 */
public class NoticeList {
    @SerializedName("notice_list")
    private ArrayList<Notice> listNotice;

    public ArrayList<Notice> getListNotice() {
        return listNotice;
    }

    public void setListNotice(ArrayList<Notice> listNotice) {
        this.listNotice = listNotice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NoticeList{");
        sb.append("listNotice=").append(listNotice);
        sb.append('}');
        return sb.toString();
    }
}
