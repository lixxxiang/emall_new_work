package com.android.lixiang.classify.presenter.data.repository

import com.android.lixiang.base.common.BaseConstant
import com.android.lixiang.base.data.net.RetrofitFactory
import com.android.lixiang.classify.presenter.data.api.ClassifyApi
import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean
import io.reactivex.Observable
import javax.inject.Inject

class OpticsRepository @Inject constructor() {
    fun sceneSearch(param_scopeGeo: String, param_productType: String, param_resolution: String,
                    param_satelliteId: String, param_startTime: String, param_endTime: String,
                    param_cloud: String, param_type: String, param_pageSize: String,
                    param_pageNum: String, param_orderBy: String, param_client: String)
            : Observable<SceneSearchBean> {
        return RetrofitFactory(BaseConstant.SERVER_ADDRESS_8024)
                .create(ClassifyApi::class.java)
                .sceneSearch(param_scopeGeo, param_productType, param_resolution,
                        param_satelliteId, param_startTime, param_endTime,
                        param_cloud, param_type, param_pageSize,
                        param_pageNum, param_orderBy, param_client)
    }
}