package com.travel.mvp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tran Manh on 9/8/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class DateTimeFormatUtil {

    public String convertDate(String inDate) {
        String mounthYear = "";
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssZ");
        DateFormat df2 = new SimpleDateFormat("MMM\nyyyy");

        try {
            Date date = df1.parse(inDate.replaceAll("Z$", "+0000"));
            mounthYear = df2.format(date).toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mounthYear;
    }
}
