package com.android.lixiang.classify.ui.activity

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import com.android.lixiang.base.utils.view.AppBarStateChangeListener
import com.android.lixiang.base.utils.view.StatusBarUtil
import com.android.lixiang.classify.R
import kotlinx.android.synthetic.main.activity_optics.*
import android.support.design.widget.TabLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import com.android.lixiang.base.ui.activity.BaseMvpActivity
import com.android.lixiang.base.utils.view.DimenUtil
import com.android.lixiang.base.utils.view.GridSpacingItemDecoration
import com.android.lixiang.classify.presenter.OpticsPresenter
import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean
import com.android.lixiang.classify.presenter.injection.component.DaggerClassifyComponent
import com.android.lixiang.classify.presenter.injection.module.ClassifyModule
import com.android.lixiang.classify.presenter.view.OpticsView
import com.android.lixiang.classify.ui.adapter.OpticsAdapter
import com.android.lixiang.search.ui.activity.SearchActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.content_scrolling.*
import org.jetbrains.anko.startActivity


class OpticsActivity : BaseMvpActivity<OpticsPresenter>(), OpticsView {
    override fun injectComponent() {
        DaggerClassifyComponent.builder().activityComponent(activityComponent)
                .classifyModule(ClassifyModule())
                .build().inject(this)
    }

    override fun onSceneSearchResult(res: SceneSearchBean) {
        sceneSearchDataList = res.data.searchReturnDtoList
        mClassifyRecyclerView.layoutManager = mGridLayoutManager
        mClassifyRecyclerView.adapter = OpticsAdapter(R.layout.optics_recyclerview_layout,sceneSearchDataList)
    }

    var mActivity: OpticsActivity? = null
    var sceneSearchDataList: MutableList<SceneSearchBean.DataBean.SearchReturnDtoListBean> = mutableListOf()
    var mGridLayoutManager: GridLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_optics)
        mActivity = this
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)

        appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onStateChanged(appBarLayout: AppBarLayout, state: State) {
                when (state) {
                    State.EXPANDED -> {
                        mToolbar.title = ""
                        StatusBarUtil.setTranslucentForImageViewInFragment(mActivity, 0, null)
                    }
                    State.COLLAPSED -> {
                        StatusBarUtil.setColor(mActivity, Color.parseColor("#A58E63"), 0)
                    }
                    else -> {
                        mToolbar.title = ""
                        StatusBarUtil.setTranslucentForImageViewInFragment(mActivity, 0, null)
                    }
                }
            }
        })

        mToolbar.title = "光学1级"
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        initTab()
        initLayoutManager()
        getData()

        classify_toolbar_search_iv.setOnClickListener {
            startActivity<SearchActivity>()
        }
    }

    private fun initLayoutManager() {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mGridLayoutManager!!.isSmoothScrollbarEnabled = true
        mGridLayoutManager!!.isAutoMeasureEnabled = true
        mClassifyRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, DimenUtil().dip2px(this, 14F), true))
        mClassifyRecyclerView.layoutManager = mGridLayoutManager
        mClassifyRecyclerView.setHasFixedSize(true)
        mClassifyRecyclerView.isNestedScrollingEnabled = false
    }

    private fun getData() {
        mPresenter.mView = this
        mPresenter.sceneSearch("","","",
                "","","",
                "","","10",
                "1","","android")
    }

    private fun initTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText("北京"))
        mTabLayout.addTab(mTabLayout.newTab().setText("上海"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 3"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 4"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 5"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 6"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 7"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 8"))
    }
}
