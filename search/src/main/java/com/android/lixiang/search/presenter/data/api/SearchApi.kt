package com.android.lixiang.search.presenter.data.api

import com.android.lixiang.search.presenter.data.bean.GetPoiBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchApi {
    @Headers("Content-Type:text/html;charset=utf-8", "Accept:application/json;")
    @GET("GetPoiByGaode.do")
    fun getPoiByGaode(@Query("poiName") targetSentence: String,
                      @Query("cityName") targetSentence2: String): Observable<GetPoiBean>
}