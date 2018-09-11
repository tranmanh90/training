package com.travel.mvp.models.travelogue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class TravelogueRelationship {
    @SerializedName("user")
    private TravelogueUser travelogueUser;

    @SerializedName("destination")
    private TravelogueDestination travelogueDestination;

    public TravelogueRelationship(TravelogueUser travelogueUser, TravelogueDestination travelogueDestination) {
        this.travelogueUser = travelogueUser;
        this.travelogueDestination = travelogueDestination;
    }

    public TravelogueUser getTravelogueUser() {
        return travelogueUser;
    }

    public void setTravelogueUser(TravelogueUser travelogueUser) {
        this.travelogueUser = travelogueUser;
    }

    public TravelogueDestination getTravelogueDestination() {
        return travelogueDestination;
    }

    public void setTravelogueDestination(TravelogueDestination travelogueDestination) {
        this.travelogueDestination = travelogueDestination;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelogueRelationship{");
        sb.append("travelogueUser=").append(travelogueUser);
        sb.append(", travelogueDestination=").append(travelogueDestination);
        sb.append('}');
        return sb.toString();
    }
}
