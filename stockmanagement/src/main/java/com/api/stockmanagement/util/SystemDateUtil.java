package com.api.stockmanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SystemDateUtil {
	public static Date getLocalDateTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
        return localDateFormat.parse( simpleDateFormat.format(new Date()) );
    }

    public static Date getCurrentUtcTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
        return localDateFormat.parse( simpleDateFormat.format(new Date()) );
    }


    public static String getLocalDate(String pattern)  {
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
            return simpleDateFormat.format(new Date());
    	}catch (Exception e) {
    		e.printStackTrace();
		}
		return null;
        
    }
    
    public static String get() throws ParseException {
        String pattern = "yyyyMMdd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(SystemDateUtil.getLocalDateTime());
    }

    public static void main(String a[]) throws Exception {

        String pattern = "yyyyMMdd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(SystemDateUtil.getLocalDateTime());

        System.out.println(date);
        System.out.println(SystemDateUtil.getCurrentUtcTime());
        System.out.println("getLocalDate :"+SystemDateUtil.getLocalDate("ddMMyyyyhhmmsss"));

    }
}
