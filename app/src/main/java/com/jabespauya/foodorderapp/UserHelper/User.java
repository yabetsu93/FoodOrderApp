package com.jabespauya.foodorderapp.UserHelper;

/**
 * Created by jabespauya on 9/5/2017 AD.
 */

public class User {
    private String mName;
    private Integer mPhoneNo;
    private String mPassword;

    public User(String name, Integer phoneNo, String password) {
        mName = name;
        mPhoneNo = phoneNo;
        mPassword = password;
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

    public Integer getPhoneNo() {
        return mPhoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        mPhoneNo = phoneNo;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
