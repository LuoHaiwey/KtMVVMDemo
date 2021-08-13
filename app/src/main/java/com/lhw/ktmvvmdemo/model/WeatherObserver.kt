package com.lhw.ktmvvmdemo.model

import androidx.databinding.ObservableField

/**
 * ****************************************************************
 * 文件名称 : com.lhw.ktmvvmdemo.model.WeatherObserver
 * 作    者 : lhw
 * 创建时间 : 2021/08/13 17:00
 * 文件描述 : java类作用描述
 * 版权声明 : Copyright (C) 2015-2018 杭州中焯信息技术股份有限公司
 * 修改历史 : 2021/08/13  1.00 初始版本
 * ****************************************************************
 */
data class WeatherObserver(
    var city: ObservableField<String> = ObservableField<String>("--"),
    var cityid: ObservableField<String> = ObservableField<String>("--"),
    var temp1: ObservableField<String> = ObservableField<String>("--"),
    var temp2: ObservableField<String> = ObservableField<String>("--"),
    var weather: ObservableField<String> = ObservableField<String>("--"),
    var img1: ObservableField<String> = ObservableField<String>("--"),
    var img2: ObservableField<String> = ObservableField<String>("--"),
    var ptime: ObservableField<String> = ObservableField<String>("--"),
) {
}
