package com.android.lixiang.search.service.impl

import com.android.lixiang.search.presenter.data.bean.GetPoiBean
import com.android.lixiang.search.presenter.data.repository.SearchRepository
import com.android.lixiang.search.service.SearchService
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject
import io.reactivex.functions.Function

class SearchServiceImpl @Inject constructor() : SearchService {
    @Inject
    lateinit var searchRepository: SearchRepository

    override fun getPoi(s1: String, s2: String): Observable<GetPoiBean> {
        return searchRepository.getPoi(s1, s2).flatMap(Function<GetPoiBean, ObservableSource<GetPoiBean>> { t ->
            return@Function Observable.just(t)
        })
    }
}