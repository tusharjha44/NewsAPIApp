package com.example.latestnewsapp.data.db

import androidx.room.TypeConverter
import com.example.latestnewsapp.data.model.Source


class Convertors {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name,name)
    }
}