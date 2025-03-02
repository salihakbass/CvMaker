package com.salihakbas.cvmaker.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.salihakbas.cvmaker.common.Converters
import com.salihakbas.cvmaker.data.model.CV
import com.salihakbas.cvmaker.data.model.MainEntityModel

@Database(entities = [CV::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MainRoomDB : RoomDatabase() {
    abstract fun mainDao(): MainDao
}