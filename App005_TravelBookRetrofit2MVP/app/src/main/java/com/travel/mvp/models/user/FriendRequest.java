package com.travel.mvp.models.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class FriendRequest {
    @SerializedName("id")
    private Integer id;

    @SerializedName("is_pending")
    private Boolean isPending;

    @SerializedName("sender_id")
    private Integer senderId;

    public FriendRequest(Integer id, Boolean isPending, Integer senderId) {
        this.id = id;
        this.isPending = isPending;
        this.senderId = senderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FriendRequest{");
        sb.append("id=").append(id);
        sb.append(", isPending=").append(isPending);
        sb.append(", senderId=").append(senderId);
        sb.append('}');
        return sb.toString();
    }
}
