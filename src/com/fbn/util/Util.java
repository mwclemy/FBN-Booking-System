package com.fbn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public String formatDate(Date date) {
		if (!date.equals(null)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");			
			return sdf.format(date);
		}
		return date.toString();
		
	}

}
