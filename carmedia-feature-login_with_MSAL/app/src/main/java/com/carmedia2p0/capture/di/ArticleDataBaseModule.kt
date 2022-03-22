package com.carmedia2p0.capture.di

import android.content.Context
import androidx.room.Room
import com.carmedia2p0.capture.data.db.ArticleDatabase
import com.carmedia2p0.capture.utils.constant.ApiConstant.ARTICLE_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleDataBaseModule {
    @Singleton
    @Provides
    @ArticleDao
    fun provideArticleDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        ArticleDatabase::class.java,
        ARTICLE_DATABASE_NAME
    ).build()

    @ArticleDao
    @Singleton
    @Provides
    fun provideArticleDao(@ArticleDao db: ArticleDatabase) = db.getArticleDao()
}
