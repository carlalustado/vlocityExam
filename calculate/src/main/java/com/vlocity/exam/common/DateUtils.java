package com.vlocity.exam.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vlocity.exam.constants.Constants;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	public static int getDay(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
	public static Date stringToDate(String string) throws ParseException {
        Date resultDate = null;
        try {
        	resultDate = new SimpleDateFormat(Constants.DATE_FORMAT).parse(string);
        } catch (ParseException e) {
        	System.out.println("Incorrect date format!");
        	throw e;
        }
        return resultDate;
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
        return sdf.format(date);
	}

}
