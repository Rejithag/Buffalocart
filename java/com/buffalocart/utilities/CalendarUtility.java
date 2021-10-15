package com.buffalocart.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtility {
	
	public static String getCurrentDate() {
		
		DateFormat formatdate=new SimpleDateFormat("MM/dd/yyyy");
		Date date=new Date();
		String datevalue=formatdate.format(date);
		return datevalue;
		
	}

}
