package com.ynavizovskyi.contacts.data

import kotlinx.coroutines.flow.Flow

interface ContactsDataStore {

    suspend fun save(contacts: List<ContactData>)

    suspend fun load(): List<ContactData>

    suspend fun observeAll(): Flow<List<ContactData>>

    suspend fun observeById(id: Long): Flow<ContactData>

}