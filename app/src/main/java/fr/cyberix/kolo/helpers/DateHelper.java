/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tmhar on 10/15/2017.
 */

public final class DateHelper {
    public long diffInDays;
    public long diffInHours;
    public long diffInMin;
    public long diffInSec;
    public long diffResult;

    public static DateHelper DateDiff(Date beginDate, Date endDate) {
        DateHelper dateHelper = new DateHelper();
        dateHelper.diffResult = endDate.getTime() - beginDate.getTime();
        dateHelper.diffInDays = TimeUnit.MILLISECONDS.toDays(dateHelper.diffResult);
        dateHelper.diffInHours = TimeUnit.MILLISECONDS.toHours(dateHelper.diffResult);
        dateHelper.diffInMin = TimeUnit.MILLISECONDS.toMinutes(dateHelper.diffResult);
        dateHelper.diffInSec = TimeUnit.MILLISECONDS.toSeconds(dateHelper.diffResult);
        return dateHelper;
    }

    public static Date String2Date(String s)
    {
        if (s != null | s != "") {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(KoloConstants.DATE_FORMAT_FOR_SERVICE);
            try {
                return simpleDateFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

    public static String Date2String(Date d)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(KoloConstants.DATE_FORMAT_FOR_SERVICE);
        return simpleDateFormat.format(d);
    }


}
