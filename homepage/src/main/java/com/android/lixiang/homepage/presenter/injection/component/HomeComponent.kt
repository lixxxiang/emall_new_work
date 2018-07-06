package com.android.lixiang.homepage.presenter.injection.component

import com.android.lixiang.base.injection.ComponentScope
import com.android.lixiang.base.injection.component.FragmentComponent
import com.android.lixiang.homepage.presenter.injection.module.HomeModule
import com.android.lixiang.homepage.ui.fragment.HomeFragment
import dagger.Component

@ComponentScope
@Component(dependencies = arrayOf(FragmentComponent::class), modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}