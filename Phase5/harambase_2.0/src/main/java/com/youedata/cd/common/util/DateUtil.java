package com.youedata.cd.common.util;

/**
 * @FileName: DateUtil.java
 * @Author 
 * @Description:
 * @Date 2016年9月13日 下午6:18:01
 * @CopyRight youedata
 */

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtil {
	/**
	 * 
	 * @Title: checkTimeOut
	 * @Description:判断两个时间差是否查过30分钟
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return boolean true表示不超过，false表示超过
	 */
	public static boolean checkNotTimeOut(Date startTime, Date endTime) {
		if (startTime != null && endTime != null) {
			long between = endTime.getTime() - startTime.getTime();
			long day = between / (24 * 60 * 60 * 1000);
			long hour = (between / (60 * 60 * 1000) - day * 24);
			long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
			return ((hour == 0) && (day == 0) && (min <= 30));
		} else {
			return false;
		}
	}

	/**
	 * @Title: daysBetween
	 * @Description: 判断相差天数
	 * @param @param date1
	 * @param @param date2
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1 + 1000) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 
	 * @Title: checkAfterToday
	 * @Description:判断所给时间是否超过今天
	 * @param date
	 * @return boolean 返回true表示date大于等于今天，返回false表示小于今天
	 */
	public static boolean checkAfterToday(Date date) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return date.getTime() >= calendar.getTimeInMillis();
	}

	/**
	 * 日期类型转换
	 * 
	 * @param source
	 *            日期字符串
	 * @param format
	 *            字符串格式
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parse(String source, String format) {
		try {
			if (source == null || format == null) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(source);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @Title: format
	 * @Description:date转换为指定格式的string
	 * @param date
	 * @param pattern
	 * @return
	 * @throws Exception
	 *             String
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateformat;
		try {
			dateformat = sdf.format(date);
		} catch (Exception e) {
			return "";
		}
		return dateformat;
	}
	
	/**
	 * 当前时间转化为字符串
	 * @return
	 */
	public static String nowTimeToStr() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateformat;
		try {
			dateformat = sdf.format(date);
		} catch (Exception e) {
			return "";
		}
		return dateformat;	
	}

	/**
	 * @Title: subtract
	 * @Description 计算两个日期相差的天数, 不足1天时计算为1天
	 * @param bigDate
	 *            较大的时间
	 * @param smallDate
	 *            较小的时间
	 * @return Integer 天数
	 */
	public static Integer subtract(Date bigDate, Date smallDate) {
		if (bigDate == null || smallDate == null)
			return -1;

		return (int) ((bigDate.getTime() - smallDate.getTime()
				+ DateUtils.MILLIS_PER_DAY - 1) / DateUtils.MILLIS_PER_DAY);
	}
    
	/**
	 * 是否合法的年份
	 * @param year
	 * @return
	 */
	public static boolean isYear(String year) {
		Pattern p = Pattern.compile("^[1-9][0-9]{3}$");
		return p.matcher(year).matches();
	}
	
	/**
	 * 是否是合法的年月
	 * @param dateStr
	 * @return
	 */
	public static boolean isYearAndMonth(String dateStr) {
		Pattern p = Pattern.compile("^[1-9][0-9]{3}\\-((0[1-9])|(1[012]))$");
		return p.matcher(dateStr).matches();
	}
	
	/**
	 * 是否是合法的月份
	 * @param dateStr
	 * @return
	 */
	public static boolean isMonth(String dateStr) {
		Pattern p = Pattern.compile("^((0[1-9])|(1[012]))$");
		return p.matcher(dateStr).matches();
	}
	
	
	/**
	 * 日期是否合法
	 * @param dateStr
	 * @return
	 */
	public static boolean isDate(String dateStr) {
		Pattern p = Pattern.compile("^[1-9][0-9]{3}\\-((0[1-9])|(1[012]))\\-((0[1-9])|([12][0-9])|(3[01]))$");
		return p.matcher(dateStr).matches();
	}
	
	public static Date addMonthOne(Date dt) {
        Calendar g = Calendar.getInstance();  
        g.setTime(dt);  
        g.add(Calendar.MONTH, 1);             
        return g.getTime();  
	}
	
	/**
	 * 两个日期之间相差的秒数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long calLastedTime(Date startDate, Date endDate) {
		return (long) ((endDate.getTime() - startDate.getTime()) / 1000);
	}
	
	public static Date getCalendarDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.YEAR, year); 
        calendar.set(Calendar.MONTH, month-1 ); 
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置日期  
        return calendar.getTime();
	}
	
	public static Date addDateTimeCalendar(int year, int month, int day, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month-1 ); 
		cal.set(Calendar.DAY_OF_MONTH, day);//设置日期  
		cal.add(Calendar.SECOND, second);
		return cal.getTime();
	}

    public static String firstSevenDays(String pattern) {
    	if (YoueStringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		//过去七天
		c.setTime(new Date());
		c.add(Calendar.DATE, - 7);
		Date d = c.getTime();
		String day = format.format(d);
		return day;
	}

	public static String firstOneMonth(String pattern) {
		if (YoueStringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		return  mon;
	}

	public static String firstThreeMonth(String pattern) {
		if (YoueStringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -3);
		Date m = c.getTime();
		String mon = format.format(m);
		return  mon;
	}

	public static String firstOneDay(String pattern) {
		if (YoueStringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_YEAR, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		return  mon;
	}

	public static String firstOneWeek(String pattern) {
		if (YoueStringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.WEEK_OF_YEAR, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		return  mon;
	}

	public static String firstOneYear(String pattern) {

		if (YoueStringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		//过去一年
		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date y = c.getTime();
		String year = format.format(y);
		return year;
	}

	public static int isGreaterThanDate(String mydate) {
		if (YoueStringUtils.isEmpty(mydate)) {
			return -1;
		}
		Date nowdate = new Date();
		Date d = parse(mydate, "yyyy-MM-dd");
		boolean flag = d.before(nowdate);
		if(flag) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(firstOneYear("yyyy-MM-dd 00:00:00"));
		System.out.println(firstOneMonth("yyyy-MM-dd 00:00:00"));
        System.out.println(firstOneDay("yyyy-MM-dd 00:00:00"));
		System.out.println(firstOneWeek("yyyy-MM-dd 00:00:00"));

		isGreaterThanDate("2017-04-11 00:00:00");
	}
	
}
