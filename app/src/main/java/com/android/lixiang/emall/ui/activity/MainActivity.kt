package com.android.lixiang.emall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.RelativeLayout
import com.android.lixiang.base.ui.activity.BaseMvpActivity
import com.android.lixiang.emall.R
import com.android.lixiang.emall.injection.component.DaggerMainComponent
import com.android.lixiang.emall.injection.module.MainModule
import com.android.lixiang.emall.presenter.MainPresenter
import com.android.lixiang.emall.presenter.view.MainView
import com.android.lixiang.emall.ui.fragment.ClassifyFragment
import com.android.lixiang.emall.ui.fragment.MainFragment
import com.android.lixiang.homepage.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : BaseMvpActivity<MainPresenter>(), MainView {
    override fun injectComponent() {
        DaggerMainComponent.builder()
                .activityComponent(activityComponent)
                .mainModule(MainModule())
                .build()
                .inject(this)
    }

    private val mStack = Stack<Fragment>()
    private val mHomeFragment by lazy { HomeFragment() }
    private val mClassifyFragment by lazy { ClassifyFragment() }

    private val mMainFragment by lazy { MainFragment() }


    private fun initFragment(){
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mFrameLayout,mHomeFragment)
        manager.add(R.id.mFrameLayout,mClassifyFragment)

        manager.add(R.id.mFrameLayout,mMainFragment)
        manager.commit()
        mStack.add(mHomeFragment)
        mStack.add(mClassifyFragment)
        mStack.add(mMainFragment)

    }



    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        DaggerMainComponent.create().inject(this)
        //same???

        mPresenter.mView = this

        initFragment()
        initNavigationView()

        changeFragment(0)
    }

//    fun btnClick(view: View) {
////        mPresenter.testPresenter()
//        mPresenter.testPresenterWithService()
//    }

    private fun initNavigationView() {
        val mIcon1 = mBottomNavigationView.findViewById<AppCompatImageView>(R.id.mIcon1)
        val mIcon2 = mBottomNavigationView.findViewById<AppCompatImageView>(R.id.mIcon2)
        val mIcon4 = mBottomNavigationView.findViewById<AppCompatImageView>(R.id.mIcon4)
        val mIcon5 = mBottomNavigationView.findViewById<AppCompatImageView>(R.id.mIcon5)

        val mTitle1 = mBottomNavigationView.findViewById<AppCompatTextView>(R.id.mTitle1)
        val mTitle2 = mBottomNavigationView.findViewById<AppCompatTextView>(R.id.mTitle2)
        val mTitle4 = mBottomNavigationView.findViewById<AppCompatTextView>(R.id.mTitle3)
        val mTitle5 = mBottomNavigationView.findViewById<AppCompatTextView>(R.id.mTitle4)

        val mField1 = mBottomNavigationView.findViewById<RelativeLayout>(R.id.mField1)
        val mField2 = mBottomNavigationView.findViewById<RelativeLayout>(R.id.mField2)
        val mField3 = mBottomNavigationView.findViewById<RelativeLayout>(R.id.mField3)
        val mField4 = mBottomNavigationView.findViewById<RelativeLayout>(R.id.mField4)
        val mField5 = mBottomNavigationView.findViewById<RelativeLayout>(R.id.mField5)

        mIcon1.setBackgroundResource(R.drawable.home_nav_icon)
        mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorMain))

        mField1.setOnClickListener {
            mIcon1.setBackgroundResource(R.drawable.home_nav_icon)
            mIcon2.setBackgroundResource(R.drawable.classify_nav_icon_gray)
            mIcon4.setBackgroundResource(R.drawable.special_nav_icon_gray)
            mIcon5.setBackgroundResource(R.drawable.me_nav_icon_gray)

            mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorMain))
            mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle4.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle5.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))

            changeFragment(0)
        }

        mField2.setOnClickListener {
            mIcon1.setBackgroundResource(R.drawable.home_nav_icon_gray)
            mIcon2.setBackgroundResource(R.drawable.classify_nav_icon)
            mIcon4.setBackgroundResource(R.drawable.special_nav_icon_gray)
            mIcon5.setBackgroundResource(R.drawable.me_nav_icon_gray)

            mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorMain))
            mTitle4.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle5.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            changeFragment(1)

        }

        mField3.setOnClickListener {
            mIcon1.setBackgroundResource(R.drawable.home_nav_icon_gray)
            mIcon2.setBackgroundResource(R.drawable.classify_nav_icon_gray)
            mIcon4.setBackgroundResource(R.drawable.special_nav_icon_gray)
            mIcon5.setBackgroundResource(R.drawable.me_nav_icon_gray)

            mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle4.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle5.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
        }

        mField4.setOnClickListener {
            mIcon1.setBackgroundResource(R.drawable.home_nav_icon_gray)
            mIcon2.setBackgroundResource(R.drawable.classify_nav_icon_gray)
            mIcon4.setBackgroundResource(R.drawable.special_nav_icon)
            mIcon5.setBackgroundResource(R.drawable.me_nav_icon_gray)

            mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle4.setTextColor(ContextCompat.getColor(this, R.color.colorMain))
            mTitle5.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))

            changeFragment(0)

        }

        mField5.setOnClickListener {
            mIcon1.setBackgroundResource(R.drawable.home_nav_icon_gray)
            mIcon2.setBackgroundResource(R.drawable.classify_nav_icon_gray)
            mIcon4.setBackgroundResource(R.drawable.special_nav_icon_gray)
            mIcon5.setBackgroundResource(R.drawable.me_nav_icon)

            mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle4.setTextColor(ContextCompat.getColor(this, R.color.colorTextGray))
            mTitle5.setTextColor(ContextCompat.getColor(this, R.color.colorMain))
            changeFragment(1)

        }
    }
}
