package com.ynavizovskyi.contacts.data

import com.ynavizovskyi.contacts.common.LOCAL
import com.ynavizovskyi.contacts.common.REMOTE
import com.ynavizovskyi.contacts.domain.entity.Contact
import com.ynavizovskyi.contacts.domain.repository.ContactsRepository
import javax.inject.Inject
import javax.inject.Named

class ContactsRepositoryImpl @Inject constructor(
    @Named(LOCAL) private val localStore: ContactsDataStore,
    @Named(REMOTE) private val remoteStore: ContactsDataStore
) : ContactsRepository {

    override suspend fun load(): List<Contact> {
        return remoteStore.load().map { it.toDomain() }
    }

}