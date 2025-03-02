package com.salihakbas.cvmaker.common

import androidx.room.TypeConverter
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.salihakbas.cvmaker.data.model.PersonalInfo
import com.google.gson.Gson

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromPersonalInfoList(personalInfo: List<PersonalInfo>): String {
        return gson.toJson(personalInfo)
    }

    @TypeConverter
    fun toPersonalInfoList(data: String): List<PersonalInfo> {
        val listType = object : TypeToken<List<PersonalInfo>>() {}.type
        return gson.fromJson(data, listType)
    }
}