package com.jpmorgan.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

public class AppUtil {
	
	private AppUtil(){}
	
	public static final Double ZERO	= 0.0D;
	
	public static final Date getNowLessMinutes(int minutes){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, -minutes);
		return now.getTime();
	}
	
	public static final double returnNumerTwoDecimals(double value){
		try {
		    BigDecimal bd = new BigDecimal(value);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    return bd.doubleValue();
		} catch (Exception e) {
			return value;
		}
	
	}
	

}

