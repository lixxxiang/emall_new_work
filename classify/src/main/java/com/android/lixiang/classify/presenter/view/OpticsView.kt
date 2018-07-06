package com.android.lixiang.classify.presenter.view

import com.android.lixiang.base.presenter.view.BaseView
import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean

interface OpticsView: BaseView {
    fun onSceneSearchResult(res: SceneSearchBean)
}