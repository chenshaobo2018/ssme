package cn.chen.oa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.chen.oa.utils.QRCodeUtil;

/**
 * 二维码生成
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Demo4_erweima {

	/**
	 * 1.二维码中无图片
	 */
	@Test
	public void testName1() throws Exception {
		//1.二维码内容
		String text = "http://192.168.1.4:8080/department/list";
		
		//2.二维码存储位置
		String savePath = "d:/aaab/barcode";
		
		//3.二维码生成
        QRCodeUtil.encode(text,"", savePath,true);
        System.out.println("运行完毕");
	}
	
	/**
	 * 2.二维码中有图片
	 */
	@Test
	public void testName2() throws Exception {
		//1.二维码内容
		String text = "http://192.168.1.4:8080/department/list";
		
		//2.二维码中图片位置
		String imgePath = "d:/erweima/image";
		
		//3.二维码存储位置
		String savePath = "d:/erweima/location";
		
		//4.二维码生成
        QRCodeUtil.encode(text,imgePath, savePath,true);
        System.out.println("运行完毕");
	}
}
