package com.android.lixiang.classify.presenter.injection.component

import com.android.lixiang.base.injection.ComponentScope
import com.android.lixiang.base.injection.component.ActivityComponent
import com.android.lixiang.classify.presenter.injection.module.ClassifyModule
import com.android.lixiang.classify.ui.activity.OpticsActivity
import dagger.Component

@ComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(ClassifyModule::class))
interface ClassifyComponent {
    fun inject(activity: OpticsActivity)
}