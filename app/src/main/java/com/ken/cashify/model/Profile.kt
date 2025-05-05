package com.ken.cashify.model

import android.net.Uri

data class ProfileUiState(
    val name: String = "",
    val bio: String = "",
    val profileImageUri: Uri? = null
)
