package com.lhw.ktmvvmdemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lhw.ktmvvmdemo.R
import com.lhw.ktmvvmdemo.databinding.ActivityMainBinding
import com.lhw.ktmvvmdemo.viewmodel.WeatherViewModelDataBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        dataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.activity = this
        dataBinding.viewModel = WeatherViewModelDataBinding()
    }

    fun getWetherData() {
        //调用viewmodel层获取数据
        dataBinding.viewModel?.queryWeather()
    }

    fun gotoSecondPage() {
        val secondIntent = Intent(this, SecondActivity::class.java)
        startActivity(secondIntent)
    }
}