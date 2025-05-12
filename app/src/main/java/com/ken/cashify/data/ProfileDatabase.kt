package com.ken.cashify.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ken.cashify.model.Contact
import com.ken.cashify.model.Profile

@Database(entities = [Profile::class, Contact::class], version = 1, exportSchema = false)
abstract class ProfileDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ProfileDatabase? = null

        fun getDatabase(context: Context): ProfileDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileDatabase::class.java,
                    "cashify_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
