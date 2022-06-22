package com.kitsunime.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kitsunime.data.remote.dto.Attributes
import com.kitsunime.data.remote.dto.Relationships

class KitsuTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun kitsuRelationshipToString(data: Relationships): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToKitsuRelationship(data: String): Relationships {
        val listType = object : TypeToken<Relationships>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun kitsuAttributesToString(data: Attributes): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToKitsuAttributes(data: String): Attributes {
        val listType = object : TypeToken<Attributes>() {}.type
        return gson.fromJson(data, listType)
    }

}