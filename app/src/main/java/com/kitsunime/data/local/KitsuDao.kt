package com.kitsunime.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity

@Dao
interface KitsuDao {
    // Anime Trending
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeTrendingDao(animeTrendingEntity: List<AnimeTrendingEntity>)

    @Query("SELECT * FROM anime_trending_entity")
    suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity>

    @Query("DELETE FROM anime_trending_entity WHERE id IN(:ids)")
    suspend fun deleteAnimeTrendingIdsDao(ids: List<String>)

    // Anime
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeDao(animeTrendingEntity: List<AnimeEntity>)

    @Query("SELECT * FROM anime_entity")
    suspend fun getAnimeDao(): List<AnimeEntity>

    @Query("DELETE FROM anime_entity WHERE id IN(:ids)")
    suspend fun deleteAnimeIdsDao(ids: List<String>)

}