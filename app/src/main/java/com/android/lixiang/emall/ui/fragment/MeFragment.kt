package com.android.lixiang.emall.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.lixiang.base.ui.fragment.BaseMvpFragment
import com.android.lixiang.emall.presenter.HomePresenter
import com.android.lixiang.emall.presenter.data.DataConverter2
import com.android.lixiang.emall.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.emall.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.injection.component.DaggerHomeComponent
import com.android.lixiang.homepage.presenter.injection.module.HomeModule
import com.android.lixiang.emall.presenter.view.HomeView
import com.android.lixiang.emall.ui.adapter.HomeMultiAdapter
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.android.lixiang.base.utils.view.ScreenUtil.dip2px
import com.android.lixiang.emall.R
import com.android.lixiang.emall.presenter.data.HomeMultiItemEntity
import com.android.lixiang.emall.presenter.data.bean.HomePageBean
import com.android.lixiang.emall.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*


class MeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }


}
