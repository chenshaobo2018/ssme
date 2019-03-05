package cn.chen.oa.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * http请求
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Demo6_http {
	//测试
	@Test
	public void testName1() throws Exception {
		Demo6_http ht = new Demo6_http();
        String url = "http://www.baidu.com";
        String param="";
        String head1 = "Content-Type";
        String head2 = "application/json";
        //ht.httpConn(url,param,head1,head2);
        ht.doPost(url,param,head1,head2);
	}

	//方法
	//get方式：参数放置在url上
    public void httpConn(String url1, String param , String head1, String head2){
        String urlNameString = url1 + "?" + param; 
        try{
            URL url = new URL(url1);
            //打开url的连接
            URLConnection conn = url.openConnection();
            //设置连接属性
            conn.setConnectTimeout(6*1000);
            //获得输入流，并封装为字符
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));//获得网络返回的输入流
            String line;
            String result=null;
            while ((line = in.readLine()) != null) {
                result += "/n" + line;
            }
            result=new String(result.getBytes(),"UTF-8");
            System.out.println("result"+result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
         
        }
    }
     
    //post方式，以输出流的形式发送
    public void doPost(String url1, String param , String head1, String head2){
        try{
            URL url = new URL(url1);
            //打开url的连接
            URLConnection conn = url.openConnection();
            
            //设置url的连接属性
            conn.setConnectTimeout(6*1000);
            conn.setDoOutput(true);    //设置OutPut是Ture
            
            //获得输出流，并将其封装为字符流
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            
            //按字节的方式打印输出字符，并写入数组的某一部分
            out.print(param);
            
            //刷新输出流的缓冲
            out.flush();
            
            //获得网络返回的输入流，并封装为输入流
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            String result=null;
            while ((line = in.readLine()) != null) {
                result += "/n" + line;
            }
            result=new String(result.getBytes(),"UTF-8");
            System.out.println("result"+result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
         
        }
    }
}
