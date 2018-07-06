package com.android.lixiang.homepage.presenter.view

import com.android.lixiang.base.presenter.view.BaseView
import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean

interface HomeView: BaseView{
    fun onHomePageUnitsResult(res: HomePageUnitsBean)
    fun onHomePageSlideResult(res: HomePageSlideBean)
    fun onHomePageResult(res: HomePageBean)
}
