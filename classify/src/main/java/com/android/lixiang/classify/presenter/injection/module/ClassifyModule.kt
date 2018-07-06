package com.android.lixiang.classify.presenter.injection.module

import com.android.lixiang.classify.service.OpticsService
import com.android.lixiang.classify.service.impl.OpticsServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ClassifyModule {

    @Provides
    fun provideOpticsService(service: OpticsServiceImpl): OpticsService {
        return service
    }
}