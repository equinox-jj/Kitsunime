package com.kitsunime.di

import android.content.Context
import androidx.room.Room
import com.kitsunime.common.Constants.BASE_URL
import com.kitsunime.common.Constants.KITSU_DATABASE
import com.kitsunime.data.local.KitsuDatabase
import com.kitsunime.data.local.dao.KitsuDao
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.data.repository.Repository
import com.kitsunime.domain.repository.IRepository
import com.kitsunime.domain.use_case.UseCases
import com.kitsunime.domain.use_case.anime_use_cases.GetAnimeListUseCase
import com.kitsunime.domain.use_case.anime_use_cases.GetAnimeTrendingListUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaListUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaTrendingListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** NETWORK/RETROFIT */
    @Singleton
    @Provides
    fun providesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesAnimeServices(retrofit: Retrofit): KitsuService {
        return retrofit.create(KitsuService::class.java)
    }

    /** DATABASE */
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        KitsuDatabase::class.java,
        KITSU_DATABASE
    ).build()

    @Singleton
    @Provides
    fun provideRepository(
        kitsuService: KitsuService,
        kitsuDao: KitsuDao,
    ): IRepository {
        return Repository(kitsuService, kitsuDao)
    }

    @Singleton
    @Provides
    fun kitsuDao(database: KitsuDatabase) = database.kitsuDao()

    @Singleton
    @Provides
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAnimeListUseCase = GetAnimeListUseCase(repository),
            getAnimeTrendingListUseCase = GetAnimeTrendingListUseCase(repository),
            getMangaListUseCase = GetMangaListUseCase(repository),
            getMangaTrendingListUseCase = GetMangaTrendingListUseCase(repository)
        )
    }

}