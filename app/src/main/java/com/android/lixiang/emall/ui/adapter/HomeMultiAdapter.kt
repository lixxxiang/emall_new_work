package com.android.lixiang.emall.ui.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import com.android.lixiang.base.utils.view.GridSpacingItemDecoration
import com.android.lixiang.base.utils.view.TextSwitcherView2
import com.android.lixiang.emall.R
import com.android.lixiang.emall.presenter.data.HomeMultiItemEntity
import com.android.lixiang.emall.presenter.data.entity.BannerEntity
import com.android.lixiang.emall.presenter.data.entity.EveryDayPicEntity
import com.android.lixiang.emall.presenter.data.entity.HorizontalEntity
import com.android.lixiang.emall.presenter.data.entity.TheThreeEntity
import com.android.lixiang.emall.ui.fragment.HomeFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper

import java.util.ArrayList


class HomeMultiAdapter
/**
 * Same as QuickAdapter#QuickAdapter(Context,int) but with
 * some initialization data.
 *
 * @param data A new list is created out of this one to avoid mutable list
 */
(data: List<HomeMultiItemEntity>) : BaseMultiItemQuickAdapter<HomeMultiItemEntity, BaseViewHolder>(data) {
    init {
        addItemType(0, R.layout.banner_layout)
        addItemType(1, R.layout.every_day_pic_layout)
        addItemType(2, R.layout.the_three_layout)
        addItemType(3, R.layout.horizontal_layout)
        addItemType(4, R.layout.recommand_layout)
    }

    var bannerDataType: List<String> = ArrayList()
    var bannerProductId: List<String> = ArrayList()
    var bannerLink: List<String> = ArrayList()
    var fragment: HomeFragment? = null
    private val RECYCLER_OPTIONS = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()

    fun create(f: HomeFragment, data: List<HomeMultiItemEntity>): HomeMultiAdapter {
        fragment = f
        return HomeMultiAdapter(data)
    }

//    private fun HomeMultiAdapter(data: List<HomeMultiItemEntity>): HomeMultiAdapter {
//        super(data)
//    }


    override fun convert(helper: BaseViewHolder, item: HomeMultiItemEntity) {

        val banner = helper.getView<com.youth.banner.Banner>(R.id.banner)
        val bannerImages: MutableList<String> = mutableListOf()
        val everyDayPicTitles: MutableList<String> = mutableListOf()
        val horiziontalRecyclerView = helper.getView<RecyclerView>(R.id.scroll_horiziontal_recyclerview)
        val recommandRecyclerView = helper.getView<RecyclerView>(R.id.mRecommandRecyclerView)

        when (helper.itemViewType) {
            0 -> {
                val size = (item.getField("BANNER") as ArrayList<*>).size
                banner.setImageLoader(GlideImageLoader())
                for (i in 0 until size)
                    bannerImages.add(((item.getField("BANNER") as ArrayList<*>)[i] as BannerEntity).imageUrl)
                println(bannerImages)
                banner.setImages(bannerImages)
//                bannerDataType = entity.getField(MultipleFields.BANNERS_DATA_TYPE) as List<String>
//                bannerProductId = entity.getField(MultipleFields.BANNERS_PRODUCT_ID) as List<String>
//                bannerLink = entity.getField(MultipleFields.BANNERS_LINK) as List<String>
//
                banner.start()
//                mIsInitBanner = true
//                holder.addOnClickListener(R.id.banner)
//                banner.setOnBannerListener(this)
            }
            1 -> {
                val size = (item.getField("EVERY_DAY_PIC") as ArrayList<*>).size
                for (i in 0 until size)
                    everyDayPicTitles.add(((item.getField("EVERY_DAY_PIC") as ArrayList<*>)[i] as EveryDayPicEntity).picContentName)
                val tsv = helper.getView<TextSwitcherView2>(R.id.mep_detail_tv)
                tsv.getResource(everyDayPicTitles as ArrayList<String>)
            }
            2 -> {
                Glide.with(mContext)
                        .load(((item.getField("THE_THREE") as ArrayList<*>)[0] as TheThreeEntity).imageUrl)
                        .apply(RECYCLER_OPTIONS)
                        .into(helper.getView(R.id.the_three_1) as ImageView)
                Glide.with(mContext)
                        .load(((item.getField("THE_THREE") as ArrayList<*>)[1] as TheThreeEntity).imageUrl)
                        .apply(RECYCLER_OPTIONS)
                        .into(helper.getView(R.id.the_three_2) as ImageView)
                Glide.with(mContext)
                        .load(((item.getField("THE_THREE") as ArrayList<*>)[2] as TheThreeEntity).imageUrl)
                        .apply(RECYCLER_OPTIONS)
                        .into(helper.getView(R.id.the_three_3) as ImageView)
//                holder.getView(R.id.the_three_1).setOnClickListener(View.OnClickListener { theThreeClick(theThreeList, 0) })
//                holder.getView(R.id.the_three_2).setOnClickListener(View.OnClickListener { theThreeClick(theThreeList, 1) })
//                holder.getView(R.id.the_three_3).setOnClickListener(View.OnClickListener { theThreeClick(theThreeList, 2) })
            }
            3 -> {
                horiziontalRecyclerView.layoutManager = LinearLayoutManager(horiziontalRecyclerView.context, LinearLayout.HORIZONTAL, false)
//                horiziontalRecyclerView.addItemDecoration(GridSpacingItemDecoration(, 20, true))
                val snapHelperStart = GravitySnapHelper(Gravity.START)
                snapHelperStart.attachToRecyclerView(horiziontalRecyclerView)
//                horiziontalRecyclerView.adapter = ItemUnitAdapter(item.getField("HORIZONTAL") as List<HorizontalEntity>, mContext, fragment)
                horiziontalRecyclerView.adapter = ItemUnitAdapter(item.getField("HORIZONTAL") as List<HorizontalEntity>, mContext)

            }
            4 -> {
                val manager = GridLayoutManager(mContext, 2)
                recommandRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 20, true))
                recommandRecyclerView.layoutManager = manager
                recommandRecyclerView.adapter = RecommandAdapter(item.getField("RECOMMAND") as List<HorizontalEntity>, mContext)
            }
        }
    }
}
