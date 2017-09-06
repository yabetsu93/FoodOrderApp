package com.jabespauya.foodorderapp.UserHelper;

/**
 * Created by jabespauya on 9/5/2017 AD.
 */

public class User {
    private String mName;
    private String mPhoneNo;
    private String mPassword;

    public User() {
    }

    public User(String name, String password) {
        mName = name;
        mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhoneNo() {
        return mPhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        mPhoneNo = phoneNo;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
