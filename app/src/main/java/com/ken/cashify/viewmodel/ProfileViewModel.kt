package com.ken.cashify.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ken.cashify.model.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {
    private val _uiState = mutableStateOf(ProfileUiState())
    val uiState = MutableStateFlow(ProfileUiState())

    fun updateName(newName: String) {
        _uiState.value = _uiState.value.copy(name = newName)
    }

    fun updateBio(newBio: String) {
        _uiState.value = _uiState.value.copy(bio = newBio)
    }

    fun saveProfile() {
        // Add save logic here
        println("Profile saved: ${_uiState.value}")
    }

    fun editProfile() {
        // Enable fields if you want to disable them by default
        println("Edit profile clicked")
    }

    fun logout() {
        // Add logout logic
        println("Logged out")
    }
    fun updateProfileImage(uri: Uri) {
        _uiState.value = _uiState.value.copy(profileImageUri = uri)
    }
}
