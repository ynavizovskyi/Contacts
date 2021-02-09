package com.ynavizovskyi.contacts.datastore.local

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore
import javax.inject.Inject

class LocalContactsDataStore @Inject constructor() : ContactsDataStore {

    override suspend fun load(): List<ContactData> {
        TODO("Not yet implemented")
    }
}