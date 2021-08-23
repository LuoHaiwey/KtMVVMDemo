package com.lhw.ktmvvmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lhw.ktmvvmdemo.http.RetrofitServer
import com.lhw.ktmvvmdemo.model.WeatherBean
import com.lhw.ktmvvmdemo.model.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ****************************************************************
 * 文件名称 : com.lhw.ktmvvmdemo.viewmodel.WeatherViewModelLiveData
 * 作    者 : lhw
 * 创建时间 : 2021/08/19 21:53
 * 文件描述 : java类作用描述
 * 版权声明 : Copyright (C) 2015-2018 杭州中焯信息技术股份有限公司
 * 修改历史 : 2021/08/19  1.00 初始版本
 * ****************************************************************
 */
class WeatherViewModelLiveData : ViewModel() {
    private lateinit var mCall: Call<WeatherBean>
    private val _weatherBean = MutableLiveData<WeatherBean>()

    val weatherBean: LiveData<WeatherBean> get() = _weatherBean
    fun qurreyWeatherData() {
        mCall = RetrofitServer.create(WeatherService::class.java).getWetherData()
        mCall.enqueue(object : Callback<WeatherBean> {
            override fun onResponse(call: Call<WeatherBean>, response: Response<WeatherBean>) {
                _weatherBean.value = response.body()
                Log.i("onResponse==", _weatherBean.value.toString())
            }
            override fun onFailure(call: Call<WeatherBean>, t: Throwable) {
            }
        })
    }
}