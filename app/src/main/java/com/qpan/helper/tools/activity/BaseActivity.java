package com.qpan.helper.tools.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by panqian on 2016/8/4.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void showSnackBar(String msg){
        Snackbar.make(getCurrentFocus(),msg,Snackbar.LENGTH_SHORT).show();
    }
    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    protected void printLog(String log){
        Log.d(getClass().getSimpleName(),log);
    }
}
