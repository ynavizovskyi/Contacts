package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore
import com.ynavizovskyi.contacts.domain.entity.Contact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteContactsDataStore @Inject constructor(private val service: ContactsService) :
    ContactsDataStore {

    override suspend fun save(contacts: List<ContactData>) {
        TODO("Not yet implemented")
    }

    override suspend fun load(): List<ContactData> {
        return service.getContacts(10).toContactsData()
    }

    override suspend fun observeAll(): Flow<List<ContactData>> {
        TODO("Not yet implemented")
    }

    override suspend fun observeById(id: Long): Flow<ContactData?> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteContact(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun updateContact(contact: ContactData) {
        TODO("Not yet implemented")
    }
}