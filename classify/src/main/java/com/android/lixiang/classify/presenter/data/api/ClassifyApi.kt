package com.android.lixiang.classify.presenter.data.api

import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface ClassifyApi {
    @POST("/global/mobile/sceneSearch?client=android")
    @FormUrlEncoded
    fun sceneSearch(@Field("scopeGeo") targetSentence: String,
                             @Field("productType") targetSentence2: String,
                             @Field("resolution") targetSentenc3: String,
                             @Field("satelliteId") targetSentence4: String,
                             @Field("startTime") targetSentence5: String,
                             @Field("endTime") targetSentence6: String,
                             @Field("cloud") targetSentenc7: String,
                             @Field("type") targetSentence8: String,
                             @Field("pageSize") targetSentence9: String,
                             @Field("pageNum") targetSentence10: String,
                             @Field("orderBy") targetSentence11: String,
                             @Field("client") targetSentence12: String): Observable<SceneSearchBean>

}