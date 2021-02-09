package com.ynavizovskyi.contacts.datastore.local

import com.ynavizovskyi.contacts.data.ContactData

fun ContactData.toEntity() = ContactEntity(firstName, lastName, email, pictureUrl)

fun ContactEntity.toData() = ContactData(firstName, lastName, email, pictureUrl)