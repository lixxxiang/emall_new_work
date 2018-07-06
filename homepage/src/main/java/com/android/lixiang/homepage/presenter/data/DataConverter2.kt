package com.android.lixiang.homepage.presenter.data

import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.data.entity.BannerEntity
import com.android.lixiang.homepage.presenter.data.entity.EveryDayPicEntity
import com.android.lixiang.homepage.presenter.data.entity.TheThreeEntity

class DataConverter2 {
    val entities: ArrayList<HomeMultiItemEntity> = ArrayList()

    var bannerData: MutableList<BannerEntity>? = mutableListOf()
    var everyDayPicData: MutableList<EveryDayPicEntity>? = mutableListOf()
    var theThreeData: MutableList<TheThreeEntity>? = mutableListOf()

    fun bannerConvert(res: MutableList<HomePageSlideBean.DataBean>)
            : ArrayList<HomeMultiItemEntity> {
        val size = res.size
        for (i in 0 until size)
            bannerData!!.add(BannerEntity(res[i].dataType, res[i].imageUrl, res[i].link, res[i].productId))

        val entity = HomeMultiItemEntity()
        entity.MULTIPLE_FIELDS["BANNER"] = bannerData
        entity.MULTIPLE_FIELDS["SPAN_SIZE"] = 2
        entity.MULTIPLE_FIELDS["ITEM_TYPE"] = 0
        entities.add(entity)
        return entities
    }

    fun everyDayPicConvert(res: MutableList<HomePageBean.DataBean.MixedContentListBean>)
            : ArrayList<HomeMultiItemEntity> {
        val size = res.size
        for (i in 0 until size)
            everyDayPicData!!.add(EveryDayPicEntity(res[i].contentName))

        val entity = HomeMultiItemEntity()
        entity.MULTIPLE_FIELDS["EVERY_DAY_PIC"] = everyDayPicData
        entity.MULTIPLE_FIELDS["SPAN_SIZE"] = 2
        entity.MULTIPLE_FIELDS["ITEM_TYPE"] = 1
        entities.add(entity)
        return entities
    }

    fun theThreeConvert(res: List<HomePageUnitsBean.DataBean.PiecesBean>): ArrayList<HomeMultiItemEntity> {
        val size = res.size
        for (i in 0 until size)
            theThreeData!!.add(TheThreeEntity(res[i].dataType, res[i].imageUrl, res[i].position, res[i].price))

        val entity = HomeMultiItemEntity()
        entity.MULTIPLE_FIELDS["THE_THREE"] = theThreeData!!
        entity.MULTIPLE_FIELDS["SPAN_SIZE"] = 2
        entity.MULTIPLE_FIELDS["ITEM_TYPE"] = 2
        entities.add(entity)
        return entities
    }
}