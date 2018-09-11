package com.travel.mvp.models.travelogue;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class TravelogueAttribute {
    @SerializedName("start_date")
    private String startDate;

    @SerializedName("likes_count")
    private Integer likesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("privacy")
    private String privacy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("published_at")
    private String publishedAt;

    @SerializedName("is_new")
    private Boolean isNew;

    @SerializedName("is_published")
    private Boolean isPublished;

    @SerializedName("status")
    private String status;

    @SerializedName("cover_image_url")
    private String coverImageUrl;

    @SerializedName("media_count")
    private String mediaCount;

    @SerializedName("slug")
    private String slug;

    @SerializedName("is_liked")
    private Boolean isLiked;

    @SerializedName("like")
    private Object like;

    @SerializedName("points_count")
    private Integer pointsCount;

    public TravelogueAttribute(String startDate, Integer likesCount, Integer commentsCount, String privacy, String createdAt, String updatedAt, String publishedAt, Boolean isNew, Boolean isPublished, String status, String coverImageUrl, String mediaCount, String slug, Boolean isLiked, Object like, Integer pointsCount) {
        this.startDate = startDate;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
        this.privacy = privacy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.isNew = isNew;
        this.isPublished = isPublished;
        this.status = status;
        this.coverImageUrl = coverImageUrl;
        this.mediaCount = mediaCount;
        this.slug = slug;
        this.isLiked = isLiked;
        this.like = like;
        this.pointsCount = pointsCount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getMediaCount() {
        return mediaCount;
    }

    public void setMediaCount(String mediaCount) {
        this.mediaCount = mediaCount;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public Object getLike() {
        return like;
    }

    public void setLike(Object like) {
        this.like = like;
    }

    public Integer getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(Integer pointsCount) {
        this.pointsCount = pointsCount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelogueAttribute{");
        sb.append("startDate='").append(startDate).append('\'');
        sb.append(", likesCount=").append(likesCount);
        sb.append(", commentsCount=").append(commentsCount);
        sb.append(", privacy='").append(privacy).append('\'');
        sb.append(", createdAt='").append(createdAt).append('\'');
        sb.append(", updatedAt='").append(updatedAt).append('\'');
        sb.append(", publishedAt='").append(publishedAt).append('\'');
        sb.append(", isNew=").append(isNew);
        sb.append(", isPublished=").append(isPublished);
        sb.append(", status='").append(status).append('\'');
        sb.append(", coverImageUrl='").append(coverImageUrl).append('\'');
        sb.append(", mediaCount='").append(mediaCount).append('\'');
        sb.append(", slug='").append(slug).append('\'');
        sb.append(", isLiked=").append(isLiked);
        sb.append(", like=").append(like);
        sb.append(", pointsCount=").append(pointsCount);
        sb.append('}');
        return sb.toString();
    }
}
