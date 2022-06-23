package com.kitsunime.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity

@Dao
interface KitsuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeTrendingDao(animeTrendingEntity: List<AnimeTrendingEntity>)

    @Query("SELECT * FROM anime_trending_table")
    suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity>

    @Query("DELETE FROM anime_trending_table WHERE id IN(:ids)")
    suspend fun deleteAnimeTrendingIdsDao(ids: List<String>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeDao(animeTrendingEntity: List<AnimeEntity>)

    @Query("SELECT * FROM anime_table")
    suspend fun getAnimeDao(): List<AnimeEntity>

    @Query("DELETE FROM anime_table WHERE id IN(:ids)")
    suspend fun deleteAnimeIdsDao(ids: List<String>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMangaTrendingDao(animeTrendingEntity: List<MangaTrendingEntity>)

    @Query("SELECT * FROM manga_trending_table")
    suspend fun getMangaTrendingDao(): List<MangaTrendingEntity>

    @Query("DELETE FROM manga_trending_table WHERE id IN(:ids)")
    suspend fun deleteMangaTrendingIdsDao(ids: List<String>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMangaDao(animeTrendingEntity: List<MangaEntity>)

    @Query("SELECT * FROM manga_table")
    suspend fun getMangaDao(): List<MangaEntity>

    @Query("DELETE FROM manga_table WHERE id IN(:ids)")
    suspend fun deleteMangaIdsDao(ids: List<String>)

}