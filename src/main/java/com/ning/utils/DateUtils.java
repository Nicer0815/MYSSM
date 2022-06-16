package com.ning.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static Date newDate(){
        return new Date();
    }

    public static Date cstStringToDate(String cst) {
        ////Sun Mar 12 00:00:00 CST 2023
        ////Wed Jul 04 10:36:06 CST 2018
        Date date = null;
        try {
            date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(cst);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date plusDays(Date date,int day){
        //System.out.println("ori:"+date);
        // 15天
        int time = day * 24 * 60 * 60 * 1000;
        date.setTime(date.getTime()+time);
        //System.out.println("aft:"+date);
        return date;
    }

    public static Date getTodayBegin(){
        //System.out.println("ori:"+date);
        // 15天
        Date date = new Date();
        int time = 24 * 60 * 60 * 1000;
        int exceed = 8 * 60 * 60 * 1000;
        long res = (date.getTime() + exceed)% time;
        System.out.println("今天已经过去了："+res*1.0/time);

        date.setTime(date.getTime()-res);
        //System.out.println("aft:"+date);
        return date;
    }

    public static void main(String[] args) {
        Date date = getTodayBegin();
        System.out.println("today begin:"+date);
        Date tomorrow = DateUtils.plusDays(date,1);
        System.out.println("tomorrow:"+tomorrow);
    }

}
