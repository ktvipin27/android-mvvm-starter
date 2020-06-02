package com.ktvipin.mvvmstarter.data.local.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ktvipin.mvvmstarter.data.local.db.entity.Person

class PersonToStringConverter {

    @TypeConverter
    fun stringToPerson(string: String): Person {
        return Gson().fromJson(string, Person::class.java)
    }

    @TypeConverter
    fun personToString(person: Person): String {
        return Gson().toJson(person)
    }
}