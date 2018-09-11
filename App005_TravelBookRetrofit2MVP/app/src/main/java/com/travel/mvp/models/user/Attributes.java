package com.travel.mvp.models.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tran Manh on 8/31/2018.
 */
public class Attributes {
    /** User attribute*/
    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("username")
    private String userName;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("location")
    private String location;

    @SerializedName("points_count")
    private String pointsCount;

    @SerializedName("friendships_count")
    private Integer friendshipsCount;

    @SerializedName("countries_count")
    private Integer countriesCount;

    @SerializedName("friend_request")
    private FriendRequest friendRequest;

    @SerializedName("is_friend")
    private Boolean isFriend;

    /** Place attribute*/
    @SerializedName("provider")
    private String provider;

    @SerializedName("provider_place_id")
    private String providerPlaceId;

    @SerializedName("country")
    private String country;

    @SerializedName("geolocation")
    private Geolocation geolocation;

    @SerializedName("cover_image")
    private String coverImage;

    @SerializedName("citylogues_count")
    private Integer cityloguesCount;

    @SerializedName("city")
    private String city;

    @SerializedName("locality")
    private String locality;

    @SerializedName("cityguide_slug")
    private String cityguideSlug;

    /** Common attribute*/
    @SerializedName("name")
    private String name;

    public Attributes(String firstName, String lastName, String userName, String avatar, String location, String pointsCount, Integer friendshipsCount, Integer countriesCount, FriendRequest friendRequest, Boolean isFriend, String provider, String providerPlaceId, String country, Geolocation geolocation, String coverImage, Integer cityloguesCount, String city, String locality, String cityguideSlug, String name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.avatar = avatar;
        this.location = location;
        this.pointsCount = pointsCount;
        this.friendshipsCount = friendshipsCount;
        this.countriesCount = countriesCount;
        this.friendRequest = friendRequest;
        this.isFriend = isFriend;
        this.provider = provider;
        this.providerPlaceId = providerPlaceId;
        this.country = country;
        this.geolocation = geolocation;
        this.coverImage = coverImage;
        this.cityloguesCount = cityloguesCount;
        this.city = city;
        this.locality = locality;
        this.cityguideSlug = cityguideSlug;
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(String pointsCount) {
        this.pointsCount = pointsCount;
    }

    public Integer getFriendshipsCount() {
        return friendshipsCount;
    }

    public void setFriendshipsCount(Integer friendshipsCount) {
        this.friendshipsCount = friendshipsCount;
    }

    public Integer getCountriesCount() {
        return countriesCount;
    }

    public void setCountriesCount(Integer countriesCount) {
        this.countriesCount = countriesCount;
    }

    public FriendRequest getFriendRequest() {
        return friendRequest;
    }

    public void setFriendRequest(FriendRequest friendRequest) {
        this.friendRequest = friendRequest;
    }

    public Boolean getFriend() {
        return isFriend;
    }

    public void setFriend(Boolean friend) {
        isFriend = friend;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderPlaceId() {
        return providerPlaceId;
    }

    public void setProviderPlaceId(String providerPlaceId) {
        this.providerPlaceId = providerPlaceId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getCityloguesCount() {
        return cityloguesCount;
    }

    public void setCityloguesCount(Integer cityloguesCount) {
        this.cityloguesCount = cityloguesCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCityguideSlug() {
        return cityguideSlug;
    }

    public void setCityguideSlug(String cityguideSlug) {
        this.cityguideSlug = cityguideSlug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Attributes{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", pointsCount='").append(pointsCount).append('\'');
        sb.append(", friendshipsCount=").append(friendshipsCount);
        sb.append(", countriesCount=").append(countriesCount);
        sb.append(", friendRequest=").append(friendRequest);
        sb.append(", isFriend=").append(isFriend);
        sb.append(", provider='").append(provider).append('\'');
        sb.append(", providerPlaceId='").append(providerPlaceId).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", geolocation=").append(geolocation);
        sb.append(", coverImage='").append(coverImage).append('\'');
        sb.append(", cityloguesCount=").append(cityloguesCount);
        sb.append(", city='").append(city).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", cityguideSlug='").append(cityguideSlug).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
