package com.qpan.helper.tools.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.qpan.helper.tools.R;
import com.qpan.helper.tools.model.User;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * Created by panqian on 2016/8/4.
 */
public class LoginActivity extends BaseActivity {
    @InjectView(R.id.et_account)
    EditText et_account;
    @InjectView(R.id.et_password)
    EditText et_password;

    @OnClick(R.id.btn_login)
    public void login(View view) {
        login();
    }
    @OnClick({R.id.tv_left,R.id.iv_left})
    public void back(View view){
        super.onBackPressed();
    }
    Handler handler=new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
    }
    /** 登陆操作
     * @method login
     * @return void
     * @exception
     */
    private void login(){
        String account = et_account.getText().toString();
        String password = et_password.getText().toString();
        if (TextUtils.isEmpty(account)) {
            showToast("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空");
            return;
        }
        final ProgressDialog progress = new ProgressDialog(LoginActivity.this);
        progress.setMessage("正在登录中...");
        progress.setCanceledOnTouchOutside(false);
        progress.show();
        //V3.3.9提供的新的登录方式，可传用户名/邮箱/手机号码
        BmobUser.loginByAccount(this, account, password, new LogInListener<User>() {

            @Override
            public void done(User user, BmobException ex) {
                // TODO Auto-generated method stub
                progress.dismiss();
                if(ex==null){
                    showToast("登录成功，登录名为："+user.getUsername());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onBackPressed();
                        }
                    },2000);
                }else{
                    showToast("登录失败! ex="+ex);
                    et_password.setText("");
                }
            }
        });
    }


}
