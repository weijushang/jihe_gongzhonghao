package com.hongte.weixin.util;

import java.util.Calendar;
import java.util.Date;

import org.jboss.logging.Logger;

public class DateUtil {
	private static Logger log = Logger.getLogger(DateUtil.class);

	public static long getMonth(Date startDate, Date endDate) {
		log.info("首期还款日："+startDate+";"+"当前日期："+endDate);
		long monthday;
		// 开始时间与今天相比较
		Date endDate1 = new Date();

		Calendar starCal = Calendar.getInstance();
		starCal.setTime(startDate);

		int sYear = starCal.get(Calendar.YEAR);
		int sMonth = starCal.get(Calendar.MONTH);
		int sDay = starCal.get(Calendar.DATE);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate1);
		int eYear = endCal.get(Calendar.YEAR);
		int eMonth = endCal.get(Calendar.MONTH);
		int eDay = endCal.get(Calendar.DATE);

		monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

		if (sDay < eDay) {
			monthday = monthday + 1;
		}
		return monthday;
	}
	
}
