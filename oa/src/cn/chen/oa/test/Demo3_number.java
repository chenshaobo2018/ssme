package cn.chen.oa.test;

import static org.junit.Assert.*;

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
	
	@Test
	public void testName3() throws Exception {
		 Map<String, Object> map = new HashMap<>();
		 map.put("type", 1);
		 System.out.println(map.get("type"));
	}
	
	@Test
	public void testName4() throws Exception {
		try {
			String str1 = "10.1a";
			String str2 = "10";
			double double1 = Double.parseDouble(str1);
			double double2 = Double.parseDouble(str2);
			System.out.println(double1+"--"+double2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据异常");
		}
	}
	
	@Test
	public void testName5() throws Exception {
		String str = "11111111111111\r\n22222222222222222222";
		System.out.println(str);
	}

}
