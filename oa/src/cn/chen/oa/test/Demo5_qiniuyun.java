package cn.chen.oa.test;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;

/**
 * 图片上传七牛云--还未成功
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Demo5_qiniuyun {
		
	@Test
	public void testName1() throws Exception {
		String accessKey = "6_u_rX2f37Apc1N-SwGjXIitehJ9hrsUjqZXxLEP";
		String secretKey = "QgSEhcV80_Kzkdp0bjcSibXfjR2IrXx5KahfJzCq";
		String bucket = "image";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		System.out.println(upToken);
	}
	
	//图片上传，根据图片在本地地址
	@Test
	public void testName2() throws Exception {
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone2());
		//...其他参数参考类注释

		//...生成上传凭证，然后准备上传
		String accessKey = "6_u_rX2f37Apc1N-SwGjXIitehJ9hrsUjqZXxLEP";
		String secretKey = "QgSEhcV80_Kzkdp0bjcSibXfjR2IrXx5KahfJzCq";
		String bucket = "image";
		//如果是Windows情况下，格式是 D:\\qiniu\\test.png
		String localFilePath = "C:\\Users\\Administrator\\Desktop\\tupian\\ccc.png";
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = null;

		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);

		String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), bucket).toString();
		try {
		    //设置断点续传文件进度保存目录
		    FileRecorder fileRecorder = new FileRecorder(localTempDir);
		    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
		    try {
		        Response response = uploadManager.put(localFilePath, key, upToken);
		        //解析上传成功的结果
		        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		        System.out.println(putRet.key);//FrXvJh0k5vvYTJreW0d8xpK-wNex
		        System.out.println(putRet.hash);//FrXvJh0k5vvYTJreW0d8xpK-wNex
		        //外链接地址：http://pm8zobdhg.bkt.clouddn.com/FrXvJh0k5vvYTJreW0d8xpK-wNex
		    } catch (QiniuException ex) {
		        Response r = ex.response;
		        System.err.println(r.toString());
		        try {
		            System.err.println(r.bodyString());
		        } catch (QiniuException ex2) {
		            //ignore
		        }
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
}
