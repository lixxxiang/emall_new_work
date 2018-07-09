package com.android.lixiang.emall.presenter.injection.component

import com.android.lixiang.base.injection.ComponentScope
import com.android.lixiang.base.injection.component.FragmentComponent
import com.android.lixiang.emall.presenter.injection.module.MainFragmentModule
import com.android.lixiang.emall.ui.fragment.MainFragment
import dagger.Component

@ComponentScope
@Component(dependencies = arrayOf(FragmentComponent::class), modules = arrayOf(MainFragmentModule::class))
interface MainFragmentComponent {
    fun inject(fragment: MainFragment)
}