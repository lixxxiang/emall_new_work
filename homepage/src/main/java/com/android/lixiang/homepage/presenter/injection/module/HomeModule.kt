package com.android.lixiang.homepage.presenter.injection.module

import com.android.lixiang.homepage.service.HomeService
import com.android.lixiang.homepage.service.impl.HomeServiceImpl
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideHomeService(service: HomeServiceImpl): HomeService {
        return service
    }
}