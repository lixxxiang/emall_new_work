package com.android.lixiang.search.presenter

import com.android.lixiang.base.ext.execute
import com.android.lixiang.base.presenter.BasePresenter
import com.android.lixiang.base.rx.BaseObserver
import com.android.lixiang.search.presenter.data.bean.GetPoiBean
import com.android.lixiang.search.presenter.view.SearchView
import com.android.lixiang.search.service.SearchService
import javax.inject.Inject

class SearchPresenter @Inject constructor() : BasePresenter<SearchView>() {
    @Inject
    lateinit var mSearchService: SearchService

    fun getPoi(s1: String, s2: String) {
        mSearchService.getPoi(s1, s2).execute(object : BaseObserver<GetPoiBean>() {
            override fun onNext(t: GetPoiBean) {
                super.onNext(t)
                mView.onGetPoiResult(t)
            }
        }, lifecycleProvider)
    }
}