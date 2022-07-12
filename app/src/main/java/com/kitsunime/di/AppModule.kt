package com.kitsunime.di

import android.content.Context
import androidx.room.Room
import com.kitsunime.data.local.KitsuDatabase
import com.kitsunime.data.local.dao.KitsuDao
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.data.repository.AnimeRepository
import com.kitsunime.data.repository.MangaRepository
import com.kitsunime.domain.repository.IAnimeRepository
import com.kitsunime.domain.repository.IMangaRepository
import com.kitsunime.domain.use_case.UseCases
import com.kitsunime.domain.use_case.anime_use_cases.GetAnimeListUseCase
import com.kitsunime.domain.use_case.anime_use_cases.GetAnimePagingUseCase
import com.kitsunime.domain.use_case.anime_use_cases.GetAnimeTrendingListUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaListUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaPagingUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaTrendingListUseCase
import com.kitsunime.presentation.util.Constants.BASE_URL
import com.kitsunime.presentation.util.Constants.KITSU_DATABASE
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
    fun kitsuDao(database: KitsuDatabase) = database.kitsuDao()

    @Singleton
    @Provides
    fun provideAnimeRepository(
        kitsuService: KitsuService,
        kitsuDao: KitsuDao,
    ): IAnimeRepository {
        return AnimeRepository(kitsuService, kitsuDao)
    }

    /** REPOSITORY */
    @Singleton
    @Provides
    fun provideMangaRepository(
        kitsuService: KitsuService,
        kitsuDao: KitsuDao,
    ): IMangaRepository {
        return MangaRepository(kitsuService, kitsuDao)
    }

    /** USE_CASES */
    @Singleton
    @Provides
    fun provideUseCases(animeRepository: AnimeRepository, mangaRepository: MangaRepository): UseCases {
        return UseCases(
            getAnimeListUseCase = GetAnimeListUseCase(animeRepository),
            getAnimeTrendingListUseCase = GetAnimeTrendingListUseCase(animeRepository),
            getAnimePagingUseCase = GetAnimePagingUseCase(animeRepository),
            getMangaListUseCase = GetMangaListUseCase(mangaRepository),
            getMangaTrendingListUseCase = GetMangaTrendingListUseCase(mangaRepository),
            getMangaPagingUseCase = GetMangaPagingUseCase(mangaRepository)
        )
    }

}