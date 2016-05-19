package com.dean.study.scheduletabledemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by TianWei on 2016/5/19.
 */
public class WeekToDay {


    public static String[] getStringDate(String date) throws ParseException {
        String[] weeks = new String[7];//返回的这周的日期
        String[] a = date.split("-");
        int week = getDayOfWeek(a[0], a[1], a[2]);//获取周几
        int minWeek = 0;
        int maxWeek = 7;
        String format = "yyyy-MM-dd";

        if (week == 1) {//如果是周日（老外是从周日开始算一周，所以有点恶心）
            weeks[6] = date;
            for (int i = 5; i >= 0; i--) {
                weeks[i] = getFormatDateAdd(getStrToDate(date, format), -1, format);
                date = weeks[i];
            }
        } else {
            int temp = week - 2;
            weeks[temp] = date;
            for (int i = temp - 1; i >= minWeek; i--) {
                weeks[i] = getFormatDateAdd(getStrToDate(date, format), -1, format);
                date = weeks[i];
            }
            date = weeks[temp];
            for (int i = temp + 1; i < maxWeek; i++) {
                weeks[i] = getFormatDateAdd(getStrToDate(date, format), 1, format);
                date = weeks[i];
            }
        }

        return weeks;
    }

    /**
     * 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
     *
     * @param year
     * @param month month是从1开始的12结束
     * @param day
     * @return 返回一个代表当期日期是星期几的数字。1表示星期天、2表示星期一、7表示星期六。
     */
    public static int getDayOfWeek(String year, String month, String day) {
        Calendar cal = new GregorianCalendar(new Integer(year).intValue(),
                new Integer(month).intValue() - 1, new Integer(day).intValue());
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 取得给定日期加上一定天数后的日期对象.
     *
     * @param date   给定的日期对象
     * @param amount 需要添加的天数，如果是向前的天数，使用负数就可以.
     * @param format 输出格式.
     * @return Date 加上一定天数以后的Date对象.
     */
    public static String getFormatDateAdd(Date date, int amount, String format) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(GregorianCalendar.DATE, amount);
        return getFormatDateTime(cal.getTime(), format);
    }

    /**
     * 根据给定的格式与时间(Date类型的)，返回时间字符串。最为通用。<br>
     *
     * @param date   指定的日期
     * @param format 日期格式字符串
     * @return String 指定格式的日期字符串.
     */
    public static String getFormatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 返回制定日期字符串的date格式
     *
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date getStrToDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }
}