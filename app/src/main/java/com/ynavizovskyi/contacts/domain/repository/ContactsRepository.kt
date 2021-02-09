package com.ynavizovskyi.contacts.domain.repository

import com.ynavizovskyi.contacts.domain.entity.Contact

interface ContactsRepository {

    suspend fun load(): List<Contact>

}