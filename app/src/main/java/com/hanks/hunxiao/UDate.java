package com.hanks.hunxiao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 根据提供当前时间及给定的格式，返回时间字符串
 */
public class UDate {

    /**
     * 获取当前的时间字符串
     *
     * @param format yy-MM-dd HH
     * @return 字符串形式的当前时间
     */
    public static String getNowDate(String format) {
        return new SimpleDateFormat(format, Locale.US).format(new Date());
    }

    /**
     * 判断时间是否大于当前时间 如果大于返回true 否则返回false
     *
     * @param DATE1
     * @return
     */
    public static boolean compare_date(String DATE1) {


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(getCurrentTime());
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else if (dt1.getTime() < dt2.getTime()) {
                return false;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }


    /**
     * 将给定时间转换成字符串
     *
     * @param date   时间戳
     * @param format 格式
     * @return str
     */
    public static String format(long date, String format) {
        return new SimpleDateFormat(format, Locale.CHINESE).format(new Date(date));
    }

    /**
     * 将给定时间转换成字符串
     *
     * @param date   long类型的字符串时间戳
     * @param format 格式
     * @return str
     */
    public static String format(String date, String format) {
        long s1 = 0;
        try {
            s1 = Long.parseLong(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (s1 <= 0) {
            return null;
        }
        return format(s1, format);
    }

    /**
     * 2018-05-18T08:10:10
     *
     * @param strDate
     * @return
     */
    public static String getDateFormatyyyymmddFromStrDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-ddTHH:mm:ss");
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        return f.format(date);
    }

    /**
     * 根据日期获取年龄
     *
     * @param year 1990
     * @return int;年龄
     */
    public static int getAge(String year) {
        int iAge;
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 判断是否为合法的日期时间字符串
     *
     * @param strInput   时间字符串
     * @param dateFormat 格式
     * @return boolean;符合为true,不符合为false
     */
    public static boolean isDate(String strInput, String dateFormat) {
        boolean result = false;
        if (strInput != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.CHINESE);
            formatter.setLenient(false);
            try {
                formatter.format(formatter.parse(strInput));
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 验证小于当前日期 是否有效
     *
     * @param iYear  待验证日期(年)
     * @param iMonth 待验证日期(月 1-12)
     * @param iDate  待验证日期(日)
     * @return 符合为true, 不符合为false
     */
    public static boolean isDate(int iYear, int iMonth, int iDate) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int datePerMonth;
        if (iYear < 1900 || iYear >= year) {
            return false;
        }
        if (iMonth < 1 || iMonth > 12) {
            return false;
        }
        switch (iMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                datePerMonth = 30;
                break;
            case 2:
                boolean dm = ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0)) && (iYear > 1900 && iYear < year);
                datePerMonth = dm ? 29 : 28;
                break;
            default:
                datePerMonth = 31;
        }
        return (iDate >= 1) && (iDate <= datePerMonth);
    }


    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime(String strDateFormat) {
        SimpleDateFormat f = new SimpleDateFormat(strDateFormat);
        Date date = new Date();
        return f.format(date);
    }

    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getMMss(long second) {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("mm:ss");
        Date date = new Date(second);
        returnStr = f.format(date);
        return returnStr;
    }
    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getyyyymmdd(long second) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date(second);
        return f.format(date);
    }

    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getSimpleDateFormatTime(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        return f.format(date);
    }

    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getSimpleDateFormatTime(Date date, String str) {
        SimpleDateFormat f = new SimpleDateFormat(str);
        return f.format(date);
    }
}
