package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity

data class Data(
    @SerializedName("id") val id: String,
    @SerializedName("attributes") val attributes: Attributes,
    @SerializedName("relationships") val relationships: Relationships,
    @SerializedName("type") val type: String,
) {
    fun toAnimeTrendingEntity(): AnimeTrendingEntity {
        return AnimeTrendingEntity(
            id = id,
            attributes = attributes,
            relationships = relationships,
            type = type
        )
    }

    fun toAnimeEntity(): AnimeEntity {
        return AnimeEntity(
            id = id,
            attributes = attributes,
            relationships = relationships,
            type = type
        )
    }
}

