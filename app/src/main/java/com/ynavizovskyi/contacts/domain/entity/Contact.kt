package com.ynavizovskyi.contacts.domain.entity

data class Contact(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val pictureUrl: String
)