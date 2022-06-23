package com.kitsunime.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kitsunime.data.remote.dto.AttributesDto
import com.kitsunime.data.remote.dto.RelationshipsDto
import com.kitsunime.domain.model.KitsuAttributes
import com.kitsunime.domain.model.KitsuRelationships

class KitsuTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun relationshipToString(data: RelationshipsDto): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToRelationship(data: String): RelationshipsDto {
        val listType = object : TypeToken<RelationshipsDto>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun attributesToString(data: AttributesDto): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToAttributes(data: String): AttributesDto {
        val listType = object : TypeToken<AttributesDto>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun kitsuRelationshipToString(data: KitsuRelationships): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToKitsuRelationship(data: String): KitsuRelationships {
        val listType = object : TypeToken<KitsuRelationships>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun kitsuAttributesToString(data: KitsuAttributes): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToKitsuAttributes(data: String): KitsuAttributes {
        val listType = object : TypeToken<KitsuAttributes>() {}.type
        return gson.fromJson(data, listType)
    }

}