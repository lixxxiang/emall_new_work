package com.android.lixiang.search.service

import com.android.lixiang.search.presenter.data.bean.GetPoiBean
import io.reactivex.Observable

interface SearchService {
    fun getPoi(s1: String, s2: String): Observable<GetPoiBean>
}