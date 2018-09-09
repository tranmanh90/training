package com.training.retrofit.model.travelogue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class TravelogueUser {
    @SerializedName("data")
    private RelationshipDetail relationshipDetail;

    public TravelogueUser(RelationshipDetail relationshipDetail) {
        this.relationshipDetail = relationshipDetail;
    }

    public RelationshipDetail getRelationshipDetail() {
        return relationshipDetail;
    }

    public void setRelationshipDetail(RelationshipDetail relationshipDetail) {
        this.relationshipDetail = relationshipDetail;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelogueUser{");
        sb.append("relationshipDetail=").append(relationshipDetail);
        sb.append('}');
        return sb.toString();
    }
}
