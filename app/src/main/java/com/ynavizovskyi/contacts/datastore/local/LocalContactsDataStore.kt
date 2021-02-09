package com.ynavizovskyi.contacts.datastore.local

import com.ynavizovskyi.contacts.data.ContactData
import com.ynavizovskyi.contacts.data.ContactsDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalContactsDataStore @Inject constructor(private val contactDao: ContactDao) :
    ContactsDataStore {

    override suspend fun save(contacts: List<ContactData>) {
        val contactEntities = contacts.map { it.toEntity() }
        contactDao.deleteAll()
        contactDao.insert(contactEntities)
    }

    override suspend fun load(): List<ContactData> {
        return contactDao.selectAll().map { it.toData() }
    }

    override suspend fun observeAll(): Flow<List<ContactData>> {
        return contactDao.observeAll().map { contacts ->
            contacts.map { it.toData() }
        }
    }

    override suspend fun observeById(id: Long): Flow<ContactData> {
        return contactDao.observeById(id).map { it.toData() }
    }
}