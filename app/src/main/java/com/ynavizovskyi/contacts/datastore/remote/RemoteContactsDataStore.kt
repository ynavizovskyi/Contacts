package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore
import javax.inject.Inject

class RemoteContactsDataStore @Inject constructor(private val service: ContactsService) : ContactsDataStore{

    override suspend fun load(): List<ContactData> {
        return service.getContacts(10).toContactsData()
    }
}