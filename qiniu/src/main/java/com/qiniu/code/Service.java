package com.qiniu.code;

import com.qiniu.common.Zone;
import com.qiniu.processing.OperationManager;
import com.qiniu.processing.OperationStatus;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

/**
 * @ClassName Service
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/8/27
 * @Version 1.0
 **/
public class Service {

    private static String accessKey = "*";
    private static String secretKey = "*";

    public static void main(String[] args) throws Exception {
        Auth auth = Auth.create(accessKey, secretKey);
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        OperationManager operationManager = new OperationManager(auth, cfg);

        OperationStatus operationStatus = operationManager.prefop("z0.01z002c57n0v8dzil500mttkgj0001xf");
        int code = operationStatus.code;
        System.out.println(code);
//        TokenService.imageslime();

    }
}
