package com.android.lixiang.search.ui.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.View
import android.widget.AbsListView
import com.android.lixiang.base.ui.activity.BaseMvpActivity
import com.android.lixiang.search.R
import com.android.lixiang.search.R.id.mSearchToolbar
import com.android.lixiang.search.R.id.mSearchView
import com.android.lixiang.search.presenter.SearchPresenter
import com.android.lixiang.search.presenter.data.bean.GetPoiBean
import com.android.lixiang.search.presenter.injection.component.DaggerSearchComponent
import com.android.lixiang.search.presenter.injection.module.SearchModule
import com.android.lixiang.search.ui.adapter.SearchAdapter
import com.android.lixiang.search.ui.adapter.SearchCitiesAdapter
import com.android.lixiang.search.ui.adapter.SearchPoisAdapter
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : BaseMvpActivity<SearchPresenter>(), com.android.lixiang.search.presenter.view.SearchView {
    private var mSugNameList: MutableList<String>? = mutableListOf()
    private var mSugNumberList: MutableList<String>? = mutableListOf()
    private var mGdPoisNameList: MutableList<String>? = mutableListOf()
    private var mGdPoisAddressList: MutableList<String>? = mutableListOf()
    private var citiesAdapter: SearchCitiesAdapter? = null
    private var poisAdapter: SearchPoisAdapter? = null
    private var level: Int? = 0


    override fun onGetPoiResult(res: GetPoiBean) {
        hideProgressBar()
        if (res.sug != null) {
            showCitiesListView()
            for (i in 0 until res.sug.size) {
                mSugNameList!!.add(res.sug[i].cites[0].name)
                mSugNumberList!!.add(res.sug[i].cites[0].num)
            }
            citiesAdapter = SearchCitiesAdapter(mSugNameList, mSugNumberList, this)
            mSearchListViewCities.adapter = citiesAdapter
        }

        if (res.gdPois != null) {
            showPoisListView()
            for (i in 0 until res.gdPois.poiList.size) {
                mGdPoisNameList!!.add(res.gdPois.poiList[i].name)

                addressFormat(res, i)

                mGdPoisAddressList!!.add(String.format("%s %s %s",
                        res.gdPois.poiList[i].cityname,
                        res.gdPois.poiList[i].adname,
                        res.gdPois.poiList[i].address))
            }
            poisAdapter = SearchPoisAdapter(mGdPoisNameList, mGdPoisAddressList, this)
            mSearchListViewPois.adapter = poisAdapter
        }
    }


    private var queryString: String? = null
    override fun injectComponent() {
        DaggerSearchComponent.builder().activityComponent(activityComponent)
                .searchModule(SearchModule())
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        mPresenter.mView = this

        initSearchView()
        hideLine()
        initToolbar()

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                queryString = s
                clearData()
                level = 0
                mPresenter.getPoi(queryString.toString(), "")
                showProgressBar()
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })

        mSearchListViewPois.setOnItemClickListener { parent, view, position, id ->

        }

        mSearchListViewCities.setOnItemClickListener { parent, view, position, id ->
            hideCitiesListView()
            clearGdPoisData()
            mPresenter.getPoi(queryString!!, mSugNameList!![position])
            showProgressBar()
            level = 1
        }
    }

    private fun addressFormat(res: GetPoiBean, i: Int) {
        if (res.gdPois.poiList[i].cityname == null)
            res.gdPois.poiList[i].cityname = res.gdPois.poiList[i].name
        if (res.gdPois.poiList[i].adname == null)
            res.gdPois.poiList[i].adname = ""
        if (res.gdPois.poiList[i].address == null)
            res.gdPois.poiList[i].address = ""
    }

    private fun showCitiesListView() {
        if (mSearchListViewPois.visibility == View.VISIBLE)
            mSearchListViewPois.visibility = View.INVISIBLE
        mSearchListViewCities.visibility = View.VISIBLE
    }

    private fun hideCitiesListView(){
        if (mSearchListViewCities.visibility == View.VISIBLE)
            mSearchListViewCities.visibility = View.INVISIBLE
    }

    private fun showPoisListView() {
        if (mSearchListViewCities.visibility == View.VISIBLE)
            mSearchListViewCities.visibility = View.INVISIBLE
        mSearchListViewPois.visibility = View.VISIBLE
    }

    private fun showProgressBar(){
        mSearchProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        mSearchProgressBar.visibility = View.INVISIBLE
    }

    private fun initToolbar() {
        mSearchToolbar.title = ""
        setSupportActionBar(mSearchToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mSearchToolbar.setNavigationOnClickListener {
            when (level) {
                0 -> this.finish()
                1 -> {
                    showCitiesListView()
                    level = 0
                }
            }
        }
    }

    private fun initSearchView() {
        mSearchView.setIconifiedByDefault(true)
        mSearchView.isFocusable = true
        mSearchView.isIconified = false
        mSearchView.requestFocusFromTouch()
    }

    private fun clearData() {
        clearSugData()
        clearGdPoisData()
    }

    private fun clearSugData(){
        mSugNameList!!.clear()
        mSugNumberList!!.clear()
    }

    private fun clearGdPoisData(){
        mGdPoisNameList!!.clear()
        mGdPoisAddressList!!.clear()
    }

    private fun hideLine() {
        val calSearchView = findViewById<SearchView>(R.id.mSearchView)
        if (calSearchView != null) {
            try {
                val argClass = calSearchView.javaClass
                val ownField = argClass.getDeclaredField("mSearchPlate")
                ownField.isAccessible = true
                val mView = ownField.get(calSearchView) as View
                mView.setBackgroundColor(Color.TRANSPARENT)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
