package com.qiniu.code;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.processing.OperationStatus;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.*;

import java.net.URLEncoder;
import java.util.Base64;

/**
 * @ClassName TokenService
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/25
 * @Version 1.0
 **/
public class TokenService {

    private static String accessKey = "*";
    private static String secretKey = "*";
    private static String bucket = "tezign";
    private static String url = "https://static.tezign.com/1111111.jpg";

    private static String key = "1111111aaa.jpg";

    public static void main(String[] args) throws Exception {

//
//        Base64.Decoder decoder = Base64.getDecoder();
//
//        String s1 = new String(decoder.decode("YnVja2V0OjExMTExMTFfeDEyMzQ1My5qcGc=".getBytes()), "UTF-8");
//        System.out.println(s1);

//        String s = "alfjadxxxxxaaa_x123453.jpg";
//        int slim = s.lastIndexOf("x") + 1;
//        int i = s.lastIndexOf(".");
//        System.out.println(s.substring(slim,i));
//        ListAllImageInfo();
//        imageslime();
        getPrivateImageUrl();
//        getUrl();
    }


    /**
     * 对已有资源进行压缩存储
     **/
    public static void imageslime() {
        String s = "5cb0a0dcdcf4ddbc85a195c376fe7e28_x734919.png";
        StringMap stringMap = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);

//数据处理指令，支持多个指令
        String saveJpgEntry = String.format("%s:%s", bucket, s);
        String vframeJpgFop = String.format("imageslim|saveas/%s", UrlSafeBase64.encodeToString(saveJpgEntry));
//将多个数据处理指令拼接起来
        String persistentOpfs = StringUtils.join(new String[]{
                vframeJpgFop
        }, ";");


        //数据处理队列名称，必须
        String persistentPipeline = "tezign_zip";
//数据处理完成结果通知地址
        String persistentNotifyUrl = "http://39.107.204.67:31400/resource/slim/public/notify";

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释

//构建持久化数据处理对象
        OperationManager operationManager = new OperationManager(auth, cfg);
        try {
            stringMap.put("pipeline", persistentPipeline);
//            stringMap.put("callbackUrl", persistentNotifyUrl);
//            stringMap.put("callbackHost", "http://39.107.204.67:31400");
//            stringMap.put("callbackBodyType", "application/json");
            stringMap.put("notifyURL", persistentNotifyUrl);

//            stringMap.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize),\"ext\":$(ext)}");
            String persistentId = operationManager.pfop(bucket, "5cb0a0dcdcf4ddbc85a195c376fe7e28.png", persistentOpfs, stringMap);
            //可以根据该 persistentId 查询任务处理进度
            System.out.println(persistentId);

            OperationStatus operationStatus = operationManager.prefop(persistentId);

//            OperationStatus operationStatus = operationManager.prefop(persistentId);
            //解析 operationStatus 的结果
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
        }
    }



    /**
     * @param name:
     * @Author ouyangkang
     * @Description 数据过滤
     * @Date 2020/8/27
     * @return: java.lang.String
     **/
    public static String imageslimName(String name) {

        String lowerCase = name.toLowerCase();
        if (lowerCase.contains(".jpg")) {
            return name.substring(0, name.length() - 4) + "_slim" + ".jpg";
        }
        return null;
    }

    /**
     * 获取某个空间所有的数据基础信息
     **/
    public static void ListAllImageInfo() {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
//文件名前缀
        String prefix = "";
//每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
//列举空间文件列表
        Long count = 0L;
        Long log = 0L;
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                System.out.println(log++);
                if (isImage(item.mimeType) && item.fsize > 20 * 1024 * 1024) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isImage(String type) {
        if (!StringUtils.isNullOrEmpty(type)) {
            String lowerCase = type.toLowerCase();
            if (lowerCase.contains("jpg")
                    || lowerCase.contains("jpeg")
                    || lowerCase.contains("png")
                    || lowerCase.contains("gif")
                    || lowerCase.contains("webp")
                    || lowerCase.contains("tif")
                    || lowerCase.contains("bmp")
            ){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取私有图片信息
     **/
    private static void getPrivateImageUrl() throws Exception {
//        String fileName = "a86e83f335546d63011735ee347fbdd9.jpg";
        String fileName = "300716c10f30e4b4bb2c64be6e236bdd_x622390.png";
        String domainOfBucket = "https://file.tezign.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        publicUrl = publicUrl + "?imageView2/2/w/1264/interlace/0/ignore-error/1";
//        publicUrl = publicUrl + "?imageInfo";
//        publicUrl = publicUrl + "?imageInfo";
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600 * 24 * 31;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
    }

    private static void customUpload() {


        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
        //数据处理指令，支持多个指令
        String saveJpgEntry = String.format("%s:123_imageslim.png", bucket);
        String vframeJpgFop = String.format("imageslim|saveas/%s", UrlSafeBase64.encodeToString(saveJpgEntry));
//将多个数据处理指令拼接起来
        String persistentOpfs = StringUtils.join(new String[]{vframeJpgFop}, ";");
        putPolicy.put("persistentOps", persistentOpfs);
//数据处理队列名称，必填
        putPolicy.put("persistentPipeline", "tezign_zip");
//数据处理完成结果通知地址
//        putPolicy.put("persistentNotifyUrl", "http://api.example.com/qiniu/pfop/notify");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);

        System.out.println(upToken);


        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String localFilePath = "/Users/ouyangkang/Downloads/123.png";

        try {
            Response put = uploadManager.put(localFilePath, "123.png", upToken);
            System.out.println(put.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }


    public static void getUrl(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            FileInfo fileInfo = bucketManager.stat(bucket, key);
            System.out.println(fileInfo.hash);
            System.out.println(fileInfo.fsize);
            System.out.println(fileInfo.mimeType);
            System.out.println(fileInfo.putTime);
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
        }
    }


}
