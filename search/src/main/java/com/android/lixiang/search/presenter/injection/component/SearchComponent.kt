package com.android.lixiang.search.presenter.injection.component

import com.android.lixiang.base.injection.ComponentScope
import com.android.lixiang.base.injection.component.ActivityComponent
import com.android.lixiang.search.presenter.injection.module.SearchModule
import com.android.lixiang.search.ui.activity.SearchActivity
import dagger.Component

@ComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(SearchModule::class))
interface SearchComponent {
    fun inject(activity: SearchActivity)
}