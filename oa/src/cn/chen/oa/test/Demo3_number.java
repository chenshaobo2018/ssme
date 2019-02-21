package cn.chen.oa.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

/**
 * 数字互相转换
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Demo3_number {

	/**
	 * 截去小数后两位
	 */
	@Test
	public void testName1() throws Exception {
		BigDecimal bigDecimal = new BigDecimal(2.333);
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(bigDecimal.toString());
	}
	
	/**
	 * 一定格式的数据转换，将[{"k1":"v1","k2":"v2"},{"k1":"v1","k2":"v2"}]转换为，List<Map<String,Object>>
	 * http://www.cnblogs.com/jpfss/p/8625526.html
	 */
	@Test
	public void testName2() throws Exception {
		String str = "[{\"name\":\"股东1\",\"scale\":\"20\",\"card_number\":\"888888\"},{\"name\":\"股东2\",\"scale\":\"20\",\"card_number\":\"666666\"}]";
		ArrayList<Map<String,Object>> list = JSON.parseObject(str, new ArrayList<Map<String,Object>>().getClass());
		System.out.println(list.toString());
		for (Map<String, Object> map : list) {
			System.out.println(map.get("name"));
		}
		
	}
	
	@Test
	public void testName3() throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 map.put("type", 1);
		 System.out.println(map.get("type"));
	}

}
