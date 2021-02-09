package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteContactsDataStore @Inject constructor(private val service: ContactsService) :
    ContactsDataStore {

    override suspend fun save(contacts: List<ContactData>) {
        TODO("Not yet implemented")
    }

    override suspend fun load(): List<ContactData> {
        return service.getContacts(50).toContactsData()
    }

    override suspend fun observeAll(): Flow<List<ContactData>> {
        TODO("Not yet implemented")
    }
}