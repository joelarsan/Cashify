package com.ken.cashify.repository


import com.ken.cashify.data.ProfileDao
import com.ken.cashify.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileRepository(private val dao: ProfileDao) {
    fun getProfile(): Flow<Profile?> = dao.getProfile()

    suspend fun saveProfile(profile: Profile) {
        dao.saveProfile(profile)
    }

    suspend fun deleteProfile(profile: Profile) {
        dao.deleteProfile(profile)
    }
}
