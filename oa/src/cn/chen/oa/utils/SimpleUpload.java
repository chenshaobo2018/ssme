package cn.chen.oa.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class SimpleUpload {
	Auth auth = Auth.create(AccountMgr.ACCESS_KEY, AccountMgr.SECRET_KEY);
	UploadManager uploadManager = new UploadManager();
	
	/**
	 * 获得凭证
	 */
	public String getUpToken(String bucketName){
		return auth.uploadToken(bucketName);
	}
	
	/**
	 * 上传
	 * @param filePath 文件路径
	 * @param key	文件唯一名称
	 * @param bucketName 空间名称
	 */
	public void upload(String filePath, String key, String bucketName){
		try {
			//使用put方法上传
			Response res = uploadManager.put(filePath, key, getUpToken(bucketName));
			//打印返回信息
			System.out.println(res.bodyString());
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	

	/**
	 * 测试上传功能
	 */
	public static void main(String[] args) {
		String filePath = "";
		String key = "";
		String bucketName = "";
		new SimpleUpload().upload(filePath, key, bucketName);
			
	}

}
