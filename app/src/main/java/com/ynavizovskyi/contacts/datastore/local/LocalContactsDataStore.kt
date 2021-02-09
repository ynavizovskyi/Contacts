package com.ynavizovskyi.contacts.datastore.local

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore

class LocalContactsDataStore : ContactsDataStore {

    override suspend fun load(): List<ContactData> {
        TODO("Not yet implemented")
    }
}