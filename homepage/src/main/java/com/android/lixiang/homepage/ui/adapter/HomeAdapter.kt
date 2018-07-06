package com.android.lixiang.homepage.ui.adapter

import com.android.lixiang.homepage.R
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.blankj.utilcode.util.SnackbarUtils.getView
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.BaseQuickAdapter
import com.orhanobut.logger.Logger


class HomeAdapter(layoutResId: Int, data: MutableList<HomePageUnitsBean.DataBean.PiecesBean>)
    : BaseQuickAdapter<HomePageUnitsBean.DataBean.PiecesBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: HomePageUnitsBean.DataBean.PiecesBean?) {
        helper!!.setText(R.id.tv, item!!.posTitle)
    }


    private var mTitle: MutableList<String> = mutableListOf()

    init {
        dataFormat()
    }

    private fun dataFormat() {
    }
}