package com.android.lixiang.classify.presenter

import com.android.lixiang.base.ext.execute
import com.android.lixiang.base.presenter.BasePresenter
import com.android.lixiang.base.presenter.view.BaseView
import com.android.lixiang.base.rx.BaseObserver
import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean
import com.android.lixiang.classify.presenter.view.OpticsView
import com.android.lixiang.classify.service.OpticsService
import javax.inject.Inject

class OpticsPresenter @Inject constructor() : BasePresenter<OpticsView>() {
    @Inject
    lateinit var mOpticsService: OpticsService

    fun sceneSearch(param_scopeGeo: String, param_productType: String, param_resolution: String,
                    param_satelliteId: String, param_startTime: String, param_endTime: String,
                    param_cloud: String, param_type: String, param_pageSize: String,
                    param_pageNum: String, param_orderBy: String, param_client: String){
        mOpticsService.sceneSearch(param_scopeGeo, param_productType, param_resolution,
                param_satelliteId, param_startTime, param_endTime,
                param_cloud, param_type, param_pageSize,
                param_pageNum, param_orderBy, param_client).execute(object : BaseObserver<SceneSearchBean>() {
            override fun onNext(t: SceneSearchBean) {
                super.onNext(t)
                mView.onSceneSearchResult(t)
            }
        }, lifecycleProvider)
    }
}