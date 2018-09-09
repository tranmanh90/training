package com.training.retrofit.model.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class Geolocation {
    @SerializedName("x")
    private Float x;

    @SerializedName("y")
    private Float y;

    public Geolocation(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Geolocation{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
