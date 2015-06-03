package com.xjp.androidmvcdemo.application;

import android.app.Application;

import com.xjp.androidmvcdemo.volley.VolleyRequest;

/**
 * Description:
 * User: xjp
 * Date: 2015/6/3
 * Time: 15:52
 */

public class MvcApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
