package com.kitsunime.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kitsunime.common.Constants.MANGA_ENTITY
import com.kitsunime.data.remote.model.Attributes
import com.kitsunime.data.remote.model.Relationships

@Entity(tableName = MANGA_ENTITY)
data class MangaEntity(
    @PrimaryKey
    var id: String,
    var attributes: Attributes,
    var relationships: Relationships,
    var type: String,
)