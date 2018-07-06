package com.android.lixiang.classify.service

import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean
import io.reactivex.Observable

interface OpticsService {
    fun sceneSearch(param_scopeGeo: String, param_productType: String, param_resolution: String,
                    param_satelliteId: String, param_startTime: String, param_endTime: String,
                    param_cloud: String, param_type: String, param_pageSize: String,
                    param_pageNum: String, param_orderBy: String, param_client: String)
            : Observable<SceneSearchBean>
}