package com.android.lixiang.homepage.presenter.data.api

import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import io.reactivex.Observable
import retrofit2.http.*

interface HomeApi {
    @Headers("Content-Type:text/html;charset=utf-8", "Accept:application/json;")
    @GET("global/mobile/homePageUnits")
    fun homePageUnits(): Observable<HomePageUnitsBean>

    @Headers("Content-Type:text/html;charset=utf-8", "Accept:application/json;")
    @GET("global/mobile/homePageSlide")
    fun homePageSlide(): Observable<HomePageSlideBean>

    @POST("mobile/homePage")
    @FormUrlEncoded
    fun homePage(@Field("pageSize") targetSentence: String,
                             @Field("pageNum") targetSentence2: String): Observable<HomePageBean>
}