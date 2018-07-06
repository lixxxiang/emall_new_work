package com.android.lixiang.search.presenter.data.repository

import com.android.lixiang.base.common.BaseConstant.Companion.SERVER_ADDRESS_8023
import com.android.lixiang.base.common.BaseConstant.Companion.SERVER_ADDRESS_8024
import com.android.lixiang.base.data.net.RetrofitFactory
import com.android.lixiang.search.presenter.data.api.SearchApi
import com.android.lixiang.search.presenter.data.bean.GetPoiBean
import com.android.lixiang.search.ui.activity.SearchActivity
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepository @Inject constructor() {
    fun getPoi(s1: String, s2: String): Observable<GetPoiBean> {
        return RetrofitFactory(SERVER_ADDRESS_8023).create(SearchApi::class.java).getPoiByGaode(s1, s2)
    }
}