package cn.chen.oa.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) throws ParseException {
		String happen_time = "2018-12-18 16:11:33";
//		//发生时间
//        Date happenTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(happen_time);
//        //截止日期
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(happenTime);
//        calendar.add(Calendar.DAY_OF_MONTH, 3);
//        long startTime = happenTime.getTime();//开始时间毫秒数
//        long endTime = calendar.getTime().getTime();//结束时间的毫秒数
//        Date happenTime2 = calendar.getTime();
//        System.out.println(happenTime);
//        System.out.println(happenTime2);
//        System.out.println(startTime);
//        System.out.println(endTime);
//        System.out.println(System.currentTimeMillis() >= startTime);
//        System.out.println(System.currentTimeMillis() <= endTime);
		
		List<Object> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		for (Object object : list) {
			String string = object.toString();
			System.out.println(string);
		}
		
		List<Object> arrayList = new ArrayList<>();
		arrayList.add("10");
		arrayList.add("20");
		arrayList.add("30");
		for (Object object : arrayList) {
			String string = object.toString();
			System.out.println(string);
		}
		
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("a", 11);
		hashMap.put("b", 21);
		hashMap.put("c", 31);
		for (Map.Entry<String, Object> entry: hashMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "--" + value);
		}
	}

}
