package com.kitsunime.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kitsunime.data.local.dao.KitsuDao
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity

@Database(
    entities =
    [
        AnimeTrendingEntity::class,
        AnimeEntity::class,
        MangaTrendingEntity::class,
        MangaEntity::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(KitsuTypeConverter::class)
abstract class KitsuDatabase : RoomDatabase() {

    abstract fun kitsuDao(): KitsuDao

}