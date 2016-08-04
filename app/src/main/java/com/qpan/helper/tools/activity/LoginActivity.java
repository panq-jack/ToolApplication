package com.qpan.helper.tools.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qpan.helper.tools.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by panqian on 2016/8/4.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    ImageView iv_left;
    TextView tv_back;
    @InjectView(R.id.et_account)
    EditText et_account;
    @InjectView(R.id.et_password)
    EditText et_password;
    @InjectView(R.id.btn_login)
    Button btn_login;

    @OnClick(R.id.btn_login)
    public void login(View view) {
        login();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        tv_back = (TextView) findViewById(R.id.tv_left);
        iv_left.setOnClickListener(this);
        tv_back.setOnClickListener(this);

    }

    private void login() {
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


        progress.dismiss();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.iv_left:
            case R.id.tv_left:
                super.onBackPressed();
                break;

            default:
                break;
        }
    }
}
