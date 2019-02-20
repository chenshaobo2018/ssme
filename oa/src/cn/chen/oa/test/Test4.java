package cn.chen.oa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Test4 {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
        //日历，毫秒，日期
        
        //日期
        Date now = new Date();
        System.out.println(now);
        
        //默认日期格式转指定格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String format = df.format(new Date());
        System.out.println(format);
        
        //指定格式转默认日期格式
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-12-29 17:16:08");
        System.out.println(parse);
        
        //日期转毫秒
        long time = new Date().getTime();//当前的毫秒数
        System.out.println(time);
        
        //毫秒转日期
        long currentTimeMillis = System.currentTimeMillis();//当前的毫秒数
        System.out.println(currentTimeMillis);
        Date date = new Date(currentTimeMillis);
        System.out.println(date);
        
        //日期转日历
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        System.out.println("----"+calendar1);
        
        
        //日历转日期
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();//当前的毫秒数
        System.out.println(timeInMillis);
        System.out.println(instance);//java.util.GregorianCalendar[time=1546075381630,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=11,WEEK_OF_YEAR=52,WEEK_OF_MONTH=5,DAY_OF_MONTH=29,DAY_OF_YEAR=363,DAY_OF_WEEK=7,DAY_OF_WEEK_IN_MONTH=5,AM_PM=1,HOUR=5,HOUR_OF_DAY=17,MINUTE=23,SECOND=1,MILLISECOND=630,ZONE_OFFSET=28800000,DST_OFFSET=0]
        Date date2 = instance.getTime();
        System.out.println(date2);
        
        //设置一个日历，然后转为日期
        Calendar calendar = Calendar.getInstance();
        int year = 2019;
        int month = 2;
        int day = 29;
        calendar.set(year, month - 1, day);//设置日历时间，月份必须减一，0月代表一月
        Date time2 = calendar.getTime();
        System.out.println(time2);//自动变为3月1号
        
        //时间加一天
        String str = "2019-02-29 17:16:08";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse2 = simpleDateFormat.parse(str);
        long time3 = parse2.getTime();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(parse2);
        
        //方法一：date加1天
        
        //方法二：毫秒加1天
        System.out.println(simpleDateFormat.format(new Date(time3+24*60*60*1000)));
        
        //方法三：日历加一天加1天
        instance2.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(simpleDateFormat.format(instance2.getTime()));
	}

}