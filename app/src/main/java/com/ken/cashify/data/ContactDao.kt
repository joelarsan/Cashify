package com.ken.cashify.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ken.cashify.model.Contact
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {
    @Insert
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM Contact LIMIT 1")
    fun getContact(): Flow<Contact?>
}
