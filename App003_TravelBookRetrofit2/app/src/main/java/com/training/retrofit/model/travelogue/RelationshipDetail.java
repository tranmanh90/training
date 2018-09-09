package com.training.retrofit.model.travelogue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class RelationshipDetail {
    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    public RelationshipDetail(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RelationshipDetail{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
