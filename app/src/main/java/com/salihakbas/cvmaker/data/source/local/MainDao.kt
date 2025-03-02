package com.salihakbas.cvmaker.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salihakbas.cvmaker.data.model.CV
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCV(cv: CV)

    @Query("SELECT * FROM CV")
    fun getAllCVs(): Flow<List<CV>>

    @Query("SELECT * FROM CV WHERE id = :cvId")
    suspend fun getCVById(cvId: Int): CV

    @Delete
    suspend fun deleteCV(cv: CV)


}