package com.ynavizovskyi.contacts.data

import com.ynavizovskyi.contacts.domain.entity.Contact

fun ContactData.toDomain() = Contact(firstName, lastName, email, pictureUrl)