package com.kitsunime.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kitsunime.domain.model.KitsuAttributes
import com.kitsunime.domain.model.KitsuRelationships
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.presentation.util.Constants.ANIME_TRENDING_ENTITY

@Entity(tableName = ANIME_TRENDING_ENTITY)
data class AnimeTrendingEntity(
    @PrimaryKey
    var id: String,
    var attributes: KitsuAttributes?,
    var relationships: KitsuRelationships?,
    var type: String,
) {
    fun toKitsuResult(): KitsuResult {
        return KitsuResult(
            id = id,
            attributes = attributes,
            relationships = relationships,
            type = type
        )
    }
}