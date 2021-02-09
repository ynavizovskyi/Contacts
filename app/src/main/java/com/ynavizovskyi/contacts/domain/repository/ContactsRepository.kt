package com.ynavizovskyi.contacts.domain.repository

import com.ynavizovskyi.contacts.domain.entity.Contact
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {

    suspend fun observeContacts(): Flow<List<Contact>>

}