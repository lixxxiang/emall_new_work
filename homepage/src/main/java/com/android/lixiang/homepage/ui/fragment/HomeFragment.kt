package com.android.lixiang.homepage.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.lixiang.base.ui.fragment.BaseMvpFragment
import com.android.lixiang.homepage.R
import com.android.lixiang.homepage.presenter.HomePresenter
import com.android.lixiang.homepage.presenter.data.DataConverter2
import com.android.lixiang.homepage.presenter.data.HomeMultiItemEntity
import com.android.lixiang.homepage.presenter.data.bean.HomeEntity
import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.injection.component.DaggerHomeComponent
import com.android.lixiang.homepage.presenter.injection.module.HomeModule
import com.android.lixiang.homepage.presenter.view.HomeView
import com.android.lixiang.homepage.ui.adapter.HomeMultiAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseMvpFragment<HomePresenter>(), HomeView {
    override fun onHomePageResult(res: HomePageBean) {
        print(res.data.mixedContentList[0].contentDate)
        data.add(DataConverter2().everyDayPicConvert(res.data.mixedContentList)[0])

        mHomeRecyclerView.layoutManager = LinearLayoutManager(activity)
        mHomeRecyclerView.adapter = HomeMultiAdapter(data)
    }

    override fun onHomePageSlideResult(res: HomePageSlideBean) {
        data.add(DataConverter2().bannerConvert(res.data as MutableList<HomePageSlideBean.DataBean>)[0])
        mPresenter.homePage("10", "1")
    }

    override fun onHomePageUnitsResult(res: HomePageUnitsBean) {
        mHomePageUnitsBean = res
        data.add(DataConverter2().theThreeConvert(res.data!![1].pieces!!)[0])
        //ArrayList<HomeMultiItemEntity>
        mPresenter.homePageSlide()
    }

    private var mHomePageUnitsBean = HomePageUnitsBean()
    private var data: MutableList<HomeMultiItemEntity> = mutableListOf()

    override fun injectComponent() {
        DaggerHomeComponent.builder().fragmentComponent(fragmentComponent)
                .homeModule(HomeModule())
                .build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.mView = this
        mPresenter.homePageUnits()

    }
}
