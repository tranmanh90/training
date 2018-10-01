package com.training.loadmore.models;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class MovieModel {
    private String mTitle;
    private String mRating;
    private String mType;

    public MovieModel(String mType) {
        this.mType = mType;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmRating() {
        return mRating;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MovieModel{");
        sb.append("mTitle='").append(mTitle).append('\'');
        sb.append(", mRating='").append(mRating).append('\'');
        sb.append(", mType='").append(mType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
