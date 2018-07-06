package com.android.lixiang.emall.injection.module

import com.android.lixiang.emall.service.MainService
import com.android.lixiang.emall.service.impl.MainServiceImpl
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @Provides
    fun provideMainService(service: MainServiceImpl): MainService{
        return service
    }
}