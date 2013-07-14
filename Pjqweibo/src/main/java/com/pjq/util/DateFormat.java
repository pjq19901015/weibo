package com.pjq.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 13-7-14
 * Time: ÏÂÎç3:28
 * To change this template use File | Settings | File Templates.
 */
public class DateFormat {

    public static String getDateTimeByMillisecond(String str) {
        Date date = new Date(str);
        SimpleDateFormat format = new SimpleDateFormat("MMÔÂddÈÕ  HH:mm");
        String time = format.format(date);
        return time;
    }

}
