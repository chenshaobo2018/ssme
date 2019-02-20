package cn.chen.oa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {

	public static void main(String[] args) throws ParseException {
//		String goods_spec_format = "["+"{"+
//                "\"create_time\""+":"+"\""+"dddd"+"\""
//                +"}"+"]";
//		System.out.println(goods_spec_format);
		
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date date2 = new Date();
	    String time=format.format(date2);
	    Date date = format.parse(time);  
	    System.out.println(date.getTime());  
	    System.out.println(date2.getTime());
	    
	    String a = date2.getTime() + "";
	    String substring = a.substring(0, a.length()-3);
	    System.out.println(substring);
	    System.out.println(Integer.parseInt(substring));
	}

}
