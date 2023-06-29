package com.example.testnewsapp.di

import android.content.Context
import androidx.room.Room
import com.example.testnewsapp.data.remote.NewsApi
import com.example.testnewsapp.data.repository.NewsRepository
import com.example.testnewsapp.db.ArticleDao
import com.example.testnewsapp.db.ArticleDatabase
import com.example.testnewsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        api: NewsApi,
        articleDao: ArticleDao
    ) = NewsRepository(api, articleDao)

    @Provides
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun createDatabase(
        @ApplicationContext context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            ArticleDatabase::class.java,
            "article_db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideArticleDao(appDatabase: ArticleDatabase): ArticleDao {
        return appDatabase.getArticleDao()
    }
}