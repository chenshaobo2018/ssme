package cn.chen.oa.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 日历、日期、时间戳互相转换
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Demo1_Time {

	/**
	 * 日期与指定格式字符串
	 */
	@Test
	public void testName1() throws Exception {
		//日期转指定日期格式
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(date);
		System.out.println(formatDate);
		
		//指定格式日期转默认格式
		Date parseDate = sdf.parse("2019-01-20 09:19:14");
		System.out.println(parseDate);
	}
	
	/**
	 * 日期与时间戳
	 */
	@Test
	public void testName2() throws Exception {
		//日期转时间戳
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		
		//时间戳转日期
		Date date2 = new Date(time);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2));
	}
	
	/**
	 * 日历与日期
	 */
	@Test
	public void testName3() throws Exception {
		//日历转日期
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(date);
		
		//日期转日历
		calendar.setTime(date);
		
		//指定时间日期转日历
		int year = 2019;
		int month = 2;
		int day = 30;
		calendar.set(year, month-1, day);
	}
	
	/**
	 * 时间加一天
	 */
	@Test
	public void testName4() throws Exception {
		//方法一：利用时间戳加一天
		Date date = new Date(new Date().getTime()+24*60*60*1000);
		System.out.println(date);
		
		//方法二：利用日历加一天
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		
		Date date2 = calendar.getTime();
		System.out.println(date2);
		
	}

}
