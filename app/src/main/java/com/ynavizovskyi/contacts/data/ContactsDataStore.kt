package com.ynavizovskyi.contacts.data

interface ContactsDataStore {

    suspend fun save(contacts: List<ContactData>)

    suspend fun load(): List<ContactData>

}