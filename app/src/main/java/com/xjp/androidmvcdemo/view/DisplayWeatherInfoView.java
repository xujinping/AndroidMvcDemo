package com.xjp.androidmvcdemo.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xjp.androidmvcdemo.R;
import com.xjp.androidmvcdemo.entity.Weather;
import com.xjp.androidmvcdemo.entity.WeatherInfo;

/**
 * Description:将天气信息显示到View
 * User: xjp
 * Date: 2015/6/3
 * Time: 14:55
 */

public class DisplayWeatherInfoView {

    private ActionBarActivity activity;
    RequestWeatherView iRequest;

    private Dialog loadingDialog;
    private EditText cityNOInput;
    private TextView city;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private TextView wse;
    private TextView time;
    private TextView njd;

    public DisplayWeatherInfoView(ActionBarActivity activity, RequestWeatherView iRequest) {
        this.activity = activity;
        this.iRequest = iRequest;
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        cityNOInput = (EditText) activity.findViewById(R.id.et_city_no);
        city = (TextView) activity.findViewById(R.id.tv_city);
        cityNO = (TextView) activity.findViewById(R.id.tv_city_no);
        temp = (TextView) activity.findViewById(R.id.tv_temp);
        wd = (TextView) activity.findViewById(R.id.tv_WD);
        ws = (TextView) activity.findViewById(R.id.tv_WS);
        sd = (TextView) activity.findViewById(R.id.tv_SD);
        wse = (TextView) activity.findViewById(R.id.tv_WSE);
        time = (TextView) activity.findViewById(R.id.tv_time);
        njd = (TextView) activity.findViewById(R.id.tv_njd);

        loadingDialog = new ProgressDialog(activity);
        loadingDialog.setTitle("加载天气中...");

        activity.findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.show();
                iRequest.sendRequest(cityNOInput.getText().toString().trim());
            }
        });

    }

    /**
     * 显示结果
     *
     * @param weather
     */
    public void displayResult(Weather weather) {
        WeatherInfo weatherInfo = weather.getWeatherinfo();
        city.setText(weatherInfo.getCity());
        cityNO.setText(weatherInfo.getCityid());
        temp.setText(weatherInfo.getTemp());
        wd.setText(weatherInfo.getWD());
        ws.setText(weatherInfo.getWS());
        sd.setText(weatherInfo.getSD());
        wse.setText(weatherInfo.getWSE());
        time.setText(weatherInfo.getTime());
        njd.setText(weatherInfo.getNjd());
    }

    /**
     * 隐藏进度对话框
     */
    public void hideLoadingDialog() {
        loadingDialog.dismiss();
    }


}
