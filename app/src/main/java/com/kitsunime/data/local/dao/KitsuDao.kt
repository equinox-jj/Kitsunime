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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeDao(animeTrendingEntity: List<AnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMangaTrendingDao(animeTrendingEntity: List<MangaTrendingEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMangaDao(animeTrendingEntity: List<MangaEntity>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAnimePagingDao()
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAnimeRemoteKeys()

    @Query("SELECT * FROM anime_trending_table")
    suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity>

    @Query("SELECT * FROM anime_table")
    suspend fun getAnimeDao(): List<AnimeEntity>

    @Query("SELECT * FROM manga_trending_table")
    suspend fun getMangaTrendingDao(): List<MangaTrendingEntity>

    @Query("SELECT * FROM manga_table")
    suspend fun getMangaDao(): List<MangaEntity>

//    @Query("SELECT * FROM ")
//    suspend fun getAnimePagingDao(): List<>
//
//    @Query("SELECT * FROM  WHERE id =:id")
//    suspend fun getAnimeRemoteKeys()

    @Query("DELETE FROM anime_trending_table WHERE id IN(:ids)")
    suspend fun deleteAnimeTrendingIdsDao(ids: List<String>)

    @Query("DELETE FROM anime_table WHERE id IN(:ids)")
    suspend fun deleteAnimeIdsDao(ids: List<String>)

    @Query("DELETE FROM manga_trending_table WHERE id IN(:ids)")
    suspend fun deleteMangaTrendingIdsDao(ids: List<String>)

    @Query("DELETE FROM manga_table WHERE id IN(:ids)")
    suspend fun deleteMangaIdsDao(ids: List<String>)

//    @Query("DELETE FROM ")
//    suspend fun deleteAnimePagingDao()
//
//    @Query("DELETE FROM ")
//    suspend fun deleteAnimeRemoteKeys()

}