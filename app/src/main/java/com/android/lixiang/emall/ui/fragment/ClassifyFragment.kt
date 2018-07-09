package com.android.lixiang.emall.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.android.lixiang.base.utils.view.DimenUtil
import com.android.lixiang.base.utils.view.SquareImageView
import com.android.lixiang.classify.ui.activity.OpticsActivity
import com.android.lixiang.emall.R
import kotlinx.android.synthetic.main.fragment_classify.*
import org.jetbrains.anko.support.v4.startActivity

class ClassifyFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            I1 -> {
                startActivity<OpticsActivity>()
            }
        }
    }

    private var I1: SquareImageView? = null
    private var I2: SquareImageView? = null
    private var I3: SquareImageView? = null
    private var I4: SquareImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classify, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()

//        btn.setOnClickListener {

//        }
//
//        btn2.setOnClickListener {
//            startActivity<OpticsActivity>()
//        }
    }

    @SuppressLint("ResourceType")
    private fun initViews() {
        val screenWidth = activity!!.application.resources.displayMetrics.widthPixels.toFloat()//1440
        val WIDTH = (DimenUtil().px2dip(context!!, screenWidth) - 48F) / 2

        I1 = SquareImageView(activity)
        I1!!.id = 1
        val I1L = RelativeLayout.LayoutParams(DimenUtil().dip2px(context!!, WIDTH), DimenUtil().dip2px(context!!, WIDTH))
        I1!!.setBackgroundResource(R.drawable.img_classify_1)
        I1!!.layoutParams = I1L
        mClassifyRL!!.addView(I1)
        I1!!.setOnClickListener(this)

        I2 = SquareImageView(activity)
        I2!!.id = 2
        val I2L = RelativeLayout.LayoutParams(DimenUtil().dip2px(context!!, WIDTH), DimenUtil().dip2px(context!!, WIDTH))
        I2!!.setBackgroundResource(R.drawable.img_classify_2)
        I2L.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        I2!!.layoutParams = I2L
        mClassifyRL!!.addView(I2)

        I3 = SquareImageView(activity)
        val I3L = RelativeLayout.LayoutParams(DimenUtil().dip2px(context!!, WIDTH), DimenUtil().dip2px(context!!, WIDTH))
        I3!!.setBackgroundResource(R.drawable.img_classify_3)
        I3L.addRule(RelativeLayout.BELOW, I1!!.id)
        I3L.setMargins(0, DimenUtil().dip2px(context!!, 16F), 0, 0)
        I3!!.layoutParams = I3L
        mClassifyRL!!.addView(I3)

        I4 = SquareImageView(activity)
        val I4L = RelativeLayout.LayoutParams(DimenUtil().dip2px(context!!, WIDTH), DimenUtil().dip2px(context!!, WIDTH))
        I4!!.setBackgroundResource(R.drawable.img_classify_4)
        I4L.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        I4L.addRule(RelativeLayout.BELOW, I2!!.id)
        I4L.setMargins(0, DimenUtil().dip2px(context!!, 16F), 0, 0)
        I4!!.layoutParams = I4L
        mClassifyRL!!.addView(I4)
    }
}
