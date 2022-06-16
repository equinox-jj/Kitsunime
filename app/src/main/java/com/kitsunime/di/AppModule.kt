package com.kitsunime.di

import com.kitsunime.common.Constants.BASE_URL
import com.kitsunime.data.remote.AnimeService
import com.kitsunime.data.remote.MangaService
import com.kitsunime.data.repository.Repository
import com.kitsunime.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
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
    fun providesAnimeServices(retrofit: Retrofit): AnimeService {
        return retrofit.create(AnimeService::class.java)
    }

    @Singleton
    @Provides
    fun providesMangaServices(retrofit: Retrofit): MangaService {
        return retrofit.create(MangaService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        animeService: AnimeService,
        mangaService: MangaService,
    ): IRepository {
        return Repository(animeService, mangaService)
    }

}