package com.lhw.ktmvvmdemo.http

import com.lhw.ktmvvmdemo.request.WeatherService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * ****************************************************************
 * 文件名称 : com.lhw.ktretrofitdemo.ApiClient
 * 作    者 : lhw
 * 创建时间 : 2021/08/12 14:39
 * 文件描述 : java类作用描述
 * 版权声明 : Copyright (C) 2015-2018 杭州中焯信息技术股份有限公司
 * 修改历史 : 2021/08/12  1.00 初始版本
 * ****************************************************************
 */
object RetrofitServer {

    private const val baseUrl = "http://www.weather.com.cn/"
    private const val defoutTimeout: Long = 30

    private val client = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .connectTimeout(defoutTimeout, TimeUnit.SECONDS)
        .readTimeout(defoutTimeout, TimeUnit.SECONDS)
        .build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serverClass: Class<T>): T =
        retrofit.create(serverClass)

}