package com.qpan.helper.tools.activity;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.qpan.helper.tools.BuildConfig;

/**
 * Created by panqian on 2016/8/3.
 */
public class BaseApplication extends Application {
    protected static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        setStrictMode();
        sContext = getApplicationContext();
    }
    private void setStrictMode() {
        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.enableDefaults();
        }
    }


    public Context getApplicationContext(){
        return sContext;
    }
}
