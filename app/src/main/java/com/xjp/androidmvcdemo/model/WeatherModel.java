package com.xjp.androidmvcdemo.model;

/**
 * Description:请求网络数据接口
 * User: xjp
 * Date: 2015/6/3
 * Time: 15:40
 */

public interface WeatherModel {
    void getWeather(String cityNumber, OnWeatherListener listener);
}
