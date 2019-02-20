package cn.chen.oa.test;

import cn.chen.oa.utils.QRCodeUtil;

public class Test6 {
	public static void main(String[] args) throws Exception {
        String text = "http://192.168.1.4:8080/department/list";

        //1.无图片
//        QRCodeUtil.encode(text,"", "d:/aaab/barcode",true);
        
        //2.有图片
        QRCodeUtil.encode(text,"C:/Users/Administrator/Desktop/tupian/abc.png","d:/erweima", true);
        System.out.println("运行完毕");
	}
}
