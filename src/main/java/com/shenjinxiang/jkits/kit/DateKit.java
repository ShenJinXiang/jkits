package com.shenjinxiang.jkits.kit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateKit {

    public static final String C_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String C_DATE_PATTERN = "yyyy-MM-dd";
    public static final String C_TIME_PATTERN = "HH:mm:ss";


    public static String currentDate() {
        return formatDate(Calendar.getInstance().getTime());
    }

    public static String currentTime() {
        return formatTime(Calendar.getInstance().getTime());
    }

    public static String currentDateTime() {
        return formatDateTime(Calendar.getInstance().getTime());
    }

    public static String formatDate(Date date) {
        return format(date, C_DATE_PATTERN);
    }

    private static String formatTime(Date date) {
        return format(date, C_TIME_PATTERN);
    }

    private static String formatDateTime(Date date) {
        return format(date, C_DATE_TIME_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (null == date || null == pattern) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern(pattern);
        return dateFormat.format(date);
    }
}
