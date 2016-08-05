package com.qpan.helper.tools.activity;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.qpan.helper.tools.BuildConfig;

import cn.bmob.v3.Bmob;

/**
 * Created by panqian on 2016/8/3.
 */
public class BaseApplication extends Application {
    protected static Context sContext;
    private static RequestQueue sRequestQueue;

    private static final String BMOB_APP_KEY="";

    @Override
    public void onCreate() {
        super.onCreate();
        setStrictMode();
        sContext = this;
        Bmob.initialize(this,BMOB_APP_KEY);
    }
    private void setStrictMode() {
        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.enableDefaults();
        }
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public Context getApplicationContext(){
        return sContext;
    }
    public static RequestQueue getsRequestQueue(){
        if (null==sRequestQueue){
            sRequestQueue= Volley.newRequestQueue(sContext);
        }
        return sRequestQueue;
    }
}
