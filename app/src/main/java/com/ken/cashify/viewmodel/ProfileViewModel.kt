package com.ken.cashify.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ken.cashify.data.ProfileDatabase
import com.ken.cashify.model.Profile
import com.ken.cashify.repository.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

data class ProfileUiState(
    val name: String = "",
    val bio: String = "",
    val profileImageUri: Uri? = null
)

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: ProfileRepository

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState

    init {
        val dao = ProfileDatabase.getDatabase(application).profileDao()
        repo = ProfileRepository(dao)
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            repo.getProfile().collect { profile ->
                profile?.let {
                    _uiState.value = ProfileUiState(
                        name = it.name,
                        bio = it.bio,
                        profileImageUri = it.profileImageUri?.let(Uri::parse)
                    )
                }
            }
        }
    }

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun updateBio(bio: String) {
        _uiState.value = _uiState.value.copy(bio = bio)
    }

    fun updateProfileImage(uri: Uri) {
        _uiState.value = _uiState.value.copy(profileImageUri = uri)
    }

    fun saveProfile() {
        viewModelScope.launch {
            val current = _uiState.value
            val profile = Profile(
                id = 0,
                name = current.name,
                bio = current.bio,
                profileImageUri = current.profileImageUri?.toString()
            )
            repo.saveProfile(profile)
        }
    }

    fun editProfile() {
        // No-op for now, but you could set edit state here
    }

    fun logout() {
        viewModelScope.launch {
            val current = _uiState.value
            val profile = Profile(
                id = 0,
                name = current.name,
                bio = current.bio,
                profileImageUri = current.profileImageUri?.toString()
            )
            repo.deleteProfile(profile)
            _uiState.value = ProfileUiState()
        }
    }
}
