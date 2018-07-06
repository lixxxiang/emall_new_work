package com.android.lixiang.homepage.service.impl

import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.data.repository.HomeRepository
import com.android.lixiang.homepage.service.HomeService
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject
import io.reactivex.functions.Function

class HomeServiceImpl @Inject constructor(): HomeService {
    override fun homePage(string1: String, string2: String): Observable<HomePageBean> {
        return homeRepository.homePage(string1, string2).flatMap(Function<HomePageBean, ObservableSource<HomePageBean>> { t ->
            return@Function Observable.just(t)
        })
    }

    override fun homePageSlide(): Observable<HomePageSlideBean> {
        return homeRepository.homePageSlide().flatMap(Function<HomePageSlideBean, ObservableSource<HomePageSlideBean>> { t ->
            return@Function Observable.just(t)
        })
    }
    @Inject
    lateinit var homeRepository: HomeRepository

    override fun homePageUnits(): Observable<HomePageUnitsBean> {
        return homeRepository.homePageUnits().flatMap(Function<HomePageUnitsBean, ObservableSource<HomePageUnitsBean>> { t ->
            return@Function Observable.just(t)
        })
    }
}