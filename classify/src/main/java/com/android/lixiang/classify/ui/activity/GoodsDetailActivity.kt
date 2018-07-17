package com.android.lixiang.classify.ui.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.lixiang.classify.R
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_goods_detail.*
import java.util.ArrayList
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bumptech.glide.Glide


class GoodsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initViews()
    }

    private fun initViews() {
        mGoodsDetailToolbar.title = ""
        setSupportActionBar(mGoodsDetailToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mGoodsDetailToolbar.setNavigationOnClickListener {
            this.finish()
        }

        val mTitles = arrayOf("预览图", " 参数", "位置")
        val mIconUnselectIds = intArrayOf(R.drawable.abc_ab_share_pack_mtrl_alpha,R.drawable.abc_ab_share_pack_mtrl_alpha,R.drawable.abc_ab_share_pack_mtrl_alpha)
        val mIconSelectIds = intArrayOf(R.drawable.abc_ab_share_pack_mtrl_alpha,R.drawable.abc_ab_share_pack_mtrl_alpha,R.drawable.abc_ab_share_pack_mtrl_alpha)
        val mTabEntities: ArrayList<CustomTabEntity>? = ArrayList()
        for (i in 0 until mTitles.size) {
            mTabEntities!!.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]))
            mTabLayout.setTabData(mTabEntities)
        }


        mVideoView.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4",
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
                "")
        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(mVideoView.thumbImageView);

    }

    class TabEntity(var title: String, var selectedIcon: Int, var unSelectedIcon: Int) : CustomTabEntity {
        override fun getTabTitle(): String {
            return title
        }

        override fun getTabSelectedIcon(): Int {
            return selectedIcon
        }

        override fun getTabUnselectedIcon(): Int {
            return unSelectedIcon
        }
    }

    override fun onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }
}
