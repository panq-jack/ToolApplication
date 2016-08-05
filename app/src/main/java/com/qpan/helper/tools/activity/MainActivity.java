package com.qpan.helper.tools.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.fragmentnavigator.FragmentNavigator;
import com.qpan.helper.tools.R;
import com.qpan.helper.tools.adapter.MainFragmentAdapter;
import com.qpan.helper.tools.fragment.BaseToolbarFragment;
import com.qpan.helper.tools.util.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,BaseToolbarFragment.ToggleDrawerCallBack ,
        View.OnClickListener{
    private static final int DEFAULT_POSITION = 0;

    /**
     * https://github.com/Aspsine/FragmentNavigator
     */
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawer;
    @InjectView(R.id.nav_view)
    NavigationView navigationView;
    ImageView userPortrait;
    TextView userName;
    TextView userDesc;
    Handler handler=new Handler();
//    @InjectView(R.id.user_portrait)
//
//    @InjectView(R.id.user_name)
//    TextView userName;
//    @InjectView(R.id.user_desc)
//    TextView userDesc;

    private FragmentNavigator mFragmentNavigator;
    private long lastBackClickTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        View header=null;
        if (navigationView.getHeaderCount()>0){
             header=navigationView.getHeaderView(0);
            header.setOnClickListener(this);
        }
//        View NavHeaderMain= LayoutInflater.from(this).inflate(R.layout.nav_header_main,null);
        userPortrait=ButterKnife.findById(header,R.id.user_portrait);
        userName=ButterKnife.findById(header,R.id.user_name);
        userDesc=ButterKnife.findById(header,R.id.user_desc);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
        mFragmentNavigator=new FragmentNavigator(getSupportFragmentManager(),new MainFragmentAdapter(),R.id.container);
        mFragmentNavigator.setDefaultPosition(DEFAULT_POSITION);
        mFragmentNavigator.onCreate(savedInstanceState);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //设置初始选中状态
        navigationView.setCheckedItem(Constant.FRAGMENTS_IDS.get(DEFAULT_POSITION));
        navigationView.setNavigationItemSelectedListener(this);
        userPortrait.setOnClickListener(this);
        userName.setOnClickListener(this);
        mFragmentNavigator.showFragment(mFragmentNavigator.getCurrentPosition());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mFragmentNavigator.onSaveInstanceState(outState);
    }

    @Override
    public void openDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            doubleClickToExit();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        drawer.closeDrawer(GravityCompat.START);
        drawer.postDelayed(new Runnable() {
            @Override
            public void run() {
                int id = item.getItemId();
                //两种方式：  打开fragment还是activity
                if (id==R.id.nav_about){
                    startActivity(new Intent(MainActivity.this,AboutActivity.class));
                }else if (id==R.id.nav_logininfo){

                }
                else {
                    mFragmentNavigator.showFragment(Constant.FRAGMENTS_IDS.indexOf(id));
                }
            }
        },200);
        return true;
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.user_portrait:
            case R.id.user_name:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawer.closeDrawer(GravityCompat.START);
                    }
                },500);
               break;
        }
    }

    private void doubleClickToExit(){
        long time=System.currentTimeMillis();
        if (time-lastBackClickTime>2*1000){
            showSnackBar("再次点击以退出");
            lastBackClickTime=time;
        }else {
            super.onBackPressed();
        }
    }
}
