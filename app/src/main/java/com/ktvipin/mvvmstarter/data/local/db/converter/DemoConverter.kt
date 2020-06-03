package com.ktvipin.mvvmstarter.data.local.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ktvipin.mvvmstarter.data.local.db.entity.Demo

class DemoConverter {

    @TypeConverter
    fun stringToPerson(string: String): Demo {
        return Gson().fromJson(string, Demo::class.java)
    }

    @TypeConverter
    fun personToString(demo: Demo): String {
        return Gson().toJson(demo)
    }
}