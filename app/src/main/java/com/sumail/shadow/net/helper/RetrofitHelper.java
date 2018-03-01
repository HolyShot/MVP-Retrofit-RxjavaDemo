package com.sumail.shadow.net.helper;


import com.sumail.shadow.net.Urls;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *
 * Retrofit帮助类
 */

public class RetrofitHelper {

    private final OkHttpClient mClient;
    private Retrofit mRetrofit;

    private RetrofitHelper(){

        mClient = OkHttpClientHelper.getInstance().getOkHttpClient();
    }


    private static RetrofitHelper helper;

    //单例 保证对象唯一
    public static RetrofitHelper getInstance(){
        if(helper==null){
            synchronized (RetrofitHelper.class){
                if(helper==null){
                    helper = new RetrofitHelper();
                }
            }
        }
        return helper;
    }

    //获取Retrofit对象
    public Retrofit getRetrofit(){

        if(mRetrofit==null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Urls.SER_TAG)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())  //添加Gson支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  //添加RxJava支持
                    .client(mClient)                                            //关联okhttp
                    .build();
        }
        return mRetrofit;
    }

    //获取服务对象
    public  <T> T getService(Class<T> classz){

        return RetrofitHelper.getInstance()
                .getRetrofit()
                .create(classz);
    }
}
