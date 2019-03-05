package cn.chen.oa.utils;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class QiniuUtil {
    //access_key
    private static final String ACCESS_KEY="";
    //secret_key
    private static final String SECRET_KEY="";
    //bucket
    private static final String BUCKET="";
    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //callbackurl
    private static final String CALLBACKURL = "http://omhpz0ifi.bkt.clouddn.com/";

    public static String getUpToken(){
        return auth.uploadToken(BUCKET);
    }

    //普通上传文件并返回url访问地址(文件地址)
    public static String uploadFile(String filePath) throws Exception{
        try {
            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            UUID uuid = UUID.randomUUID();
            String key = uuid.toString();
            String upToken=getUpToken();
            Response response = uploadManager.put(filePath, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return CALLBACKURL+putRet.key;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //普通上传文件并返回url访问地址(文件对象)
    public static String uploadFile(File file) throws Exception{
        try {
            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            UUID uuid = UUID.randomUUID();
            String key = uuid.toString();
            String upToken=getUpToken();
            Response response = uploadManager.put(file, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return CALLBACKURL+putRet.key;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String uploadFile(MultipartFile multipartFile) throws  Exception{
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        File excelFile = File.createTempFile(UUID.randomUUID().toString(), prefix);
        // MultipartFile to File
        multipartFile.transferTo(excelFile);
        String url=uploadFile(excelFile);
        //删除临时文件
        excelFile.delete();
        return url;
    }
}
