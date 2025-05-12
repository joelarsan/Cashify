package com.ken.cashify.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(
    @PrimaryKey val id: Int = 0, // Always a single profile, so fixed ID
    val name: String,
    val bio: String,
    val profileImageUri: String? = null
)
