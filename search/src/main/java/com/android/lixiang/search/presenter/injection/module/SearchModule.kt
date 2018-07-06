package com.android.lixiang.search.presenter.injection.module

import com.android.lixiang.search.service.SearchService
import com.android.lixiang.search.service.impl.SearchServiceImpl
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    fun provideSearchService(service: SearchServiceImpl): SearchService {
        return service
    }
}