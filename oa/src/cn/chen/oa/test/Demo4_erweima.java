package cn.chen.oa.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import cn.chen.oa.utils.BufferedImageLuminanceSource;
import cn.chen.oa.utils.QRCodeUtil;
/**
 * 二维码生成
 * 	① https://www.cnblogs.com/whiteme/p/7196582.html
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
		String text = "66758";
		
		//2.二维码存储位置
		String savePath = "d:/erweimaImage/erweima";
		
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
		String text = "66758";
		
		//2.二维码中图片位置
		String imgePath = "d:/erweimaImage/image";
		
		//3.二维码存储位置
		String savePath = "d:/erweimaImage/erweima";
		
		//4.二维码生成
        QRCodeUtil.encode(text,imgePath, savePath,true);
        System.out.println("运行完毕");
	}
	
	/**
	 * 3.二维码读取
	 */
	@Test
	public void testName3() throws Exception {
        try {
        	//
            File f=new File("D:/erweimaImage/erweima/33121916.jpg");
            BufferedImage image=ImageIO.read(f);
            BinaryBitmap bb=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            HashMap map =new HashMap();
            map.put(EncodeHintType.CHARACTER_SET, "utf-8");
            
            //
            MultiFormatReader reader=new MultiFormatReader();
            Result result = reader.decode(bb,map);
            
            //
            System.out.println("解析结果："+result.toString());
            System.out.println("二维码格式类型："+result.getBarcodeFormat());
            System.out.println("二维码文本内容："+result.getText());
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
