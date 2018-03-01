package com.sumail.shadow.net.helper;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 *
 * Okhttp帮助类
 */

public class OkHttpClientHelper {

    private OkHttpClient mClient;
    private final  static  long TIMEOUT = 10000;  //超时时间


    private static OkHttpClientHelper clientHelper;

    public static OkHttpClientHelper getInstance(){
        if(clientHelper==null){
            synchronized (OkHttpClientHelper.class){
                if(clientHelper==null){
                    clientHelper = new OkHttpClientHelper();
                }
            }
        }
        return clientHelper;
    }


    //获取OKHttpClicent对象
    public OkHttpClient getOkHttpClient(){

        if(mClient ==null) {
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .build();
        }
        return mClient;
    }
}
