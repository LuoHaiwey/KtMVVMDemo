package com.lhw.ktmvvmdemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lhw.ktmvvmdemo.R
import com.lhw.ktmvvmdemo.viewmodel.WeatherViewModelLiveData
import kotlinx.android.synthetic.main.activity_second.*

/**
 * 这个Activity中将使用LiveData来绑定数据
 * */
class SecondActivity : AppCompatActivity() {
    lateinit var viewModel: WeatherViewModelLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherViewModelLiveData::class.java)

        setContentView(R.layout.activity_second)

        btn_qurreyWether.setOnClickListener {
            viewModel.qurreyWeatherData()
        }

        viewModel.weatherBean.observe(this, Observer {
            tv_city.text = it.weatherinfo.city
            tv_cityId.text = it.weatherinfo.cityid
            tv_highest.text = it.weatherinfo.temp1
            tv_lowest.text = it.weatherinfo.temp1
            tv_time.text = it.weatherinfo.ptime
        })
    }
}