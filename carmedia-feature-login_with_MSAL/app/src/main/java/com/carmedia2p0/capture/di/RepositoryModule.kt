package com.carmedia2p0.capture.di

import com.carmedia2p0.capture.data.db.ArticleDao
import com.carmedia2p0.capture.data.network.api.CarmediaApi
import com.carmedia2p0.capture.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(@com.carmedia2p0.capture.di.ArticleDao dao: ArticleDao, carMediaApi: CarmediaApi): DataRepository {
        return DataRepository(dao, carMediaApi)
    }
}
