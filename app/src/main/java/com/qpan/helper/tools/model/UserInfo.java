package com.qpan.helper.tools.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by panqian on 2016/8/4.
 */
public class UserInfo implements Parcelable {
    public String userName;
    public String userDesc;
    public String userPwd;     //密码
    public String lastLoginTime;
    public long loginCount;     //登录次数
    public long loginDays;    //登录天数



    public UserInfo(){
        super();
    }
    public UserInfo(Parcel parcelIn){
        userName=parcelIn.readString();
        userDesc=parcelIn.readString();
        userPwd=parcelIn.readString();
        lastLoginTime=parcelIn.readString();
        loginCount=parcelIn.readLong();
        loginDays=parcelIn.readLong();

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcelOut, int flags) {
        parcelOut.writeString(userName);
        parcelOut.writeString(userDesc);
        parcelOut.writeString(userPwd);
        parcelOut.writeString(lastLoginTime);
        parcelOut.writeLong(loginCount);
        parcelOut.writeLong(loginDays);
    }
    public final Creator<UserInfo> CREATOR=new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
