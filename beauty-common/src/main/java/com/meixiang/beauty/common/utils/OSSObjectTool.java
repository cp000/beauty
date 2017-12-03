package com.meixiang.beauty.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.meixiang.beauty.common.config.Global;

/**
 * oss 工具类
 * @author ft
 *
 */
public class OSSObjectTool {
    private static  OSSClient ossClient = null;
    public static String BUCKET_DOCTOR_PIC = null;
    public static String BUCKET_ARTICLE_PIC = null;
    public static String BUCKET_CONSULT_PIC = null;
    static {
        String accesskey = Global.getConfig("aliyun.accesskey");
        String secret =  Global.getConfig("aliyun.secret");
        String host =  Global.getConfig("oss.host");
        BUCKET_DOCTOR_PIC = Global.getConfig("oss.bucket.doctor.pic");
        BUCKET_ARTICLE_PIC = Global.getConfig("oss.bucket.article.pic");
        BUCKET_CONSULT_PIC = Global.getConfig("oss.bucket.consult.pic");
        ossClient = new  OSSClient(host,accesskey, secret);
    }

    /**
     * 上传文件到oss
     * @param key
     * @param length
     * @param in
     * @param bucket
     * @return key
     * @throws OSSException
     * @throws ClientException
     * @throws FileNotFoundException
     */
    public static String uploadFileInputStream(String key, Long length ,InputStream in, String bucket) {
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(length);
        new HashMap<String,String>();
        ossClient.putObject(bucket, key , in, objectMeta);
        return key;
    }



    /**
     * 将文件上传至
     * @param file
     * @param key 上传至 OSS 后的文件名
     */
    public static void upLoadFileToOSS(File file,String key,String... bucketName){
        try {
            InputStream  inputStream = new FileInputStream(file);
            if(bucketName.length<1){
                ossClient.putObject("yhllaoyou", key, inputStream);
            }else{
                ossClient.putObject(bucketName[0], key, inputStream);
            }
            // 关闭client
        ossClient.shutdown();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
