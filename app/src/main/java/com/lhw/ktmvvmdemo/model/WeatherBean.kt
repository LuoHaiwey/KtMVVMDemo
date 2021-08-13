package com.lhw.ktmvvmdemo.model

/**
 * ****************************************************************
 * 文件名称 : com.lhw.ktretrofitdemo.WetherBean
 * 作    者 : lhw
 * 创建时间 : 2021/08/12 11:02
 * 文件描述 : java类作用描述
 * 版权声明 : Copyright (C) 2015-2018 杭州中焯信息技术股份有限公司
 * 修改历史 : 2021/08/12  1.00 初始版本
 * ****************************************************************
 */
data class WeatherBean(
    var weatherinfo: Weatherinfo,
)
data class Weatherinfo(
    var city: String = "--",
    var cityid: String = "--",
    var temp1: String = "--",
    var temp2: String = "--",
    var weather: String = "--",
    var img1: String = "--",
    var img2: String = "--",
    var ptime: String = "--",
)