package com.sumail.shadow;

import android.app.Application;
import android.content.Context;

/**
 * @author Shadow
 * @date 2018.03.01.
 */

public class MyApplication extends Application {
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getContext(){
        return application;
    }

}
