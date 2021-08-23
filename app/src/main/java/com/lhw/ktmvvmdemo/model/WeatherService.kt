package com.lhw.ktmvvmdemo.model

import retrofit2.Call
import retrofit2.http.GET

/**
 * ****************************************************************
 * 文件名称 : com.lhw.ktretrofitdemo.IApiService
 * 作    者 : lhw
 * 创建时间 : 2021/08/12 10:42
 * 文件描述 : java类作用描述
 * 版权声明 : Copyright (C) 2015-2018 杭州中焯信息技术股份有限公司
 * 修改历史 : 2021/08/12  1.00 初始版本
 * ****************************************************************
 */
interface WeatherService {
    @GET("data/cityinfo/101210101.html")
    fun getWetherData(): Call<WeatherBean>
}