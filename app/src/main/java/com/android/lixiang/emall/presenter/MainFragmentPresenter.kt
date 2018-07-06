package com.android.lixiang.emall.presenter

import com.android.lixiang.base.presenter.BasePresenter
import com.android.lixiang.emall.presenter.view.MainFragmentView
import com.android.lixiang.emall.presenter.view.MainView
import com.android.lixiang.emall.service.MainService
import javax.inject.Inject

class MainFragmentPresenter @Inject constructor(): BasePresenter<MainFragmentView>(){

    @Inject
    lateinit var mMainService : MainService
    fun testPresenter(){
    }

    fun testPresenterWithService(){
        mMainService.testService()
//        mView.test()
    }
}