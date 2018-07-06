package com.android.lixiang.search.presenter.view

import com.android.lixiang.base.presenter.view.BaseView
import com.android.lixiang.search.presenter.data.bean.GetPoiBean

interface SearchView: BaseView {
    fun onGetPoiResult(res: GetPoiBean)
}