package com.android.lixiang.emall.presenter.view

import com.android.lixiang.base.presenter.view.BaseView
import com.android.lixiang.emall.presenter.data.bean.HomePageBean
import com.android.lixiang.emall.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.emall.presenter.data.bean.HomePageUnitsBean

interface HomeView: BaseView{
    fun onHomePageUnitsResult(res: HomePageUnitsBean)
    fun onHomePageSlideResult(res: HomePageSlideBean)
    fun onHomePageResult(res: HomePageBean)
}
