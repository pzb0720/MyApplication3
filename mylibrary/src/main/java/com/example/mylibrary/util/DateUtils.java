package com.example.mylibrary.util;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2018/12/8 0008.
 */

public class DateUtils {
    public static String formatDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(time);
        return date;

    }




}
