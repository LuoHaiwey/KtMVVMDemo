package com.lhw.ktmvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lhw.ktmvvmdemo.R
import com.lhw.ktmvvmdemo.databinding.ActivityMainBinding
import com.lhw.ktmvvmdemo.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        dataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.activity = this
        dataBinding.viewModel = WeatherViewModel()
    }

    fun getWetherData() {
        //调用viewmodel层获取数据
        dataBinding.viewModel?.queryWeather()
    }
}