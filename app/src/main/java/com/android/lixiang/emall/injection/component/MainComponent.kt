package com.android.lixiang.emall.injection.component

import com.android.lixiang.base.injection.ComponentScope
import com.android.lixiang.base.injection.component.ActivityComponent
import com.android.lixiang.emall.ui.activity.MainActivity
import com.android.lixiang.emall.injection.module.MainModule
import dagger.Component

@ComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}