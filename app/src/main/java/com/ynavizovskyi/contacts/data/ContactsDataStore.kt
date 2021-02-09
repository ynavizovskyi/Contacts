package com.ynavizovskyi.contacts.data

interface ContactsDataStore {

    suspend fun load(): List<ContactData>

}