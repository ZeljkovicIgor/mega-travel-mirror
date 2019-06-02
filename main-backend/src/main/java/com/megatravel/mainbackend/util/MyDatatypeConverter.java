package com.megatravel.mainbackend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDatatypeConverter {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");


	public static Date parseDate(String value) {
		try {
			return dateFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String printDate(Date value) {
		if (value != null)
			return dateFormat.format(value);
		else
			return null;

	}

	public static Date parseDateTime(String value) {
		try {
			return dateTimeFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String printDateTime(Date value) {
		if (value != null)
			return dateTimeFormat.format(value);
		else
			return null;

	}

}
