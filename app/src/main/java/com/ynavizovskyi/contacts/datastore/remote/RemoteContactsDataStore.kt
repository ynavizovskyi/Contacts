package com.ynavizovskyi.contacts.datastore.remote

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore

class RemoteContactsDataStore(private val service: ContactsService) : ContactsDataStore{

    override suspend fun load(): List<ContactData> {
        return service.getContacts(10).toContactsData()
    }
}