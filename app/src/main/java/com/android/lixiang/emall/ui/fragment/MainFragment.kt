package com.android.lixiang.emall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.lixiang.base.ui.fragment.BaseMvpFragment

import com.android.lixiang.emall.R
import com.android.lixiang.emall.presenter.injection.module.MainFragmentModule
import com.android.lixiang.emall.presenter.MainFragmentPresenter
import com.android.lixiang.emall.presenter.injection.component.DaggerMainFragmentComponent
import com.android.lixiang.emall.presenter.view.MainFragmentView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseMvpFragment<MainFragmentPresenter>(), MainFragmentView {
    override fun injectComponent() {
        DaggerMainFragmentComponent.builder()
                .fragmentComponent(fragmentComponent)
                .mainFragmentModule(MainFragmentModule())
                .build()
                .inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn.setOnClickListener {
            mPresenter.mView = this
            mPresenter.testPresenterWithService()
        }
    }
}
