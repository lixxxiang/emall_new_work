package com.android.lixiang.emall.ui.fragment

import android.os.Bundle
import android.os.Handler
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
import android.support.v7.widget.RecyclerView
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.android.lixiang.base.utils.view.DimenUtil
import com.android.lixiang.emall.R
import com.android.lixiang.emall.presenter.data.HomeMultiItemEntity
import com.android.lixiang.emall.presenter.data.bean.HomePageBean
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseMvpFragment<HomePresenter>(), HomeView {
    override fun onHomePageResult(res: HomePageBean) {
        print(res.data.mixedContentList[0].contentDate)
        data.add(DataConverter2().everyDayPicConvert(res.data.mixedContentList)[0])
        mPresenter.homePageUnits()


    }

    override fun onHomePageSlideResult(res: HomePageSlideBean) {
        data.add(DataConverter2().bannerConvert(res.data as MutableList<HomePageSlideBean.DataBean>)[0])
        mPresenter.homePage("10", "1")
    }

    override fun onHomePageUnitsResult(res: HomePageUnitsBean) {
        mHomePageUnitsBean = res
        data.add(DataConverter2().theThreeConvert(res.data!![1].pieces!!)[0])
        data.add(DataConverter2().horizontalConvert(res.data!![0].pieces!!)[0])
        data.add(DataConverter2().recommandConvert(res.data!![2].pieces!!)[0])
        //ArrayList<HomeMultiItemEntity>
//        mPresenter.homePageSlide()
        mHomeRecyclerView.layoutManager = LinearLayoutManager(activity)
        mHomeRecyclerView.adapter = HomeMultiAdapter(data)
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
        mPresenter.homePageSlide()

        mHomeRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            internal var mScrollThreshold: Int = 0
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val isSignificantDelta = Math.abs(dy) > mScrollThreshold
                if (isSignificantDelta) {
                    if (dy > 0) {
                        onScrollUp()
//                        slideDown(mBottomView)

                    } else {
                        onScrollDown()
//                        slideUp(mBottomView)
                    }
                }
            }

            fun setScrollThreshold(scrollThreshold: Int) {
                mScrollThreshold = scrollThreshold
            }
        })

    }

    private fun onScrollDown() {
        //下滑时要执行的代码
        Logger.d("donw")
    }

    private fun onScrollUp() {
        //上滑时要执行的代码
        Logger.d("up")
    }

    private fun slideDown(rl: LinearLayout): AnimationSet {
        val animationSet = AnimationSet(true)
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f)
        translateAnimation.duration = 500
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                val brParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DimenUtil().dip2px(context!!, 50F))
                brParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                brParams.setMargins(DimenUtil().dip2px(context!!, 10F), 0, DimenUtil().dip2px(context!!, 10F), DimenUtil().dip2px(context!!, -230F))
                rl.layoutParams = brParams
            }
        })
        animationSet.addAnimation(translateAnimation)
        return animationSet
    }

    private fun slideUp(rl: LinearLayout): AnimationSet {
        val animationSet = AnimationSet(true)
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f)
        translateAnimation.duration = 500
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                Handler().postDelayed(
                        {
                            val brParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DimenUtil().dip2px(context!!, 50F))
                            brParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                            brParams.setMargins(DimenUtil().dip2px(context!!, 10F), 0, DimenUtil().dip2px(context!!, 10F), DimenUtil().dip2px(context!!, 6F))
                            rl.layoutParams = brParams
                        }, 10)
            }
        })
        animationSet.addAnimation(translateAnimation)
        return animationSet
    }
}
