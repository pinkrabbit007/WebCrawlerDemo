package com.zhangjunqiao.zchz.qqzonegetpics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author zjq
 * @aim 学习了UUID的获取，2种时间戳的获取，时间戳转时间
 * 
 * 
 */
public class App4 {
	/*
	 * UUID的获取
	 */
	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	/*
	 * System.currentTimeMillis() 是第一种获取时间戳的方法，java中生成的时间戳精确到毫秒级别，
	 * 而unix中精确到秒级别，所以通过java生成的时间戳需要除以1000。
	 */
	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000); // 为啥要除以1000？
	}

	/*
	 * java中Date类中的getTime()是第二种获取时间戳的方法
	 */
	private static String create_timestamp2() {
		Date date = new Date();
		/*
		 * Long.toString是一个静态函数，能够把long类型转化为String 类型，注意是long而不是Long包装类
		 */
		return Long.toString(date.getTime() / 1000);
	}

	/*
	 * 时间戳转时间
	 */
	private static void timeStamp2time(String timestamp) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(timestamp) * 1000L;   // 乘以1000，恢复单位为秒形成Long包装类
		String d = format.format(time);  //用format类格式化Long为String
		Date date = format.parse(d);   //把已经格式化好的String转为Date类

		System.out.println("Format To String(Date):" + d);

		System.out.println("Format To Date:" + date);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(create_nonce_str());
		System.out.println(create_timestamp2());
		timeStamp2time(create_timestamp());
	}
}