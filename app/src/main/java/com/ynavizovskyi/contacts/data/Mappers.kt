package com.ynavizovskyi.contacts.data

import com.ynavizovskyi.contacts.domain.entity.Contact

fun ContactData.toDomain() = Contact(id, firstName, lastName, email, pictureUrl)

fun Contact.toData() = ContactData(id, firstName, lastName, email, pictureUrl)