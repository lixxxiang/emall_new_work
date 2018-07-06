package com.android.lixiang.homepage.presenter.data

import com.android.lixiang.homepage.presenter.data.bean.HomePageBean
import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean
import com.android.lixiang.homepage.presenter.data.entity.EveryDayPicEntity
import com.android.lixiang.homepage.presenter.data.entity.TheThreeEntity

//class DataConverter {
//    fun everyDayPicConverter(homePageBean: HomePageBean): EveryDayPicEntity {
//        val everyDayPicEntity = EveryDayPicEntity()
//        val dailyPic: MutableList<String>? = mutableListOf()
//        for (i in 0..2)
//            dailyPic!!.add(homePageBean.data.mixedContentList[i].contentName)
//        everyDayPicEntity.picContentName = dailyPic
//        return everyDayPicEntity
//    }
//
//    fun theThreeConverter(homePageUnitsBean: HomePageUnitsBean): MutableList<TheThreeEntity> {
//        val theThreeList: MutableList<TheThreeEntity>? = mutableListOf()
//        val size = homePageUnitsBean.data!![1].pieces!!.size
//        for (i in 0 until size){
//            val theThreeEntity = TheThreeEntity()
//            theThreeEntity.dataType = homePageUnitsBean.data!![1].pieces!![i].dataType
//            theThreeEntity.imageUrl = homePageUnitsBean.data!![1].pieces!![i].imageUrl
//            theThreeEntity.price = homePageUnitsBean.data!![1].pieces!![i].price
//            theThreeEntity.position = homePageUnitsBean.data!![1].pieces!![i].position
//            theThreeList!!.add(theThreeEntity)
//        }
//
//        return theThreeList!!
//    }
//}