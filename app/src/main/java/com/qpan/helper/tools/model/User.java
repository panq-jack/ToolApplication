package com.qpan.helper.tools.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by panqian on 2016/8/4.
 */
public class User extends BmobUser {
    private static final long serialVersionUID = 1L;
    public String userDesc;
    public String lastLoginTime;
    public long loginCount;     //登录次数
    public long loginDays;    //登录天数
}
