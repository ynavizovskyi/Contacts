package com.ynavizovskyi.contacts.data

import com.ynavizovskyi.contacts.common.LOCAL
import com.ynavizovskyi.contacts.common.REMOTE
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.repository.ContactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class ContactsRepositoryImpl @Inject constructor(
    @Named(LOCAL) private val localStore: ContactsDataStore,
    @Named(REMOTE) private val remoteStore: ContactsDataStore
) : ContactsRepository {

    override suspend fun observeContacts(): Flow<List<Contact>> {
        val contacts = remoteStore.load()
        localStore.save(contacts)

        return localStore.observeAll().map { contacts ->
            contacts.map { it.toDomain() }
        }
    }

    override suspend fun observeContactById(id: Long): Flow<Contact> {
        return localStore.observeById(id).map { it.toDomain() }
    }
}