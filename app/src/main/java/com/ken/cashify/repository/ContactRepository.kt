package com.ken.cashify.repository

import com.ken.cashify.data.ContactDao
import com.ken.cashify.model.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {

    fun getContact(): Flow<Contact?> {
        return contactDao.getContact()
    }

    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }
}
