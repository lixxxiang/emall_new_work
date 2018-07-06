package com.android.lixiang.homepage.presenter.data.repository

import com.android.lixiang.base.common.BaseConstant.Companion.SERVER_ADDRESS_28085
import com.android.lixiang.base.common.BaseConstant.Companion.SERVER_ADDRESS_8024
import com.android.lixiang.base.data.net.RetrofitFactory
import com.android.lixiang.homepage.presenter.data.api.HomeApi
import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import io.reactivex.Observable
import javax.inject.Inject

class HomeRepository @Inject constructor(){
    fun homePageUnits(): Observable<HomePageUnitsBean> {
        return RetrofitFactory(SERVER_ADDRESS_8024).create(HomeApi::class.java).homePageUnits()
    }

    fun homePageSlide(): Observable<HomePageSlideBean>{
        return RetrofitFactory(SERVER_ADDRESS_8024).create(HomeApi::class.java).homePageSlide()
    }

    fun homePage(string1: String, string2: String): Observable<HomePageBean>{
        println(RetrofitFactory(SERVER_ADDRESS_28085).create(HomeApi::class.java).homePage(string1, string2))
        return RetrofitFactory(SERVER_ADDRESS_28085).create(HomeApi::class.java).homePage(string1, string2)
    }
}