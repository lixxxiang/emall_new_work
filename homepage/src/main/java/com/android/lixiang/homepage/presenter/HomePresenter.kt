package com.android.lixiang.homepage.presenter

import com.android.lixiang.base.ext.execute
import com.android.lixiang.base.presenter.BasePresenter
import com.android.lixiang.base.rx.BaseObserver
import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.view.HomeView
import com.android.lixiang.homepage.service.HomeService
import javax.inject.Inject

class HomePresenter @Inject constructor() : BasePresenter<HomeView>() {

    @Inject
    lateinit var mHomeService: HomeService


    fun homePageUnits() {
        mHomeService.homePageUnits().execute(object : BaseObserver<HomePageUnitsBean>() {
            override fun onNext(t: HomePageUnitsBean) {
                super.onNext(t)
                mView.onHomePageUnitsResult(t)
            }
        }, lifecycleProvider)

    }

    fun homePageSlide() {
        mHomeService.homePageSlide().execute(object : BaseObserver<HomePageSlideBean>() {
            override fun onNext(t: HomePageSlideBean) {
                super.onNext(t)
                mView.onHomePageSlideResult(t)
            }
        }, lifecycleProvider)
    }

    fun homePage(string1: String, string2: String) {
        mHomeService.homePage(string1, string2).execute(object : BaseObserver<HomePageBean>() {
            override fun onNext(t: HomePageBean) {
                super.onNext(t)
                mView.onHomePageResult(t)
            }
        }, lifecycleProvider)
    }
}