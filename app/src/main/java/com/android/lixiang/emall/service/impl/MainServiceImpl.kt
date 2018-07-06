package com.android.lixiang.emall.service.impl

import com.android.lixiang.emall.service.MainService
import javax.inject.Inject

class MainServiceImpl @Inject constructor(): MainService{
    override fun testService2() {
        println("testService2")
    }

    override fun testService() {
        println("testService")
    }
}