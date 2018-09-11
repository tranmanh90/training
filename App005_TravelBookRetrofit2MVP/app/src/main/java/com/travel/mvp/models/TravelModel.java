package com.travel.mvp.models;

import com.google.gson.annotations.SerializedName;
import com.travel.mvp.models.travelogue.Travelogue;
import com.travel.mvp.models.user.IncludedUserPlace;

import java.util.List;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class TravelModel {
    @SerializedName("data")
    private List<Travelogue> travelogues;

    @SerializedName("included")
    private List<IncludedUserPlace> includedUserPlaces;

    public TravelModel(List<Travelogue> travelogues, List<IncludedUserPlace> includedUserPlaces) {
        this.travelogues = travelogues;
        this.includedUserPlaces = includedUserPlaces;
    }

    public List<Travelogue> getTravelogues() {
        return travelogues;
    }

    public void setTravelogues(List<Travelogue> travelogues) {
        this.travelogues = travelogues;
    }

    public List<IncludedUserPlace> getIncludedUserPlaces() {
        return includedUserPlaces;
    }

    public void setIncludedUserPlaces(List<IncludedUserPlace> includedUserPlaces) {
        this.includedUserPlaces = includedUserPlaces;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelModel{");
        sb.append("travelogues=").append(travelogues);
        sb.append(", includedUserPlaces=").append(includedUserPlaces);
        sb.append('}');
        return sb.toString();
    }
}
