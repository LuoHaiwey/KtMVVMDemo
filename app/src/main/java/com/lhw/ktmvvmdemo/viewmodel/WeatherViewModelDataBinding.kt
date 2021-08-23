package com.lhw.ktmvvmdemo.viewmodel

import android.util.Log
import com.lhw.ktmvvmdemo.http.RetrofitServer
import com.lhw.ktmvvmdemo.model.WeatherBean
import com.lhw.ktmvvmdemo.model.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ****************************************************************
 * 文件名称 : com.lhw.ktmvvmdemo.viewmodel.WetherViewModel
 * 作    者 : lhw
 * 创建时间 : 2021/08/09 16:48
 * 文件描述 : viewModel类，做数据的请求和处理
 * 版权声明 : Copyright (C) 2015-2018 杭州中焯信息技术股份有限公司
 * 修改历史 : 2021/08/09  1.00 初始版本
 * ****************************************************************
 */
class WeatherViewModelDataBinding() {
    private lateinit var mCall: Call<WeatherBean>
    var weatherObservable = WeatherObserver()

    fun queryWeather() {
        mCall = RetrofitServer.create(WeatherService::class.java).getWetherData()
        mCall.enqueue(object : Callback<WeatherBean> {
            override fun onResponse(call: Call<WeatherBean>, response: Response<WeatherBean>) {
//                WeatherInfo weatherInfo = response.body().getWeatherinfo();
                val weatherBean = response.body()
                weatherObservable.city.set(weatherBean?.weatherinfo?.city)
                weatherObservable.cityid.set(weatherBean?.weatherinfo?.cityid)
                weatherObservable.temp1.set(weatherBean?.weatherinfo?.temp1)
                weatherObservable.temp2.set(weatherBean?.weatherinfo?.temp2)
                weatherObservable.img1.set(weatherBean?.weatherinfo?.img1)
                weatherObservable.img2.set(weatherBean?.weatherinfo?.img2)
                weatherObservable.ptime.set(weatherBean?.weatherinfo?.ptime)
                Log.i("onResponse==", weatherObservable.city.get().toString())

            }

            override fun onFailure(call: Call<WeatherBean>, t: Throwable) {
                Log.i("onResponse==", "failure")
            }
        })
    }
}