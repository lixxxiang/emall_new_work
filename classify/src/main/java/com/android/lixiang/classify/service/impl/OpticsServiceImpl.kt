package com.android.lixiang.classify.service.impl

import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean
import com.android.lixiang.classify.presenter.data.repository.OpticsRepository
import com.android.lixiang.classify.service.OpticsService
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject
import io.reactivex.functions.Function

class OpticsServiceImpl @Inject constructor() : OpticsService {

    @Inject
    lateinit var opticsRepository: OpticsRepository
    override fun sceneSearch(param_scopeGeo: String, param_productType: String, param_resolution: String,
                             param_satelliteId: String, param_startTime: String, param_endTime: String,
                             param_cloud: String, param_type: String, param_pageSize: String,
                             param_pageNum: String, param_orderBy: String, param_client: String): Observable<SceneSearchBean> {
        return opticsRepository.sceneSearch(
                param_scopeGeo, param_productType, param_resolution,
                param_satelliteId, param_startTime, param_endTime,
                param_cloud, param_type, param_pageSize,
                param_pageNum, param_orderBy, param_client).flatMap(Function<SceneSearchBean, ObservableSource<SceneSearchBean>> { t ->
            return@Function Observable.just(t)
        })
    }

}