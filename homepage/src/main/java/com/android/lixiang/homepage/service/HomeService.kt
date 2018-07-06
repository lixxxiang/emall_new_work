package com.android.lixiang.homepage.service

import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import io.reactivex.Observable

interface HomeService {
    fun homePageUnits(): Observable<HomePageUnitsBean>
    fun homePageSlide(): Observable<HomePageSlideBean>
    fun homePage(string1: String, string2: String): Observable<HomePageBean>
}
