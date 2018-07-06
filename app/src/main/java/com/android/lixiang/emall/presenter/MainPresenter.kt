package com.android.lixiang.emall.presenter

import com.android.lixiang.base.presenter.BasePresenter
import com.android.lixiang.emall.presenter.view.MainView
import com.android.lixiang.emall.service.MainService
import com.android.lixiang.emall.service.impl.MainServiceImpl
import com.orhanobut.logger.Logger
//import com.android.lixiang.emall.service.MainService
import javax.inject.Inject

class MainPresenter @Inject constructor():BasePresenter<MainView>(){

    @Inject
    lateinit var mMainService : MainService
    fun testPresenter(){
    }

    fun testPresenterWithService(){
        println("in")
        mMainService.testService()
//        mView.test()
    }
}