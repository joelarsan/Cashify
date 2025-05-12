package com.ken.cashify.data

import androidx.room.*
import com.ken.cashify.model.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profile WHERE id = 0")
    fun getProfile(): Flow<Profile?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)
}
