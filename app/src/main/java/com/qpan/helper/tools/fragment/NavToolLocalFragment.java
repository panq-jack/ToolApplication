package com.qpan.helper.tools.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by panqian on 2016/8/3.
 * 一级， 无需网络, viewpager的fragment
 */
public class NavToolLocalFragment extends BaseNavPagerFragment {
    private static final String FRAGMENT_TAG="基本功能";
    public static NavToolLocalFragment newInstance(){
        NavToolLocalFragment fragment=new NavToolLocalFragment();
        return fragment;
    }
    public NavToolLocalFragment(){

    }

    @Override
    protected String[] getTitles() {
        return new String[]{"闹钟","定时"};
    }

    @Override
    protected Fragment getFragment(int position) {
        return TestFragment.newInstance();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(FRAGMENT_TAG);
    }
}
