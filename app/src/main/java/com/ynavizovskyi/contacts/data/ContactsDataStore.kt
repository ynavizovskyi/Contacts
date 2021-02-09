package com.ynavizovskyi.contacts.data

import com.ynavizovskyi.contacts.domain.entity.Contact
import kotlinx.coroutines.flow.Flow

interface ContactsDataStore {

    suspend fun save(contacts: List<ContactData>)

    suspend fun load(): List<ContactData>

    suspend fun observeAll(): Flow<List<ContactData>>

    suspend fun observeById(id: Long): Flow<ContactData?>

    suspend fun deleteContact(id: Long)

    suspend fun updateContact(contact: ContactData)

}