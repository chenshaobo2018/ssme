package cn.chen.oa.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class Demo9_map {
	/**
	 * 1.LinkedList
	 */
	@Test
	public void testName1() throws Exception {
		List<Object> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		for (Object object : list) {
			String string = object.toString();
			System.out.println(string);
		}
	}
	
	/**
	 * 2.ArrayList
	 */
	@Test
	public void testName2() throws Exception {
		List<Object> arrayList = new ArrayList<>();
		arrayList.add("10");
		arrayList.add("20");
		arrayList.add("30");
		
		//1.遍历
		for (Object object : arrayList) {
			String string = object.toString();
			System.out.println(string);
		}
		
		//2.根据索引获得
		Object object = arrayList.get(1);
		System.out.println(object);
		System.out.println(object.toString());
	}
	
	/**
	 * 3.HashMap
	 */
	@Test
	public void testName3() throws Exception {
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("a", 11);
		hashMap.put("b", 21);
		hashMap.put("c", 31);
		
		//1.根据Entity遍历
		for (Map.Entry<String, Object> entry: hashMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "--" + value);
		}
		
		//2.根据key遍历
		
		//3.根据value遍历
		
		//4.根据key获得value
		Object object = hashMap.get("a");
		System.out.println(object);
	}
	
	/**
	 * 4.一定格式的数据转换，将[{"k1":"v1","k2":"v2"},{"k1":"v1","k2":"v2"}]转换为，List<Map<String,Object>>
	 * http://www.cnblogs.com/jpfss/p/8625526.html
	 */
	@Test
	public void testName4() throws Exception {
		String str = "[{\"name\":\"股东1\",\"scale\":\"20\",\"card_number\":\"888888\"},{\"name\":\"股东2\",\"scale\":\"20\",\"card_number\":\"666666\"}]";
		ArrayList<Map<String,Object>> list = JSON.parseObject(str, new ArrayList<Map<String,Object>>().getClass());
		System.out.println(list.toString());
		for (Map<String, Object> map : list) {
			System.out.println(map.get("name"));
		}
		
	}
}
