package com.android.lixiang.homepage.presenter.data

import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageSlideBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.data.entity.BannerEntity
import com.android.lixiang.homepage.presenter.data.entity.EveryDayPicEntity
import com.android.lixiang.homepage.presenter.data.entity.HorizontalEntity
import com.android.lixiang.homepage.presenter.data.entity.TheThreeEntity

class DataConverter2 {
    val entities: ArrayList<HomeMultiItemEntity> = ArrayList()

    var bannerData: MutableList<BannerEntity>? = mutableListOf()
    var everyDayPicData: MutableList<EveryDayPicEntity>? = mutableListOf()
    var theThreeData: MutableList<TheThreeEntity>? = mutableListOf()
    var horizontalData: MutableList<HorizontalEntity>? = mutableListOf()

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

    fun horizontalConvert(res: List<HomePageUnitsBean.DataBean.PiecesBean>): ArrayList<HomeMultiItemEntity> {
        val size = res.size
        var title: String?
        var detail: String?
        var imageUrl: String?
        var price: String?
        var type: String?
        var position: String?
        var productId: String?
        var posMark: String?
        for (i in 0 until size) {
            title = res[i].posTitle
            detail = res[i].posDescription
            imageUrl = res[i].imageUrl
            price = res[i].price
            type = res[i].dataType
            productId = res[i].productId
            position = res[i].position
            posMark = res[i].posMark

            horizontalData!!.add(HorizontalEntity(type, imageUrl, detail, posMark, title, position, productId, price))
        }
        val entity = HomeMultiItemEntity()
        entity.MULTIPLE_FIELDS["HORIZONTAL"] = horizontalData!!
        entity.MULTIPLE_FIELDS["SPAN_SIZE"] = 2
        entity.MULTIPLE_FIELDS["ITEM_TYPE"] = 3
        entities.add(entity)
        return entities
    }
}