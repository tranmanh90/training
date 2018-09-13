package com.travel.mvp.constants;

/**
 * Created by Tran Manh on 9/10/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class Constants {

    public static final String ACCESS_TOKEN_KEY = "access_token";
    public static final String REFERENCE_KEY    = "scopes";
    public static final String FRIENDS_SCOPE    = "friends";
    public static final String COMMUNITY_SCOPE  = "community";

    public static final Integer CONNECT_TIMEOUT = 10;
    public static final Integer READ_TIMEOUT    = 10;
    public static final Integer WRITE_TIMEOUT   = 20;


    public static final class Color {
        public static final Integer[] FRIENDS_HIGHLIGHT     = {255, 236, 81, 105, 255, 0, 0, 0};
        public static final Integer[] COMMUNITY_HIGHLIGHT   = {255, 0, 0, 0, 255, 236, 81, 105};
    }

}
