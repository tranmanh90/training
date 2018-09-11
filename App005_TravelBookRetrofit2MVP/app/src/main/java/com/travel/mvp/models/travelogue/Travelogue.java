package com.travel.mvp.models.travelogue;

import com.google.gson.annotations.SerializedName;
import com.travel.mvp.models.user.IncludedUserPlace;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class Travelogue {
    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("attributes")
    private TravelogueAttribute attributes;

    @SerializedName("relationships")
    private TravelogueRelationship relationships;

    private IncludedUserPlace includedUserPlace;

    public Travelogue(String id, String type, TravelogueAttribute attributes, TravelogueRelationship relationships, IncludedUserPlace includedUserPlace) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;
        this.relationships = relationships;
        this.includedUserPlace = includedUserPlace;
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

    public TravelogueAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(TravelogueAttribute attributes) {
        this.attributes = attributes;
    }

    public TravelogueRelationship getRelationships() {
        return relationships;
    }

    public void setRelationships(TravelogueRelationship relationships) {
        this.relationships = relationships;
    }

    public IncludedUserPlace getIncludedUserPlace() {
        return includedUserPlace;
    }

    public void setIncludedUserPlace(IncludedUserPlace includedUserPlace) {
        this.includedUserPlace = includedUserPlace;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Travelogue{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", attributes=").append(attributes);
        sb.append(", relationships=").append(relationships);
        sb.append(", includedUserPlace=").append(includedUserPlace);
        sb.append('}');
        return sb.toString();
    }
}
