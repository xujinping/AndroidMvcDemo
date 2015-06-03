package com.xjp.androidmvcdemo.controller;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.xjp.androidmvcdemo.R;
import com.xjp.androidmvcdemo.model.OnWeatherListener;
import com.xjp.androidmvcdemo.entity.Weather;
import com.xjp.androidmvcdemo.model.WeatherModel;
import com.xjp.androidmvcdemo.model.WeatherModelImpl;
import com.xjp.androidmvcdemo.view.DisplayWeatherInfoView;
import com.xjp.androidmvcdemo.view.RequestWeatherView;


public class MainActivity extends ActionBarActivity implements RequestWeatherView, OnWeatherListener {

    private DisplayWeatherInfoView displayView;
    private static WeatherModel weatherModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayView = new DisplayWeatherInfoView(this, this);
        if (null == weatherModel) {
            weatherModel = new WeatherModelImpl();
        }
    }

    @Override
    public void sendRequest(String number) {
        weatherModel.getWeather(number, this);
    }

    @Override
    public void onSuccess(Weather weather) {
        displayView.hideLoadingDialog();
        displayView.displayResult(weather);
    }

    @Override
    public void onError() {
        displayView.hideLoadingDialog();
        Toast.makeText(this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
    }
}
