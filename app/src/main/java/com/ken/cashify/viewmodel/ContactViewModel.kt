package com.ken.cashify.viewmodel

import kotlinx.coroutines.flow.Flow
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ken.cashify.data.ContactDatabase
import com.ken.cashify.model.Contact
import com.ken.cashify.repository.ContactRepository
import kotlinx.coroutines.launch


class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDao = ContactDatabase.getDatabase(application).contactDao()
    private val repository = ContactRepository(contactDao)

    // Expose contact data as LiveData
    val contact = repository.getContact().asLiveData()

    // Insert a new contact (optional, just in case we need to add a contact)
    fun addContact(contact: Contact) {
        viewModelScope.launch {
            repository.insert(contact)
        }
    }
}
