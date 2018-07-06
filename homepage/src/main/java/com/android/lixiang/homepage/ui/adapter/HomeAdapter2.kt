package com.android.lixiang.homepage.ui.adapter

import com.android.lixiang.homepage.R
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.blankj.utilcode.util.SnackbarUtils.getView
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.BaseQuickAdapter
import com.orhanobut.logger.Logger


class HomeAdapter2(layoutResId: Int, data: List<HomePageUnitsBean>)
    : BaseQuickAdapter<HomePageUnitsBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: HomePageUnitsBean) {
        helper!!.setText(R.id.tv, mTitle[helper.layoutPosition])
    }


    private var mTitle: MutableList<String> = mutableListOf()

    init {
        dataFormat()
    }

    private fun dataFormat() {
        for (i in 0 until data[0].data!!.size){
            mTitle[i] = data[0].data!![i].title!!
        }
    }
}